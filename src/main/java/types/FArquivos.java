package types;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import banco.FObjetosBancoDados;
import interfaces.IArquivos;

public class FArquivos implements IArquivos{
	
	private FObjetosBancoDados bancoConfig;
	
	private String getAsJsonObject(String vCampo, JsonObject vObjeto){
		return vObjeto.getAsJsonObject("databases")
                .getAsJsonObject("default")
                .get(vCampo).getAsString();
	}
	
	private JsonObject setObjectReader() throws FileNotFoundException {
		FileReader reader = new FileReader(new File("").getAbsolutePath() + "/config/app.json");
        return JsonParser.parseReader(reader).getAsJsonObject();
	}
	
	@Override
	public FObjetosBancoDados importarConfig() {
		try {

            JsonObject jsonObject = setObjectReader();

            bancoConfig  = new FObjetosBancoDados(getAsJsonObject("host", jsonObject),
            									  getAsJsonObject("instance", jsonObject),
            									  getAsJsonObject("user", jsonObject),
            									  getAsJsonObject("password", jsonObject),
            									  getAsJsonObject("port", jsonObject));
        } catch (Exception e) {
            e.printStackTrace();
            
        }
		
	    return bancoConfig;
	}

}
