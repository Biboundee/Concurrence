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
			santavar.dormir();
		}
	}
	
}
