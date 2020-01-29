package com.example.starter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.starter.mapper.TransactionMapper;
import com.example.starter.model.Transaction;
import com.example.starter.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionMapper transactionMapper;
	
	@Override
	public int batchInsert(List<Transaction> trxList) {
		return transactionMapper.batchInsert(trxList);
	}

	@Override
	public List<Transaction> getList(Transaction trx, int startFrom, int pageSize) {
		return transactionMapper.getList(trx, startFrom, pageSize);
	}

	@Override
	public int getTotal(Transaction trx) {
		return transactionMapper.getTotal(trx);
	}

}
