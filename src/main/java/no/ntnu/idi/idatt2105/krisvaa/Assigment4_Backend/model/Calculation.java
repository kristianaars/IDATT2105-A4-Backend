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
    private double firstNumber;
    private char operator;

    @Column(name = "SECONDNUMBER")
    private double secondNumber;
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

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public double getAnswer() {
        return answer;
    }
}

