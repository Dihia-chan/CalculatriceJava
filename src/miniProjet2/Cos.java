package miniProjet2;

public class Cos extends OperationUnaire{
	private double cos ;
	 public Cos(double chiffre) {
		 super(chiffre) ;
	}
	public double calcul(){
		if( super.getVal() != 90  && super.getVal() !=  270){
		cos = Math.toRadians(super.getVal());
		cos = Math.cos (cos) ;
		}
		else {
			cos = 0 ;
		}
		    return (cos);
	     }

}
