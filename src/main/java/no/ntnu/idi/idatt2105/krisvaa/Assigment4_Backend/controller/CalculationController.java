package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.controller;

import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model.CalculationRequest;
import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model.CalculationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculate")
@EnableAutoConfiguration
@CrossOrigin
public class CalculationController {

    private final Logger logger = LoggerFactory.getLogger("Calculation Controller");

    @PostMapping("")
    public CalculationResponse calculate(@RequestBody CalculationRequest calculation) {
        logger.info("Received calculation request with the following data: " + calculation);
        CalculationResponse response = new CalculationResponse(calculation);

        logger.info("Returning the following data to client: " + response);
        return response;
    }
}
