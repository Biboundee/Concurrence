package non_distributed;

public class Santa extends Thread {
	
	ElvesVar elvesvar;
	ReindeersVar reindeersvar;
	SantaVar santavar;
	
	Santa(ElvesVar elvesvar, ReindeersVar reindeersvar, SantaVar santavar){
		this.elvesvar = elvesvar;
		this.reindeersvar = reindeersvar;
		this.santavar = santavar;
	}
	
	public void run(){
		while(true){
			try{
				System.out.println("Santa va dormir");
				santavar.dormir();
				System.out.println("Santa est reveille.");
				if(reindeersvar.reindeersHereNumber() == 9){
					reindeersvar.noel_start();
				}
				else{
					elvesvar.helpElves();
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
