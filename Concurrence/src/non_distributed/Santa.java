package non_distributed;

public class Santa extends Thread {
	
	SharedVariables var;
	
	Santa(SharedVariables var){
		this.var = var;
	}
	
	public void run(){
		while(true){
			var.dormir();
			if(var.reindeersHereNumber()==9){
				var.noel();
			}
			else{
				var.helpElves();
			}
		}
	}
	
}
