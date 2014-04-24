package non_distributed;

public class Elf extends Thread {
	
	int working_time;
	int id;
	ElvesVar elvesvar;

	Elf(int id, ElvesVar elvesvar){
		working_time = (int) Math.round(10*Math.random());
		this.id = id;
		this.elvesvar = elvesvar;
	}
	
	public void run(){
		while(true){
			try{
				elvesvar.elfIn(id);
				elvesvar.elfOut(id);
				Thread.sleep(working_time);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
