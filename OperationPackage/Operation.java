package OperationPackage;

import java.io.Serializable;

public class Operation implements Serializable {
	private int op1,op2,resultat;
	private char operation;//+ - / *
	public Operation(int op1,int op2, char operation) 
	{
		this.op1=op1;
		this.op2=op2;
		this.operation=operation;
	}
	public int getOp1() {
		return op1;
	}
	public void setOp1(int op1) {
		this.op1 = op1;
	}
	public int getOp2() {
		return op2;
	}
	public void setOp2(int op2) {
		this.op2 = op2;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	public int getRes() {return resultat;}
	 public void setRes(int res){
	        this.resultat = res;
	    }
	
	

}
