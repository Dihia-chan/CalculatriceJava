package miniProjet2;

import java.util.Scanner;

public class OperationUnaire {
	protected double val ;
	protected Scanner sc = new Scanner(System.in) ;
	
	public OperationUnaire() {
		this.val = 0;
	}
	public OperationUnaire(double val) {
		this.val = val;
	}
	public double getVal() {
		return val;
	}
	public void setVal(double val) {
		this.val = val;
	}
	
	

}
