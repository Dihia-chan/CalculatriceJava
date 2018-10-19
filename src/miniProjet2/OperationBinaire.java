package miniProjet2;

public class OperationBinaire  {
	protected double val1 ;
	protected double val2 ;
	
	public OperationBinaire() {
		this.val1 = 0;
		this.val2 = 0;
	}
	public OperationBinaire(double val1, double val2) {
		this.val1 = val1;
		this.val2 = val2;
	}
	public double getVal1() {
		return val1;
	}
	public void setVal1(double val1) {
		this.val1 = val1;
	}
	public double getVal2() {
		return val2;
	}
	public void setVal2(double val2) {
		this.val2 = val2;
	}
	
	

}
