package br.com.diegosvp.viacep.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoApi {
    public String fazerRequisicaoApi() throws IOException, InterruptedException {
        LerCep lerCep = new LerCep();
        String apiViaCep = "https://viacep.com.br/ws/" + lerCep.consultaCEP().replace("-", "") + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiViaCep))
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = (String) response.body();
        return json;
    }


}
