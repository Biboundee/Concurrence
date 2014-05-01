package non_distributed;

public class Elf extends Thread {
	
	int working_time;
	int ticketNumber;
	boolean isCalled;
	boolean isLastElf;
	int id;
	ElvesVar elvesvar;

	Elf(int id,ElvesVar elvesvar){
		working_time = (int) Math.round(3*Math.random()+3);
		ticketNumber = 999;
		isCalled = false;
		isLastElf = false;
		this.id = id;
		this.elvesvar = elvesvar;
	}
	
	public void run(){
		try{
			Thread.sleep(working_time*1000);
			while(true){
				elvesvar.elfIn(this);
				elvesvar.elfOut(this);
				Thread.sleep(working_time*1000);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
