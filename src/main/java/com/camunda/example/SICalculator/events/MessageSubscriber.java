package com.camunda.example.SICalculator.events;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSubscriber {

    private final ProcessEngine processEngine;

    /**
     Here we can consume the message from external queues like Kafka/rabbit MQ
     Create internal Object to use it in the upcoming process
     for our purpose we are just using ID which will passed to communicate to the parser
     **/
    public void listenMessage(){

        System.out.println("Message received");

        VariableMap variables = Variables.putValue("id","124");
        /**
         Start the process Message Parser by passing the variable id
         */
        processEngine.getRuntimeService().startProcessInstanceByKey("message_parser",variables);

    }
}
