package miniProjet2;

public class Exp extends OperationUnaire {
	
	 public Exp(double x){
		 super(x);
	 }
	 public double calcul(){
		    return (Math.exp (super.getVal()));
	     }

}