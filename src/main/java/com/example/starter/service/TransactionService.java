package com.example.starter.service;

import java.util.List;

import com.example.starter.model.Transaction;

public interface TransactionService {
	
	List<Transaction> getList(Transaction trx, int startFrom, int pageSize);
	
	int getTotal(Transaction trx);

	public int batchInsert(List<Transaction> trxList);
}
