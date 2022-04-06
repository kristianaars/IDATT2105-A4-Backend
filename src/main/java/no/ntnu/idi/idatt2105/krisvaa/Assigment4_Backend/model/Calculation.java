package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(insertable = false)
    private long calculation_id;

    private long user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private UserAccount acc;

    @Column(name = "FIRSTNUMBER")
    private double first_number;
    private char operator;

    @Column(name = "SECONDNUMBER")
    private double second_number;
    private double answer;

    public Calculation() {
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public long getCalculation_id() {
        return calculation_id;
    }

    public void setCalculation_id(long calculation_id) {
        this.calculation_id = calculation_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public UserAccount getAcc() {
        return acc;
    }

    public void setAcc(UserAccount acc) {
        this.acc = acc;
    }

    public double getFirst_number() {
        return first_number;
    }

    public void setFirst_number(double first_number) {
        this.first_number = first_number;
    }

    public double getSecond_number() {
        return second_number;
    }

    public void setSecond_number(double second_number) {
        this.second_number = second_number;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public double getAnswer() {
        return answer;
    }
}

