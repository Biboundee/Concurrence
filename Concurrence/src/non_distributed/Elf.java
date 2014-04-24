package non_distributed;

public class Elf extends Thread {
	
	int working_time;
	int id;
	SharedVariables var;

	Elf(int id, SharedVariables var){
		working_time = (int) Math.round(10*Math.random());
		this.id = id;
		this.var = var;
	}
	
	public void run(){
		while(true){
			try{
				var.elves_asking[id] = true;
				if(var.askingElvesNumber()>2){
					// reveiller le pere noel
				}
				else{
					// attendre qu'un groupe de 3 elfes se forme
				}
				Thread.sleep(working_time);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
