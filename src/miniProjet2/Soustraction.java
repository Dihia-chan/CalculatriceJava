package miniProjet2;

public class Soustraction extends OperationBinaire implements CalculMath{
	
	public Soustraction(double x1 , double x2){
		super(x1,x2);
	}
	public double calcul(){
		return (super.getVal1()-super.getVal2()) ;
	} 

}
