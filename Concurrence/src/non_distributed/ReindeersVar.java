package non_distributed;

public class ReindeersVar {

	public boolean [] reindeers_here;
	SantaVar santavar;
	
	public ReindeersVar(int nb_reindeers, SantaVar santavar) {
		reindeers_here = new boolean [nb_reindeers];
		this.santavar = santavar;
	}
	
	public synchronized int reindeersHereNumber(){
		int n = 0;
		for(int i=0;i<reindeers_here.length;i++){
			if(reindeers_here[i]){
				n++;
			}
		}
		return n;
	}
	
	public synchronized void reindeerIn(int id){
		try{
			this.reindeers_here[id] = true;
			if(reindeersHereNumber() != 9){
				System.out.println("Renne "+id+" attend.");
				this.wait();
			}
			else{
				System.out.println("Renne "+id+" reveille Santa.");
				santavar.santabusy = true;
				santavar.reveiller();
				this.wait();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized void reindeerOut(int id){
		System.out.println("Renne "+id+" repart.");
		this.reindeers_here[id] = false;
		santavar.santabusy = false;
	}
	
	public synchronized void noel_start(){
		System.out.println("C'est noel !");
		this.notifyAll();
	}
	
}