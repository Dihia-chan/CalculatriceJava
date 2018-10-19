package miniProjet2;

public class Log extends OperationUnaire {
	
	public Log(double x){
		 super(x);
	 }
	 public double calcul(){
		    return (Math.log (super.getVal()));
	     }

}
