package miniProjet2;

public class Addition extends OperationBinaire implements CalculMath{
	
	public Addition (double x1 , double x2) {
		super( x1 ,  x2);
	}
	public double calcul(){
		return (super.getVal1()+super.getVal2()) ;
	}
	

}
