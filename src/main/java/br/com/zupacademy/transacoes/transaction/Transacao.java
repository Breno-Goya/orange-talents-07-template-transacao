package br.com.zupacademy.transacoes.transaction;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacao {

    @Id @GeneratedValue(generator = "UUID") @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String idApi;

    private BigDecimal valor;

    @Embedded
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    private LocalDateTime afetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idApi, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime afetivadaEm) {
        this.idApi = idApi;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.afetivadaEm = afetivadaEm;
    }
}
