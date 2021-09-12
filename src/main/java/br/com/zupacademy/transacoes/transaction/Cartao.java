package br.com.zupacademy.transacoes.transaction;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Cartao {

    @Id @GeneratedValue(generator = "UUID") @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String idApi;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idApi, String email) {
        this.idApi = idApi;
        this.email = email;
    }
}
