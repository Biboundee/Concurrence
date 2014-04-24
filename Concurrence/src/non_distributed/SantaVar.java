package non_distributed;

public class SantaVar {

	SantaVar(){
	}
	
	public synchronized void reveiller(){
		this.notifyAll();
	}
	
	public synchronized void dormir(){
		try {
			this.wait();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
