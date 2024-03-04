package com.example.Banking.Repository;

import com.example.Banking.Model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactoinRepository extends JpaRepository<TransactionModel,Integer> {

    @Query("select t from TransactionModel t where t.accno= :accno")
    List<TransactionModel> getDetailsById(int accno);

    @Query("select t from TransactionModel t where t.accno= :accno AND t.TransactionTime between :from and :to ")
    List<TransactionModel> getAllPassBook(int accno, Date from, Date to);
}
