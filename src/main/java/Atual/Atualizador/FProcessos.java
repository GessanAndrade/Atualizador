package Atual.Atualizador;

import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import banco.FBancoDadosExecucao;
import banco.FObjetosBancoDados;
import kong.unirest.HttpResponse;
import types.FArquivos;
import types.FScripts;

public class FProcessos {
	private FVersao vVersao;

	public String executeScripts() {
		vVersao = null;
		HttpResponse<String> response = FApi.getResponseApi();

		if (response.getStatus() == 200) {
			String jsonResponse = response.getBody();

			vVersao = new FVersao();

			JsonObject vInformacoes = new Gson().fromJson(jsonResponse, JsonObject.class);

			JsonArray tabelas = vInformacoes.getAsJsonArray("tabelas");
			JsonArray procedures = vInformacoes.getAsJsonArray("procedures");

			vVersao.setvVersao(vInformacoes.get("versao").getAsString());

			for (JsonElement tabela : tabelas) {
				vVersao.getvTabelas().add(tabela.getAsString());
			}

			for (JsonElement procedure : procedures) {
				vVersao.getvProcedures().add(procedure.getAsString());
			}

			return executeBanco(vVersao);

		} else {
			System.out.println();
			return "Erro ao acessar API. Código de status: " + response.getStatus();
		}
	}

	private String executeBanco(FVersao vVersaoObj) {

		FArquivos vArq = new FArquivos();
		FObjetosBancoDados vBanco = vArq.importarConfig();
		FBancoDadosExecucao vBExecucao = new FBancoDadosExecucao();
		try {
			vBExecucao.abrirConexao(vBanco);
			try {
				if (vBExecucao.existeVersaoOracle(vVersaoObj.getvVersao())) {
					vBExecucao.applyCommand(FScripts.cDelete);
				}

				for (String vContent : vVersaoObj.getvTabelas()) {
					vBExecucao.applyCommand(vContent);
				}

				for (String vContent : vVersaoObj.getvProcedures()) {
					vBExecucao.applyCommand(vContent);
				}

				vBExecucao.applyCommandVersion(vVersaoObj.getvVersao());
				return "Versao: " + vVersaoObj.getvVersao() + " aplicada com sucesso.";

			} finally {
				vBExecucao.fecharConexao();
			}

		} catch (SQLException e) {
			return "erro na execucao do Oracle: " + e.getMessage();
		}

	}

}
