package miniProjet2;

public class Sin extends OperationUnaire {
	private double sin ;
	public Sin(double x){
		 super(x);
	 }
	 public double calcul(){
		 if ( super.getVal() == 180 || super.getVal() == 360 ){
			 sin = 0 ;
		 }
		 else{
		 sin = Math.toRadians(super.getVal());
		 sin = Math.sin (sin);
		 }
		    return (sin );
	     }

}

