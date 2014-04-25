package non_distributed;

public class Elf extends Thread {
	
	int working_time;
	int id;
	ElvesVar elvesvar;
	int ticketNumber;
	boolean isCalled;

	Elf(int id, ElvesVar elvesvar){
		working_time = (int) Math.round(3*Math.random()+3);
		this.id = id;
		this.elvesvar = elvesvar;
	}
	
	public void run(){
		while(true){
			try{
				elvesvar.elfIn(this);
				elvesvar.elfOut(id);
				Thread.sleep(working_time);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
