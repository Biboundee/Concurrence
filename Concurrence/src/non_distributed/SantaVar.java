package non_distributed;

import java.util.Vector;

public class SantaVar {

	static int ticketNumber;
	boolean santabusy;
	boolean noel;
	public boolean [] elves_asking;
	Elf [] elves;
	
	SantaVar(int nb_elves){
		elves_asking = new boolean [nb_elves];
		ticketNumber = 0;
		santabusy = false;
		noel = false;
	}
	
	public void setElves(Elf [] elves){
		this.elves = elves;
	}
	
	public synchronized int elvesAskingNumber(){
		int n = 0;
		for(int i=0;i<elves_asking.length;i++){
			if(elves_asking[i]){
				n++;
			}
		}
		return n;
	}
	
	Elf elfMin(Vector<Elf> elves){
		Elf elfmin = elves.get(0);
		for(Elf e : elves){
			if(e.ticketNumber < elfmin.ticketNumber){
				elfmin = e;
			}
		}
		return elfmin;
	}
	
	Elf [] getFirstGroup(){
		Elf [] firstgroup = new Elf[3];
		Vector<Elf> tmp = new Vector<Elf>();
		for(Elf e : elves){
			tmp.add(e);
		}
		for(int i=0;i<3;i++){
			firstgroup[i] = elfMin(tmp);
			tmp.remove(elfMin(tmp));
		}
		return firstgroup;
	}
	
	public synchronized void setFirstGroup(){
		Elf [] firstGroup = getFirstGroup();
		for(int i=0;i<firstGroup.length;i++){
			firstGroup[i].isCalled = true;
		}
	}
	
	public synchronized void reveiller(){
		this.notifyAll();
	}
	
	public synchronized void dormir(){
		try {
			this.wait();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
