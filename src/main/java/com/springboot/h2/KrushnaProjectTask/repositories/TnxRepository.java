package com.springboot.h2.KrushnaProjectTask.repositories;

import com.springboot.h2.KrushnaProjectTask.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TnxRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAmountBetween(double initialRange, double finalRange);

    List<Transaction> findAllByOrderByAmountAsc();
}
