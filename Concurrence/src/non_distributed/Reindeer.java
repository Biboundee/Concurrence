package non_distributed;

public class Reindeer extends Thread {
	
	int holidays_time;
	int id;
	ReindeersVar reindeersvar;
	
	Reindeer(int id, ReindeersVar reindeersvar){
		holidays_time = (int) Math.round(10*Math.random()+1);
		this.id = id;
		this.reindeersvar = reindeersvar;
	}
	
	public void run(){
		while(true){
			try {
				reindeersvar.reindeerIn(id);
				reindeersvar.prepareForChristmas(id);
				// noel dure 3s
				Thread.sleep(3000);
				reindeersvar.reindeerOut(id);
				Thread.sleep(holidays_time*1000);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
