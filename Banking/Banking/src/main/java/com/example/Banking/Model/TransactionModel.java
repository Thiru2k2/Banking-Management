 package com.example.Banking.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

 @Data
 @Entity
 @NoArgsConstructor
public class TransactionModel {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int tid;
    private int accno;
     private double amount;
     private String type;

     @Temporal(TemporalType.DATE)
     private Date TransactionTime;
     //@HH:mm:ss
     public int getTid() {
         return tid;
     }

     public void setTid(int tid) {
         this.tid = tid;
     }

     public int getAccno() {
         return accno;
     }

     public void setAccno(int accno) {
         this.accno = accno;
     }

     public double getAmount() {
         return amount;
     }

     public void setAmount(double amount) {
         this.amount = amount;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public Date getTransactionTime() {
         return TransactionTime;
     }

     public void setTransactionTime(Date transactionTime) {
         TransactionTime = transactionTime;
     }





}
