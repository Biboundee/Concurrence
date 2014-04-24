package non_distributed;

public class Reindeer extends Thread {
	
	int holidays_time;
	int id;
	ReindeersVar reindeersvar;
	
	Reindeer(int id, ReindeersVar reindeersvar){
		holidays_time = (int) Math.round(20*Math.random());
		this.id = id;
		this.reindeersvar = reindeersvar;
	}
	
	public void run(){
		while(true){
			try {
				reindeersvar.reindeerIn(id);
				reindeersvar.reindeerOut(id);
				Thread.sleep(holidays_time);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
