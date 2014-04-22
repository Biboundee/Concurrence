
public class Reindeer extends Thread {
	
	int holidays_time;
	int id;
	
	Reindeer(){
		holidays_time = (int) Math.round(20*Math.random());
	}
	
	Reindeer(int _id){
		this();
		this.id = _id;
	}
	
	public void run(){

	}
	
}
