package com.valtech.training.loanmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Loan {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "loan_seq")
	@SequenceGenerator(name = "loan_seq",sequenceName = "loan_seq",allocationSize = 1,initialValue = 1)
	private int id;
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String cusName;
	private int amount;
	private String asset;
	private int assetValue;
	private int value;
	
	public enum LoanType {
		HOME,CAR,EDUCATION;
	}
	
	public enum Status {
		APPLY,IN_PROCESS,APPROVED,REJECTED;
	}

	public Loan() {}

	public Loan(LoanType loanType,String cusName, Status status, int amount, String asset, int assetValue) {
		this.loanType = loanType;
		this.cusName = cusName;
		this.status = status;
		this.amount = amount;
		this.asset = asset;
		this.assetValue = assetValue;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public int getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(int assetValue) {
		this.assetValue = assetValue;
	}	

}
