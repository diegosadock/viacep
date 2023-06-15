package br.com.diegosvp.viacep.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class LerCep {
    public String consultaCEP() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o seu CEP para consultar dados do seu endereço: ");
        String dadosEndereco = leitura.nextLine();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return dadosEndereco;
    }
}
