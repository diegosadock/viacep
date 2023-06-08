package br.com.diegosvp.viacep.model;

public record EnderecoViaCep(String cep, String logradouro, String complemento, String bairro, String localidade
, int ddd) {
}

