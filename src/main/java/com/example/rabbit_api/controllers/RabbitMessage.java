package com.example.rabbit_api.controllers;


import com.example.rabbit_api.services.AddMessageToRabbit;
import com.example.rabbit_api.services.RegionValidator;
import com.example.rabbit_api.models.Case;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;


@RestController
@RequestMapping("/rabbit/")
public class RabbitMessage {
    @PostMapping("/message")
    public ResponseEntity saveMessage(@RequestBody Case newMessage,
                                      @RequestHeader Map<String, String> headers) throws IOException, TimeoutException {
        AddMessageToRabbit am = new AddMessageToRabbit();
        //String routingKey = headers.get("routingkey") ;
        RegionValidator regionValidator = new RegionValidator(newMessage.getCustomerId());
        String routingKey = regionValidator.Validate();

        if (routingKey == null) {
            return new ResponseEntity("Empty Header \"routingkey\" ", HttpStatus.BAD_REQUEST);
        }
        try {
            am.SendMessage(newMessage, routingKey );
        }
        catch(TimeoutException  e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Congratulations", HttpStatus.OK) ;
    }

}
