package br.com.zupacademy.transacoes.externa;

import br.com.zupacademy.transacoes.transaction.Estabelecimento;

public class EstabelecimentoMessage {

    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
