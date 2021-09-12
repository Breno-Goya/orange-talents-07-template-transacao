package br.com.zupacademy.transacoes.externa;

import br.com.zupacademy.transacoes.transaction.Cartao;

public class CartaoMessage {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toCartao() {
        return new Cartao(id, email);
    }
}
