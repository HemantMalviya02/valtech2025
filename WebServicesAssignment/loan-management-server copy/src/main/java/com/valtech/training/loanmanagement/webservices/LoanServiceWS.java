package com.valtech.training.loanmanagement.webservices;

import javax.jws.WebService;

import com.valtech.training.loanmanagement.vos.LoanVO;

@WebService
public interface LoanServiceWS {

	void applyLoan(LoanVO lvo);

}