package br.com.zupacademy.transacoes.consultas;

import br.com.zupacademy.transacoes.transaction.Cartao;
import br.com.zupacademy.transacoes.transaction.Transacao;
import br.com.zupacademy.transacoes.transaction.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ConsultasController {

    private final Logger logger = LoggerFactory.getLogger(ConsultasController.class);

    private final TransacaoRepository transacaoRepository;
    private final CartaoRepository cartaoRepository;

    public ConsultasController(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @GetMapping("/api/cartoes/{id}/transacoes")
    public ResponseEntity<Page<TransacaoResponse>> buscarUltimasTransacoes (
            @PathVariable String id,
            @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {

        logger.info("MÉTODO: buscarUltimasTransacoes, MENSAGEM: ID DO CARTAO: {}",id);

        Optional<Cartao> possivelCartao = cartaoRepository.findById(UUID.fromString(id));

        if(possivelCartao.isPresent()) {
            Cartao cartao = possivelCartao.get();

            Page<Transacao> paginasDeTransacoes = transacaoRepository.findByCartaoIdApi(cartao.getIdApi(), pageable);
            Page<TransacaoResponse> response = TransacaoResponse.convert(paginasDeTransacoes);
            return ResponseEntity.ok().build();
        }

        logger.error("MÉTODO: buscarUltimasTransacoes, MENSAGEM: CARTAO: {} NAO ENCONTRADO ", id);
        return ResponseEntity.notFound().build();
    }
}
