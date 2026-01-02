package banco;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.IBancoDados;
import types.FScripts;

public class FBancoDadosExecucao implements IBancoDados {
	private Connection conn;

	public FBancoDadosExecucao() {

	}

	@Override
	public boolean abrirConexao(FObjetosBancoDados objBanco) {
		try {
			conn = DriverManager.getConnection(objBanco.getUrlOracle(), objBanco.getvUser(), objBanco.getvPassword());
			if (conn != null) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void fecharConexao() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

	public boolean existeVersaoOracle(String vCodVersao) throws SQLException {

		PreparedStatement pstmt = conn.prepareStatement(FScripts.cSelectExists);

		pstmt.setString(1, vCodVersao);

		try (ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				int quantidade = rs.getInt("QTD");
				return quantidade > 0;
			}
		}
		return false;
	}

	public void applyCommand(String vCommand) throws SQLException {

		PreparedStatement stmtCommand = conn.prepareStatement(vCommand);
		stmtCommand.executeUpdate();

	}
	
	public void applyCommandVersion(String vVersion) throws SQLException {

		PreparedStatement stmtCommand = conn.prepareStatement(FScripts.cInsertVersion);
		java.sql.Timestamp dataVersao = new java.sql.Timestamp(System.currentTimeMillis());
		stmtCommand.setString(1, vVersion);
		stmtCommand.setTimestamp(2, dataVersao);
		stmtCommand.executeUpdate();

	}
}
