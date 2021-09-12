package br.com.zupacademy.transacoes.externa;

import br.com.zupacademy.transacoes.transaction.Cartao;
import br.com.zupacademy.transacoes.transaction.Estabelecimento;
import br.com.zupacademy.transacoes.transaction.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMessage {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoMessage estabelecimento;
    private CartaoMessage cartao;
    private String efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoMessage getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoMessage getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toTransaction() {
        Estabelecimento estabelecimento = this.estabelecimento.toEstabelecimento();
        Cartao cartao = this.cartao.toCartao();
        return new Transacao(id, valor,estabelecimento, cartao, LocalDateTime.parse(efetivadaEm));
    }
}
