package non_distributed;

public class SharedVariables {
	
	public boolean [] elves_asking;
	public boolean [] reindeers_here;
	
	SharedVariables(int elves, int reindeers){
		elves_asking = new boolean [elves];
		reindeers_here = new boolean [reindeers];
	}
	
	public int elvesAskingNumber(){
		int n = 0;
		for(boolean b : elves_asking){
			n = b ? n++ : n;
		}
		return n;
	}
	
	public int reindeersHereNumber(){
		int n = 0;
		for(boolean b : reindeers_here){
			n = b ? n++ : n;
		}
		return n;
	}
	
	public synchronized void elfIn(int id){
		System.out.println("Elfe "+id+" attend qu'on s'occupe de lui.");
		this.elves_asking[id] = true;
		//TODO : si elfesAskingNumber > 2 alors reveiller pere noel sinon wait
	}
	
	public synchronized void elfOut(int id){
		System.out.println("Elfe "+id+" repart travailler.");
		this.elves_asking[id] = false;
		//TODO : ?
	}
	
	public synchronized void reindeerIn(int id){
		System.out.println("Renne "+id+" attends que le pere noel se reveille.");
		this.reindeers_here[id] = true;
		//TODO : si reindeersHereNumber == 9 alors reveiller pere noel sinon wait
	}
	
	public synchronized void reindeerOut(int id){
		System.out.println("Renne "+id+" repart en vacances.");
		this.reindeers_here[id] = false;
		//TODO : ?
	}
	
	public synchronized void dormir(){
		//TODO : juste wait ?
	}
	
	public synchronized void noel(){
		System.out.println("C'est noel !");
		//TODO : relacher tous les rennes.
	}
	
	public synchronized void helpElves(){
		System.out.println("Le pere noel aide un groupe d'elfes.");
		//TODO : relacher les elfes du groupe.
	}
	
}
