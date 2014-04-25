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
			if(reindeersHereNumber() != 8){
				System.out.println("Renne "+id+" attends que le pere noel se reveille.");
				this.reindeers_here[id] = true;
				this.wait();
			}
			else{
				System.out.println("Renne "+id+" reveille le pere noel.");
				this.reindeers_here[id] = true;
				santavar.reveiller();
				this.notifyAll();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized void reindeerOut(int id){
		System.out.println("Renne "+id+" repart en vacances.");
		this.reindeers_here[id] = false;
	}
	
	public synchronized void prepareForChristmas(int id){
		try {
			System.out.println("Renne "+id+ " se prepare pour noel");
			this.wait();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void noel_start(){
		System.out.println("Santa donne le feu vert. C'est noel !");
		this.notifyAll();
	}
	
}