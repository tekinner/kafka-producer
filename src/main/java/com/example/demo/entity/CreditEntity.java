package com.example.demo.entity;

import com.example.demo.model.CreditModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "producer", schema="rewards")
public class CreditEntity implements Serializable {

    @Id
    @Column(name = "MEMBERID")
    private int memberId;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "TRANSACTIONTYPE")
    private String transactionType;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "TOPIC")
    private String topic;

    public CreditEntity() {
    }

    public CreditEntity(Integer memberId, String message, String transactionType, Double amount, String topic) {
        this.memberId = memberId;
        this.message = message;
        this.transactionType = transactionType;
        this.amount = amount;
        this.topic=topic;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionType() {    return transactionType; }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
