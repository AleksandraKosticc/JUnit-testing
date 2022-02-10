package kalkulator;

import kalkulator.exception.NotSupportedOperationException;
import kalkulator.exception.NumberNotInAreaException;

/**
 * <h1> Advanced form calculator</h1>
 *
 * @author Aleksandra
 * @version 1.0 
 *
 */
public class CalculatorAdvanced extends Calculator {

	public CalculatorAdvanced() { 
		super(); 
	}
	
	/**
	 * This method uses a one char and calculates the degree of a number and the factorial of a number
	 * 
	 * @param action Allowed values integer data in the range from 0 to 9 and character !
	 * @throws NotSupportedOperationException If the value of the action parameter is not supported
	 * @throws NumberNotInAreaException If the currentValue value is not in the range when calculating the number factor [0, 10]
	 */
	public void calculateAdvanced(char action) throws NotSupportedOperationException, NumberNotInAreaException{
		if(action >='0' && action <='9') {
			  int a = Character.getNumericValue(action); 
			  
			  int num = getCurrentValue().intValue();
			  int degree=1;
			  	
			  if(a == 0) {
				  degree = 1;
			  }else {
				  while(a > 0){    
					  degree*=num; 
					  a--;
				  }
			  }
			  setCurrentValue(Double.valueOf(degree));
			  
		}else if (action == '!') {
			int num = getCurrentValue().intValue(); 
			 
			if(num >= 0 && num <=10) {
				int i,fact=1;
				for(i=1; i<=num; i++) {
					fact=fact*i;//calculate the factorial using for loop
				}
				setCurrentValue(Double.valueOf(fact));
		    }else {
		    	throw new NumberNotInAreaException("Van zadatkog opsega.");
		    }			
		}else {
			throw new NotSupportedOperationException("greska");
			}			
	}
	
	/**
	 * This method uses a one char, and calculates an Armstrong number and a perfect number.
	 * 
	 * Armstrong numbers represent all n-digit natural numbers that are equal to the sum of the n-ths
     * degree digits of that number. Examples are: 153 = 13 + 53 + 33 = 1 + 125 + 27 = 153 i
     * 1634 = 14 + 64 + 34 + 44 = 1 + 1296 + 81 + 256 = 1634
     * A perfect number is a natural number that is equal to the sum of its positive divisors, including the number 1, but
     * not counting that number alone. Examples are: 6 = 1 + 2 + 3 and 28 = 1 + 2 + 4 + 7 + 14
	 * 
	 * @param value Values of characters A and P 
	 * @return A method based on the value parameter, whose allowed values are the characters A and P, returns true if the integer part of the currentValue value is an Armstrong number (if the value is A), or perfect (if the value is P).
	 * @throws NumberNotInAreaException If the value of the value parameter is not supported
	 * @throws NotSupportedOperationException In case the integer part of the currentValue value is less than 1 create an exception
	 */
	public Boolean hasCharacteristic(char value) throws NumberNotInAreaException, NotSupportedOperationException{
		
		int num = getCurrentValue().intValue();
		
		if(num <= 0) {
			throw new NumberNotInAreaException("Cjelobrojni dio vrijednosti manji od 1");
		}else {			
			if(value == 'A') {
				
					int c, temp, k=0, sum=0, i;				
					temp = num;
					
					while(temp > 0) { k++; temp/=10; }
					temp = num;
					while (temp > 0){ 
			        c = temp % 10;
			        temp /= 10;
			        i=k;
			        int degree=1;
			        	while(i>0) {
			        		degree *= c;
			        		i--;
			        	}		        	
			        sum += degree;
			        }
					 
					if(sum == num)		        
						return true;
					else
						return false;
				
			}else if(value == 'P') {
				 
					int temp; 			 
				    temp = num;
					int sum = 0;
						for(int i=1; i<temp; i++)
							if(temp%i == 0)
								sum+=i;
					
				    if (sum == temp)
				    	return true;
				    else 
				    	return false;
			}else {
				throw new NotSupportedOperationException("Vrijednost parametra value nije podržana");
			}
		}
	}	
}