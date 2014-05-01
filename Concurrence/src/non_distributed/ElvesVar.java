package non_distributed;

public class ElvesVar {
	
	SantaVar santavar;
	
	ElvesVar(SantaVar santavar){
		this.santavar = santavar;
	}
	
	public synchronized void elfIn(Elf elf){
		try{
			santavar.elves_asking[elf.id] = true;
			elf.ticketNumber = SantaVar.ticketNumber++;
			boolean hasPrinted = false;
			while(!elf.isCalled){
				if(santavar.elvesAskingNumber() < 3 || santavar.santabusy){
					if(!hasPrinted){
						System.out.println("Elfe "+elf.id+" attend.");
						hasPrinted = true;
					}
					this.wait();
				}
				else{
					System.out.println("Elfe "+elf.id+" reveille Santa.");
					santavar.santabusy = true;
					santavar.reveiller();
					this.wait();
				}
			}
			elf.ticketNumber = 999;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public synchronized void elfOut(Elf e){
		System.out.println("Elfe "+e.id+" repart.");
		santavar.elves_asking[e.id] = false;
		santavar.santabusy = false;
		e.isCalled = false;
	}
	
	synchronized void helpFirstGroup(){
		this.notifyAll();
	}
	
}
