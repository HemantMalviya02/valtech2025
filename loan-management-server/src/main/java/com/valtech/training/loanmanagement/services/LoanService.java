package com.valtech.training.loanmanagement.services;

import com.valtech.training.loanmanagement.entities.Loan;
import com.valtech.training.loanmanagement.vos.LoanVO;

public interface LoanService {

	void applyLoan(LoanVO lvo);

	void processLoan(LoanVO lvo,Loan loan);

}