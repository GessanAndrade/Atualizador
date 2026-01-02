package types;

public class FScripts {
	
	public final static String cSelectExists = "SELECT count(*) as QTD FROM TSYS_VERSAO_PDV WHERE TSYS_VERSAO_PDV.TSYS_CODIGO_VERSAO = ?;";
	public final static String cDelete       = "DELETE FROM TSYS_VERSAO_PDV;";
	public final static String cInsertVersion =  "INSERT INTO TSYS_VERSAO_PDV (TSYS_CODIGO_VERSAO, TSYS_DATA_VERSAO) VALUES (?, ?)";

}
