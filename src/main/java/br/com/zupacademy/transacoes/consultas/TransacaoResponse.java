package br.com.zupacademy.transacoes.consultas;

import br.com.zupacademy.transacoes.transaction.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId().toString();
        this.valor = transacao.getValor();
        this.estabelecimento = EstabelecimentoResponse.convert(transacao.getEstabelecimento());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public static Page<TransacaoResponse> convert(Page<Transacao> transacoesPaginadas) {
        return transacoesPaginadas.map(TransacaoResponse::new);
    }
}
