package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Operator {
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
