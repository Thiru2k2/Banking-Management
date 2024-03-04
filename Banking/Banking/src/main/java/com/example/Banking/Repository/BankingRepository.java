package com.example.Banking.Repository;

import com.example.Banking.Model.BankingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepository extends JpaRepository<BankingModel,Integer> {

}
