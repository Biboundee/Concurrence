package non_distributed;

public class Elf extends Thread {
	
	int working_time;
	int id;
	ElfVar elfvar;
	int ticketNumber = 999;

	Elf(int id, ElfVar elfvar){
		working_time = (int) Math.round(3*Math.random()+3);
		this.id = id;
		this.elfvar = elfvar;
	}
	
	public void run(){
		try{
			Thread.sleep(working_time*1000);
			while(true){
				elfvar.elfIn(this);
				elfvar.elfOut(id);
				Thread.sleep(working_time*1000);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
