package br.com.zupacademy.transacoes.consultas;

import br.com.zupacademy.transacoes.transaction.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
}
