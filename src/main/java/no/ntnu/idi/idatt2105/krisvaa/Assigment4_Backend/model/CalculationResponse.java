package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculationResponse {

    private final Calculation calculation;
    private final double answer;

    @JsonCreator
    public CalculationResponse(@JsonProperty("calculation") Calculation calculation, @JsonProperty("answer") double answer) {
        this.calculation = calculation;
        this.answer = answer;
    }

    @JsonProperty("calculation")
    public Calculation getCalculation() {
        return calculation;
    }

    @JsonProperty("answer")
    public double getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "CalculationResponse{" +
                "calculation=" + calculation +
                ", answer=" + answer +
                '}';
    }
}
