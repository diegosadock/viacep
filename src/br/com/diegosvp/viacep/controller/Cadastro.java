package br.com.diegosvp.viacep.controller;

import br.com.diegosvp.viacep.model.Endereco;
import br.com.diegosvp.viacep.model.EnderecoViaCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Cadastro {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o seu CEP para consultar dados do seu endereço: ");
        String dadosEndereco = leitura.nextLine();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String apiViaCep = "https://viacep.com.br/ws/" + dadosEndereco.replace("-", "") + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiViaCep))
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = (String) response.body();
        System.out.println(json);

        EnderecoViaCep meuEnderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
        Endereco meuEndereco = new Endereco(meuEnderecoViaCep);
        System.out.println(meuEndereco);

        FileWriter escrita = new FileWriter("endereço.json");
        escrita.write(gson.toJson(meuEnderecoViaCep));
        escrita.close();


    }
}
