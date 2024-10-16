package br.com.comunicador.adapter.out.kafka.producer;

import br.com.comunicador.adapter.out.kafka.producer.mapper.ComunicacaoEventMapper;
import br.com.comunicador.application.domain.Comunicacao;
import br.com.comunicador.application.ports.out.event.ComunicarMensagemEventPort;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ComunicarMensagemEventPortImpl implements ComunicarMensagemEventPort {

    @Value("${spring.kafka.producer.topic}")
    private String topicProducer;

    private final KafkaTemplate<String, GenericRecord> kafkaTemplate;

    private final ComunicacaoEventMapper mapper;

    @Autowired
    public ComunicarMensagemEventPortImpl(KafkaTemplate<String, GenericRecord> kafkaTemplate, ComunicacaoEventMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    @Override
    public void enviar(Comunicacao comunicacao) {
        byte[] correlationId = UUID.randomUUID().toString().getBytes();
        ProducerRecord<String, GenericRecord> record = new ProducerRecord<>(topicProducer, UUID.randomUUID().toString(), mapper.map(comunicacao));

        record.headers().add(new RecordHeader(org.springframework.kafka.support.KafkaHeaders.CORRELATION_ID, correlationId));

        kafkaTemplate.send(record);
    }
}
