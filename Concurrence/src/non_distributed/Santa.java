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
				System.out.println("Santa dort.");
				santavar.dormir();
				int elves = santavar.elvesAskingNumber();
				int reindeers = reindeersvar.reindeersHereNumber();
				System.out.println("Santa est reveille ("+elves+" elfes,"+reindeers+" rennes"+").");
				if(reindeers == 9){
					reindeersvar.noel_start();
				}
				else if(elves>2){
					santavar.setFirstGroup();
					elvesvar.helpFirstGroup();
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
