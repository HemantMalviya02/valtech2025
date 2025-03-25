package com.valtech.training.loanmanagement.webservices;

import javax.jws.WebService;

import com.valtech.training.loanmanagement.services.LoanService;
import com.valtech.training.loanmanagement.vos.LoanVO;

@WebService(endpointInterface = "com.valtech.training.loanmanagement.webservices.LoanServiceWS"
,name="LoanService",portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS {
	private LoanService loanService;

	public LoanServiceWSImpl(LoanService loanService) {
		this.loanService = loanService;
	}
	
	@Override
	public void applyLoan(LoanVO lvo) {
		 loanService.applyLoan(lvo);
	}

}
