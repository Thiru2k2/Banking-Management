package com.example.Banking.Service;

import com.example.Banking.Model.BankingModel;
import com.example.Banking.Model.TransactionModel;
import com.example.Banking.Repository.BankingRepository;
import com.example.Banking.Repository.TransactoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BankingService {
    @Autowired
    BankingRepository bankrepository;
    @Autowired
    TransactoinRepository transrepository;

    public BankingModel create(BankingModel bankmodel){
        return bankrepository.save(bankmodel);
    }

    public String deleteTheuser(int accno){
        bankrepository.deleteById(accno);
                return "Deleted";
    }

    public List<BankingModel> addingAll(List<BankingModel> bankmodel){
        return bankrepository.saveAll(bankmodel);
    }

    public BankingModel getaccount(int accno){
        return bankrepository.findById(accno).orElse(null);
    }

    public List<BankingModel> getallaccount(){
        return bankrepository.findAll();
    }

    public ResponseEntity<?> deposit(int accno,double amount){

        BankingModel bm = getaccount(accno);
        if(getaccount(accno)==null){
            return ResponseEntity.badRequest().body("Account is not available");
        }
        double dep=bm.getBalance()+amount;
        bm.setBalance(dep);
        bankrepository.save(bm);

        TransactionModel transmodel=new TransactionModel();
        transmodel.setAccno(accno);
        transmodel.setAmount(amount);
        transmodel.setType("Deposit");
        transmodel.setTransactionTime(new Date());
        transrepository.save(transmodel);

       return  ResponseEntity.ok("Amount Deposited : " +bm);
       // return ResponseEntity.ok("Amount Deposited..!");


    }
    public ResponseEntity<?> withdraw(int accno,double amount) {

        BankingModel bm = getaccount(accno);
        if (bm == null) {
            return ResponseEntity.badRequest().body("Account is not available");
        }
        if(bm.getBalance()<amount){
           return ResponseEntity.badRequest().body("Insufficiant Balance");
        }
        bm.setBalance(bm.getBalance()-amount);
        bankrepository.save(bm);

        TransactionModel transmodel=new TransactionModel();
        transmodel.setAccno(accno);
        transmodel.setAmount(amount);
        transmodel.setType("Withdraw");
        transmodel.setTransactionTime(new Date());
        transrepository.save(transmodel);

        return ResponseEntity.ok("Amount Debited : " +bm);
       // return ResponseEntity.ok("Amount Withdraw..!");
    }
}

