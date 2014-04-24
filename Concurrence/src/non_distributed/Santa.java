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
	
	public void helpElves(){
		
	}
	
	public void run(){
		while(true){
			try{
			santavar.dormir();
				if(reindeersvar.reindeersHereNumber() == 9){
					reindeersvar.noel_start();
				}
				else{
					helpElves();
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
