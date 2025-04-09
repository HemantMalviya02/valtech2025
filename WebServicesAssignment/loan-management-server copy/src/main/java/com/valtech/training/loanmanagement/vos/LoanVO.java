package com.valtech.training.loanmanagement.vos;
import com.valtech.training.loanmanagement.entities.Loan;
import com.valtech.training.loanmanagement.entities.Loan.LoanType;
import com.valtech.training.loanmanagement.entities.Loan.Status;


public class LoanVO {

	private String loanType;
	private String status;
	private int amount;
	private String asset;
	private int assetValue;
	private String name;
	private int aadhar;
	private int cibilScore;
	private String panNum;
	private int income;
	
	
	public LoanVO() {}
	

	public LoanVO(String loanType, String status, int amount, String asset, int assetValue, String name, int aadhar,
		int cibilScore, String panNum, int income) {
	this.loanType = loanType;
	this.status = status;
	this.amount = amount;
	this.asset = asset;
	this.assetValue = assetValue;
	this.name = name;
	this.aadhar = aadhar;
	this.cibilScore = cibilScore;
	this.panNum = panNum;
	this.income = income;
}

	public Loan to() {
		LoanType ltype = LoanType.valueOf(loanType.toUpperCase());
		Status stat = Status.valueOf(status.toUpperCase());
		return new Loan(ltype, name,stat, amount, asset, assetValue);
	}

	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAadhar() {
		return aadhar;
	}
	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}
	public int getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "LoanVO [loanType=" + loanType + ", status=" + status + ", amount=" + amount + ", asset=" + asset
				+ ", assetValue=" + assetValue + ", name=" + name + ", aadhar=" + aadhar + ", cibilScore=" + cibilScore
				+ ", panNum=" + panNum + ", income=" + income + "]";
	}
	
}
