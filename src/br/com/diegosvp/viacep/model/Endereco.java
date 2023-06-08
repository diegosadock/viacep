package br.com.diegosvp.viacep.model;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private int ddd;

    public Endereco(EnderecoViaCep meuEnderecoViaCep) {
        this.cep = meuEnderecoViaCep.cep();
        this.logradouro = meuEnderecoViaCep.logradouro();
        this.complemento = meuEnderecoViaCep.complemento();
        this.bairro = meuEnderecoViaCep.bairro();
        this.localidade = meuEnderecoViaCep.localidade();
        this.ddd = Integer.valueOf(meuEnderecoViaCep.ddd());

    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public int getDdd() {
        return ddd;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", ddd=" + ddd +
                '}';
    }
}
