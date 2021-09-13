package br.com.zupacademy.transacoes.consultas;

import br.com.zupacademy.transacoes.transaction.Cartao;

public class CartaoResponse {

    private String id;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getId().toString();
        this.email = cartao.getEmail();
    }

    public static CartaoResponse convert(Cartao cartao) {
        return new CartaoResponse(cartao);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
