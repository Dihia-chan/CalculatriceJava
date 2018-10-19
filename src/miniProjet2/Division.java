package miniProjet2;

public class Division extends OperationBinaire implements CalculMath{
	
	public Division(double x1 , double x2){
		super(x1 , x2);
	}
	public double calcul() throws ArithmeticException{
		return (super.getVal1()/super.getVal2()) ;
	}

}
