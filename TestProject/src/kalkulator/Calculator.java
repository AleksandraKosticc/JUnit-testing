package kalkulator;

import kalkulator.exception.DivisionByZeroException;
import kalkulator.exception.NotSupportedOperationException;

/**
 * <h1>Basic operations calculator</h1>
 * @author Aleksandra
 * @version 1.0 
 * 
 */
public class Calculator {
	private Double currentValue;

	/**
	 * The Constructor that set the currentValue attribute to 0.0.
	 */
	public Calculator() {
		currentValue=0.0; 
	}
	
	/**
	 * @return value of currentValue
	 */
	public Double getCurrentValue() {
		return currentValue;
	}

	/**
	 * @param currentValue new value of currentValue
	 */
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}

	/**
	 * Represents a calculator with basic operations with +, -, * and /
	 * 
	 * This method calculate 
	 * @param value This is the first parameter to calculate methode, second operand currentValue
	 * @param operator This is the second parameter to calculate methode, operator allowed values +, -, * and /
	 * @throws NotSupportedOperationException If the value of the parameter operator is not one of the allowed values +, -, * and /
	 * @throws DivisionByZeroException In case of division with zero
	 */
	public void calculate(Double value, char operator) throws NotSupportedOperationException, DivisionByZeroException{
		double result = 0.0;
		
		switch(operator)
		{ 
			case '+':
				result = currentValue + value;
				currentValue = result;
				break; 
			case '-':
				result = currentValue - value;
				currentValue = result;
				break;
			case '*':   
				result = currentValue * value;
				currentValue = result; 
				break;  
			case '/':  
				if(value == 0.0) throw new DivisionByZeroException("Ne moze se dijeliti nulom");
				result = currentValue / value;
				currentValue = result;
				break;
			default:
				throw new NotSupportedOperationException("greska");  
		}
	}
}