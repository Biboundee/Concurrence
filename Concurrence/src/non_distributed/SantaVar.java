package non_distributed;

import java.util.Vector;

public class SantaVar {

	static int ticketNumber = 0;
	public boolean [] elves_asking;
	Elf [] elves;
	boolean santabusy = false;
	
	SantaVar(int nb_elves){
		elves_asking = new boolean [nb_elves];
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
	
	void printTickets(){
		System.out.println();
		for(Elf e : elves){
			System.out.println("Elf "+e.id+" : "+e.ticketNumber+" ");
		}
		System.out.println();
	}
	
	public void setElves(Elf [] elves){
		this.elves = elves;
	}
	
	public synchronized void helpElves(){
		printFirstGroup(getFirstGroup());
		Elf [] firstGroup = getFirstGroup();
		for(int i=0;i<firstGroup.length;i++){
			firstGroup[i].elfvar.santaHelp();
			if(i==2){firstGroup[i].elfvar.isLastElf = true;}
		}
	}
	
	void printFirstGroup(Elf[] elves){
		for(int i=0;i<3;i++){
			System.out.print("#"+elves[i].id+" ticket = "+elves[i].ticketNumber+" ");
		}
		System.out.println();
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
