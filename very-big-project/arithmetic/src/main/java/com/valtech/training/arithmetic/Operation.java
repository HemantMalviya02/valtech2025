package com.valtech.training.arithmetic;

public interface Operation {
	
	Operation ADD = (a,b) -> a+b;
	Operation SUB = (a,b) -> a-b;
	Operation MUL = (a,b) -> a*b;
	Operation DIV = (a,b) -> a/b;
	
	int perform(int a, int b);
}
