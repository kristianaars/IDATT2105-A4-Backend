package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public class CalculationRequest {

    private final double firstNumber;
    private final Operator operator;
    private final double secondNumber;

    @JsonCreator
    public CalculationRequest(
            @JsonProperty("first_number") final double num1,
            @JsonProperty("operator") final Operator operator,
            @JsonProperty("second_number") final double num2
    ) {
        this.firstNumber = num1;
        this.operator = operator;
        this.secondNumber = num2;
    }

    protected double calculate() {
        switch (operator) {
            case Plus:
                return firstNumber + secondNumber;
            case Minus:
                return firstNumber - secondNumber;
            case Divide:
                return firstNumber / secondNumber;
            case Times:
                return firstNumber * secondNumber;
        }

        return 0;
    }

    @JsonProperty("first_number")
    public double getFirstNumber() {
        return firstNumber;
    }

    @JsonProperty("operator")
    public Operator getOperator() {
        return operator;
    }

    @JsonProperty("second_number")
    public double getSecondNumber() {
        return secondNumber;
    }

    @Override
    public String toString() {
        return "CalculationRequest{" +
                "num1=" + firstNumber +
                ", operator=" + operator +
                ", num2=" + secondNumber +
                '}';
    }
}

enum Operator {
    Plus('+'), Minus('-'), Divide('/'), Times('x');

    private char sign;

    private Operator(char sign) {
        this.sign = sign;
    }

    @JsonCreator
    public static Operator decode(final char sign) {
        return Arrays.stream(Operator.values()).filter(operator -> operator.sign == sign).findFirst().orElse(null);
    }

    @JsonValue
    public char getSign() {
        return sign;
    }

}
