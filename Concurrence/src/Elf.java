
public class Elf extends Thread {
	
	int working_time;
	int id;

	Elf(){
		working_time = (int) Math.round(10*Math.random());
	}
	
	Elf(int _id){
		this();
		this.id = _id;
	}
	
	public void run(){
		
	}
	
}
