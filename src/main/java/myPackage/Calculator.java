package myPackage;

public class Calculator{
	public double performOperation(double n1,double n2, String operationType) {
		Operation operation;
		System.out.println("reached here");
		switch(operationType.toUpperCase()) {
		
		case "ADD":
			operation = new Addition();
			break; 
		
		case "SUBTRACT":
			operation = new Subtraction();
			break;
			
		case "MULTIPLY":
			operation = new Multiplication();
			break;
			
		case "DIVIDE":
			operation = new Division();
			break;
			
		default :
			throw new IllegalArgumentException("Invalid operation type");
		}
		
		return operation.calculate(n1,n2);
	}
}
