package br.com.zupacademy.transacoes.consultas;

import br.com.zupacademy.transacoes.transaction.Estabelecimento;

public class EstabelecimentoResponse {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoResponse(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public static EstabelecimentoResponse convert(Estabelecimento estabelecimento) {
        return new EstabelecimentoResponse(estabelecimento);
    }
}
