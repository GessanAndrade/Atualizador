package interfaces;

import java.sql.SQLException;
import banco.FObjetosBancoDados;

public interface IBancoDados {
 public boolean abrirConexao(FObjetosBancoDados objBanco);
 public void fecharConexao() throws SQLException;
 public boolean existeVersaoOracle(String vCodVersao) throws SQLException;
 public void applyCommand(String vCommand) throws SQLException;
}
