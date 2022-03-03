package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculationRequest {

    private final double num1;
    private final Operator operator;
    private final double num2;

    @JsonCreator
    public CalculationRequest(
            @JsonProperty("first_number") final double num1,
            @JsonProperty("operator") final Operator operator,
            @JsonProperty("second_number") final double num2
    ) {
        this.num1 = num1;
        this.operator = operator;
        this.num2 = num2;
    }

    protected double calculate() {
        switch (operator) {
            case Plus:
                return num1 + num2;
            case Minus:
                return num1 - num2;
            case Divide:
                return num1 / num2;
            case Times:
                return num1 * num2;
        }

        return 0;
    }

    @JsonProperty("first_number")
    public double getNum1() {
        return num1;
    }

    @JsonProperty("operator")
    public Operator getOperator() {
        return operator;
    }

    @JsonProperty("second_number")
    public double getNum2() {
        return num2;
    }

    @Override
    public String toString() {
        return "CalculationRequest{" +
                "num1=" + num1 +
                ", operator=" + operator +
                ", num2=" + num2 +
                '}';
    }
}

enum Operator {
    Plus, Minus, Divide, Times;

    /*public static Operator parseOperator(char o) throws Exception {
        switch (o) {
            case '+': return Plus;
            case '-': return Minus;
            case '/': return Divide;
            case '*': return Times;
            default: {
                throw new Exception("Unable to parse operator from " + o);
            }
        }
    }*/
}
