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
					System.out.println("Santa s'occupe des rennes.");
					reindeersvar.noel_start();
					Thread.sleep(1000);
				}
				if(elves>2){
					System.out.println("Santa s'occupe des elfes.");
					santavar.setFirstGroup();
					elvesvar.helpFirstGroup();
				}
				if(elves<3 && reindeers!=9){
					System.out.println("QUI OSE ME REVEILLER POUR RIEN ?!");
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
