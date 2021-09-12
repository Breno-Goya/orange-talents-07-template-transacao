package br.com.zupacademy.transacoes.transaction;

import br.com.zupacademy.transacoes.externa.TransacaoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private final Logger logger = LoggerFactory.getLogger(TransacaoService.class);

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listener(TransacaoMessage transacaoMessage) {
        Transacao transacao = transacaoMessage.toTransaction();
        repository.save(transacao);
        logger.info("Transação: {}, feita", transacaoMessage.getId());
    }
}
