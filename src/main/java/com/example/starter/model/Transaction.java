package com.example.starter.model;

import lombok.Data;

@Data
public class Transaction {

	private long acctNum;
	
	private double trxAmt;
	
	private byte trxTypeId;
	
	private int trxDate; //yyyyMMdd
	
	private int trxTime; //hhmmss
		
	private long custId;
}
