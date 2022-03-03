package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculationResponse {

    private final CalculationRequest calculation;
    private final double answer;

    @JsonCreator
    public CalculationResponse(@JsonProperty("calculation") CalculationRequest calculation) {
        this.calculation = calculation;
        this.answer = calculation.calculate();
    }

    @JsonProperty("calculation")
    public CalculationRequest getCalculation() {
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
