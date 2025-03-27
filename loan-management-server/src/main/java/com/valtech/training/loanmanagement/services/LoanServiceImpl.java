package com.valtech.training.loanmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.loanmanagement.entities.Loan;
import com.valtech.training.loanmanagement.entities.Loan.Status;
import com.valtech.training.loanmanagement.repos.LoanRepo;
import com.valtech.training.loanmanagement.vos.LoanVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepo loanRepo;
	
	@Override
	public void applyLoan(LoanVO vo) {
		Loan loan = vo.to();
		loan.setStatus(Status.IN_PROCESS);
		loanRepo.save(loan);
		processLoan(vo,loan);
	}
	@Override
	public void processLoan(LoanVO vo,Loan loan) {	
		int cs = vo.getCibilScore();
		int income = vo.getIncome();
		String asset = vo.getAsset();
		int assetValue = vo.getAssetValue();
		int amount = loan.getAmount();
		int value1 =0;
		int value2 = 0;
		
		loan = loanRepo.getReferenceById(loan.getId());
		if(cs <= 600) {
			loan.setStatus(Status.REJECTED);
			loanRepo.save(loan);
			return;
		}
		else if(cs > 600 && cs <= 700) {
			value1 = income*3;
			if("gold".equalsIgnoreCase(asset)) {
				value2 = (int) (assetValue*0.75);
			}else if("home".equalsIgnoreCase(asset)) {
				value2 = (int) (assetValue*0.85);
			}
			loan.setValue(amount > (value1 > value2 ? value2:value1) ? ((value1 > value2 ? value2:value1)):amount);
			loan.setStatus(Status.APPROVED);
			loanRepo.save(loan);
			return;
		}
		else if(cs > 700) {
			value1 = income*5;
			value1 = income*3;
			if("gold".equalsIgnoreCase(asset)) {
				value2 = (int) (assetValue * 0.75);
			}
			else if("home".equalsIgnoreCase(asset)) {
				value2 = (int) (assetValue * 0.85);
			}
			loan.setValue(amount>(value1 > value2 ? value1:value2) ? ((value1 > value2 ? value1:value2)):amount);
			loan.setStatus(Status.APPROVED);
			loanRepo.save(loan);
			return;
		}
		
	}
	
	
}
