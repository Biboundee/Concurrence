package non_distributed;

import java.util.Vector;

public class ElfVar {

	SantaVar santavar;
	boolean isLastElf = false;
	
	ElfVar(SantaVar santavar){
		this.santavar = santavar;
	}

	public synchronized void elfIn(Elf elf){
		try{
			elf.ticketNumber = SantaVar.ticketNumber++;
			if(santavar.elvesAskingNumber()<2 || santavar.santabusy){
				santavar.elves_asking[elf.id] = true;
				System.out.println("Elfe "+elf.id+" attend qu'on s'occupe de lui.");
				this.wait();
			}
			else{
				System.out.println("Elfe "+elf.id+" reveille le pere noel.");
				santavar.elves_asking[elf.id] = true;
				santavar.santabusy = true;
				santavar.reveiller();
				this.wait();
			}
			System.out.println(elf.id+" est reveille par Santa.");
			elf.ticketNumber = 999;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public synchronized void elfOut(int id){
		System.out.println("Elfe "+id+" repart travailler.");
		santavar.elves_asking[id] = false;
		if(isLastElf){
			santavar.santabusy = false;
		}
		isLastElf = false;
	}
	
	public synchronized void santaHelp(){
		this.notify();
	}
	
}
