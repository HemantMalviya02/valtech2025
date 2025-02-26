package spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogReturnAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object retValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(method.getName()+"Returned "+retValue);
	}

}
