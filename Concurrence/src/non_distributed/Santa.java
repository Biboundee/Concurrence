package non_distributed;

public class Santa extends Thread {
	
	ReindeersVar reindeersvar;
	SantaVar santavar;
	
	Santa(ReindeersVar reindeersvar, SantaVar santavar){
		this.reindeersvar = reindeersvar;
		this.santavar = santavar;
	}
	
	public void run(){
		while(true){
			try{
				System.out.println("Santa va dormir.");
				santavar.dormir();
				System.out.println("Santa est reveille.");
				if(reindeersvar.reindeersHereNumber() == 9){
					reindeersvar.noel_start();
				}
				else if(santavar.elvesAskingNumber()>2){
					santavar.helpElves();
				}
				else{
					System.out.println("QUI OSE ME REVEILLER POUR RIEN ?!");
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
