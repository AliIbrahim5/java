package com.example.demo.controllers;


import com.example.demo.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AccountController {


    ArrayList <Account> accountsList=new ArrayList<>();

    @GetMapping("account")
    public ArrayList<Account> getAccounts(){
        return accountsList;
    }


    @PostMapping("account")
    public ResponseEntity addAccount(@RequestBody Account account){
        if (account.getName() == null || account.getId() == null || account.getBalance() == null){
            return ResponseEntity.status(400).body("create name is  null");
        }
        accountsList.add(account);
        return ResponseEntity.status(201).body("create Account");
    }


    @PutMapping("account/{id}")
    public ResponseEntity updateAccount(@PathVariable String id,@RequestBody Account account){
        if (account.getName() == null || account.getId() == null || account.getBalance() == null){
            return ResponseEntity.status(400).body("create  is  null");
        }
        for (int i = 0; i < accountsList.size(); i++) {
            if(accountsList.get(i).getId().equals(id)){
                accountsList.set(i,account);
                break;
            }
        }
        return ResponseEntity.status(200).body(" New update Account ");
    }


    @DeleteMapping("account/{id}")
    public ArrayList<Account> deleteAccount(@PathVariable String id){
        for (int i = 0; i < accountsList.size(); i++) {
            if(accountsList.get(i).getId().equals(id)){
                accountsList.remove(i);
                break;
            }
        }
        return accountsList;
    }

    @PostMapping("account/deposit/{id}")
    public ArrayList<Account> deposit(@PathVariable String id,@RequestBody Double amount){

        for (int i = 0; i < accountsList.size(); i++) {
            if(accountsList.get(i).getId().equals(id)){
                Double oldBalance=accountsList.get(i).getBalance();
                accountsList.get(i).setBalance(oldBalance+amount);
                break;
            }
        }
        return accountsList;
    }

    @PostMapping("account/withdraw/{id}")
    public ArrayList<Account> withdraw(@PathVariable String id,@RequestBody Double amount){
        for (int i = 0; i < accountsList.size(); i++) {
            if(accountsList.get(i).getId().equals(id)){
                Double oldBalance=accountsList.get(i).getBalance();
                accountsList.get(i).setBalance(oldBalance-amount);
                break;
            }
        }
        return accountsList;
    }


}
