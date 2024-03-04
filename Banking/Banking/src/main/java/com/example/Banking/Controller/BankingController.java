package com.example.Banking.Controller;

import com.example.Banking.Model.BankingModel;
import com.example.Banking.Service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Banking")
public class BankingController {
    @Autowired
    BankingService bankservice;

    //Create new USERS
   @PostMapping("/createuser")
    public BankingModel adduser(@RequestBody BankingModel bankmodel){
    return bankservice.create(bankmodel);
    }

    //Delete the user
    @PostMapping("/delete/{accno}")
    public String deleteUser(@PathVariable int accno){
       return bankservice.deleteTheuser(accno);
    }

    //Create Multiple user
    @PostMapping("/createalluser")
    public List<BankingModel> addAll(@RequestBody List<BankingModel> bankmodel){
       return bankservice.addingAll(bankmodel);
    }
    //Get the account details bt giving ACCOUNT NUMBER
    @GetMapping("/getaccount/{accno}")
    public BankingModel getAccountDeatils(@PathVariable int accno){
       return bankservice.getaccount(accno);
    }

    //Get all account details
    @GetMapping("/getallaccount")
    public List<BankingModel> getAllAccount(){
        return bankservice.getallaccount();
    }

    //DEPOSIT amount by giving the accno
   @PostMapping("/deposit/{accno}/{amount}")
    public ResponseEntity<?> depositAmount(@PathVariable int accno, @PathVariable double amount){
       return bankservice.deposit(accno,amount);
   }

   ///WITHDRAW amount by giving the accno
    @PostMapping("/withdraw/{accno}/{amount}")
    public ResponseEntity<?> withdrawAmount(@PathVariable int accno, @PathVariable double amount){
        return bankservice.withdraw(accno,amount);
    }



}
