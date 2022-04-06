package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.controller;

import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model.Calculation;
import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/calculation")
@EnableAutoConfiguration
@CrossOrigin
public class CalculationController {

    private final Logger logger = LoggerFactory.getLogger("Calculation Controller");

    @Autowired
    private CalculationService calculationService;

    @PostMapping("")
    public Calculation calculate(
            @RequestBody Calculation calculation,
            Principal principal
    ) {
        return calculationService.calculate(calculation, Integer.parseInt(principal.getName()));
    }

    @GetMapping("")
    public List<Calculation> getCalculations(
            Principal principal
    ) {
        return calculationService.getAllCalculationsForUser(Integer.parseInt(principal.getName()));
    }
}
