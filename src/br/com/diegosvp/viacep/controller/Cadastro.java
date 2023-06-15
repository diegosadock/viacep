package br.com.diegosvp.viacep.controller;

import br.com.diegosvp.viacep.model.Endereco;
import br.com.diegosvp.viacep.model.EnderecoViaCep;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Cadastro {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        RequisicaoApi requisicaoApi = new RequisicaoApi();

        EnderecoViaCep meuEnderecoViaCep = gson.fromJson(requisicaoApi.fazerRequisicaoApi(), EnderecoViaCep.class);
        Endereco meuEndereco = new Endereco(meuEnderecoViaCep);
        System.out.println(meuEndereco);

        FileWriter escrita = new FileWriter("endereço.json");
        escrita.write(gson.toJson(meuEnderecoViaCep));
        escrita.close();

    }

}

