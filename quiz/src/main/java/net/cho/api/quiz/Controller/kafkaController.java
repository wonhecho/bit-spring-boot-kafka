package net.cho.api.quiz.Controller;

import lombok.RequiredArgsConstructor;
import net.cho.api.quiz.domain.Producers;
import net.cho.api.quiz.service.KafkaSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class kafkaController {
    private final KafkaSender kafkaSender;
    private final Producers producers;

    @GetMapping
    public String hello(){
        return "Hello Kafka";
    }

    @GetMapping("/producer")
    public String producer(@RequestParam("message") String message){
        System.out.println("######## producer 진입 #############");
        kafkaSender.send(message);
        return "Message sent to Kafka Successfully";
    }
    @GetMapping("/receiver")
    public void receiver(){
       producers.SendMessage("kafka-test","Good-Luck !!");
    }
}
