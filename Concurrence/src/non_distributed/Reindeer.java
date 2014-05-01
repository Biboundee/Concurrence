package non_distributed;

public class Reindeer extends Thread {
	
	int holidays_time;
	int id;
	ReindeersVar reindeersvar;
	
	Reindeer(int id, ReindeersVar reindeersvar){
		holidays_time = (int) Math.round(5*Math.random()+5);
		this.id = id;
		this.reindeersvar = reindeersvar;
	}
	
	public void run(){
		try {
			Thread.sleep(holidays_time*1000);
			while(true){
				reindeersvar.reindeerIn(id);
				reindeersvar.reindeerOut(id);
				Thread.sleep(holidays_time*1000);
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
