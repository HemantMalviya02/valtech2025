package com.valtech.training.simple.interest;
import com.valtech.training.arithmetic.Operation;
public class simpleInterest {
	public int compute(int prin, int rate, int time) {
		 int product = Operation.MUL.perform(prin*rate,time);
		 return Operation.DIV.perform(product,100);
	}
}
