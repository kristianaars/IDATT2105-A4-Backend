package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.service;

import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model.Calculation;
import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {


    @Autowired
    private CalculatorRepository calculatorRepository;

    public Calculation calculate(Calculation calculation, long forUserId) {
        double answer = 0;
        double firstNumber = calculation.getFirstNumber();
        double secondNumber = calculation.getSecondNumber();

        switch (calculation.getOperator()) {
            case '+':
                answer = firstNumber + secondNumber;
                break;
            case '-':
                answer = firstNumber - secondNumber;
                break;
            case '/':
                answer = firstNumber / secondNumber;
                break;
            case '*':
                answer = firstNumber * secondNumber;
                break;
        }

        calculation.setUser_id(forUserId);
        calculation.setAnswer(answer);

        return calculatorRepository.save(calculation);
    }
}
