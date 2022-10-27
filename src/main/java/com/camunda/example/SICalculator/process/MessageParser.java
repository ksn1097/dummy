package com.camunda.example.SICalculator.process;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.internal.tool.Main;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.feel.syntaxtree.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class MessageParser implements JavaDelegate {

    @Autowired
    private WebClient webClient;

    @Autowired
    private ObjectMapper objectMapper;

    private final String baseUrl="localhost:9090/initiate/getEmployee";
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Integer id = (Integer)delegateExecution.getVariable("id");


        Object response = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(baseUrl).queryParam("id",id).build())
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        final String s = objectMapper.writeValueAsString(response);
        System.out.println(s);
        System.out.println(response);

    }


}
