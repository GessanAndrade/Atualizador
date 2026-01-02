package Atual.Atualizador;

import java.util.ArrayList;
import java.util.List;

public class FVersao {
 private String vVersao;
 private List<String> vTabelas;
 private List<String> vProcedures;
 
 public FVersao() {
	 setvVersao("1.0.0");
	 setvTabelas(new ArrayList<String>());
	 setvProcedures(new ArrayList<String>());
 }
 
public String getvVersao() {
	return vVersao;
}
public void setvVersao(String vVersao) {
	this.vVersao = vVersao;
}
public List<String> getvTabelas() {
	return vTabelas;
}
private void setvTabelas(List<String> vTabelas) {
	this.vTabelas = vTabelas;
}
public List<String> getvProcedures() {
	return vProcedures;
}
private void setvProcedures(List<String> vProcedures) {
	this.vProcedures = vProcedures;
}
 
 
}
