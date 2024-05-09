package myPackage;

public class Division implements Operation {
  public double calculate(double n1,double n2) {
	  if(n2==0) {
		  throw new IllegalArgumentException("Division by zero is not allowed");
	  }
	  return n1/n2;
  }
}