package non_distributed;

import java.util.Vector;

public class ElvesVar {

	public boolean [] elves_asking;
	SantaVar santavar;
	static int ticketNumber = 0;
	Elf [] elves;
	
	ElvesVar(int nb_elves, SantaVar santavar){
		elves_asking = new boolean [nb_elves];
		this.santavar = santavar;
	}
	
	public void setElves(Elf [] elves){
		this.elves = elves;
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
	
	Elf elfMin(Vector<Elf> elves){
		Elf elfmin = elves.get(0);
		for(Elf e : elves){
			if(e.ticketNumber < elfmin.ticketNumber){
				elfmin = e;
			}
		}
		return elfmin;
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
	
	public synchronized void elfIn(Elf elf){
		try{
			elf.ticketNumber = ElvesVar.ticketNumber++;
			while(!elf.isCalled){
				if(elvesAskingNumber()<3){
					System.out.println("Elfe "+elf.id+" attend qu'on s'occupe de lui.");
					this.elves_asking[elf.id] = true;
					this.wait();
				}
				else{
					System.out.println("Elfe "+elf.id+" reveille le pere noel.");
					this.elves_asking[elf.id] = true;
					santavar.reveiller();
					this.wait();
				}
			}
			elf.isCalled = false;
			elf.ticketNumber = -1;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized void elfOut(int id){
		System.out.println("Elfe "+id+" repart travailler.");
		this.elves_asking[id] = false;
	}
	
	public synchronized void helpElves(){
		for(Elf e : getFirstGroup()){
			e.isCalled = true;
		}
		this.notifyAll();
	}
	
}
