package Atual.Atualizador;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class FApi {

    public static HttpResponse<String> getResponseApi() {

		HttpResponse<String> response = Unirest.get("https://mock-99130feab00c4b1b8b30504e58000719.mock.insomnia.rest/usuario")
                .header("Content-Type", "application/json")
                .header("User-Agent", "insomnia/11.0.0")
                .asString();
        
        return response;
    }
}
