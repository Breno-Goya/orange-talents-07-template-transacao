package br.com.zupacademy.transacoes.transaction;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Cartao {

    @Id @GeneratedValue(generator = "UUID") @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String idApi;
    private String email;

    @OneToMany(mappedBy = "cartao")
    private List<Transacao> transacaoes;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idApi, String email) {
        this.idApi = idApi;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getIdApi() {
        return idApi;
    }

    public String getEmail() {
        return email;
    }

    public List<Transacao> getTransacaoes() {
        return transacaoes;
    }
}
