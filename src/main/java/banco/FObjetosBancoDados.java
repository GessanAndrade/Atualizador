package banco;

public class FObjetosBancoDados {

	private String vHost, 
				   vInstance, 
				   vUser, 
				   vPassword, 
				   vPort;
	
	public FObjetosBancoDados(String vHost, 
							 String vInstance, 
							 String vUser, 
							 String vPassword, 
							 String vPort){
     	this.vHost     = vHost;
		this.vInstance = vInstance; 
		this.vUser     = vUser;
		this.vPassword = vPassword; 
		this.vPort     = vPort;
	}

	public String getvHost() {
		return vHost;
	}
	
	public String getvInstance() {
		return vInstance;
	}

	public String getvUser() {
		return vUser;
	}

	public String getvPassword() {
		return vPassword;
	}

	public String getvPort() {
		return vPort;
	}
	
	public String getUrlOracle() {
		return "jdbc:oracle:thin:@"+vHost+":"+vPort+"/"+vInstance;
	}
	
	
}
