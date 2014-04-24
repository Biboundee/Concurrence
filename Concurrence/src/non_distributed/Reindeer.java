package non_distributed;

public class Reindeer extends Thread {
	
	int holidays_time;
	int id;
	SharedVariables var;
	
	Reindeer(int id, SharedVariables var){
		holidays_time = (int) Math.round(20*Math.random());
		this.id = id;
		this.var = var;
	}
	
	public void run(){
		while(true){
			try {
				var.reindeerIn(id);
				var.reindeerOut(id);
				Thread.sleep(holidays_time);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
