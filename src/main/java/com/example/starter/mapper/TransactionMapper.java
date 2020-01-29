package com.example.starter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.starter.model.Transaction;

@Mapper
public interface TransactionMapper {
	@Select("SELECT * FROM T_TRANSACTION WHERE 1=1 <if test=\"acctNum != null\"> AND ACCT_NUM = #{acctNum}</if> LIMIT startFrom pageSize")
	List<Transaction> getList(@Param("trx") Transaction trx, @Param("startFrom") int startFrom, @Param("pageSize") int pageSize);
	
	
	@Select("SELECT COUNT(*) FROM T_TRANSACTION WHERE 1=1 <if test=\"acctNum != null\"> AND ACCT_NUM = #{acctNum}</if>")
	int getTotal(@Param("trx") Transaction trx);
	
	@Insert({"<script>", "INSERT INTO T_TRANSACTION (ACCT_NUM, TRX_AMT, TRX_TYPE_ID, TRX_DATE, TRX_TIME, CUST_ID) VALUES ",
    "<foreach collection='trxList' item='trx' separator=','> (#{trx.acctNum}, #{trx.trxAmt}, #{trx.trxTypeId}, #{trx.trxDate}, #{trx.trxTime}, #{trx.custId}) </foreach>",
    "</script>"})
	int batchInsert(@Param("trxList") List<Transaction> trxList);
}