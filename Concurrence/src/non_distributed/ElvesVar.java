package non_distributed;

public class ElvesVar {

	public boolean [] elves_asking;
	SantaVar santavar;
	
	ElvesVar(int elves, SantaVar santavar){
		elves_asking = new boolean [elves];
		this.santavar = santavar;
	}
	
	public int elvesAskingNumber(){
		int n = 0;
		for(boolean b : elves_asking){
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
	
}
