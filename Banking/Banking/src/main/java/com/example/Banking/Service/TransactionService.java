package com.example.Banking.Service;

import com.example.Banking.Model.TransactionModel;
import com.example.Banking.Repository.TransactoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactoinRepository transrepository;

   public List<TransactionModel> getAllDetails(){
       return transrepository.findAll();
   }

   public List<TransactionModel> getaccountdetails(int accno){
       return transrepository.getDetailsById(accno) ;
   }

   public List<TransactionModel> getPassBook(int accno,Date from, Date to){
       return transrepository.getAllPassBook(accno,from,to);
   }
}

