package non_distributed;

public class ReindeersVar {

	public boolean [] reindeers_here;
	SantaVar santavar;
	
	public ReindeersVar(int reindeers, SantaVar santavar) {
		reindeers_here = new boolean [reindeers];
		this.santavar = santavar;
	}
	
	public int reindeersHereNumber(){
		int n = 0;
		for(boolean b : reindeers_here){
			n = b ? n++ : n;
		}
		return n;
	}
	
	public synchronized void reindeerIn(int id){
		System.out.println("Renne "+id+" attends que le pere noel se reveille.");
		this.reindeers_here[id] = true;
		boolean continuer = true;
		//TODO : si reindeersHereNumber == 9 alors reveiller pere noel sinon wait
		while(continuer){
			if(reindeersHereNumber() == 9){
				// reveiller pere noel
			}
		}
	}
	
	public synchronized void reindeerOut(int id){
		System.out.println("Renne "+id+" repart en vacances.");
		this.reindeers_here[id] = false;
	}
	
}