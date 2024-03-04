package com.example.Banking.Controller;
import com.example.Banking.Model.TransactionModel;
import com.example.Banking.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    TransactionService transservice;

    //Get the details of all TRANSACTIONS
    @GetMapping("/getalltrans")
    public List<TransactionModel> getAll(){
        return transservice.getAllDetails();
    }

    //Get the details of given Account number Transactions
    @GetMapping("/getaccounttrans/{accno}")
    public List<TransactionModel> getAccountDetails(@PathVariable int accno){
        return transservice.getaccountdetails(accno);
    }


    @GetMapping("/passbook/{accno}/{from}/{to}")
    public List<TransactionModel> passBook(@PathVariable int accno, @PathVariable Date from,@PathVariable Date to){
        return transservice.getPassBook(accno,from,to);
    }

    }

