package non_distributed;

public class SharedVariables {
	
	public boolean [] elves_asking;
	public boolean [] reindeers_here;
	
	SharedVariables(int elves, int reindeers){
		elves_asking = new boolean [elves];
		reindeers_here = new boolean [reindeers];
	}
	
	public int askingElvesNumber(){
		int n = 0;
		for(boolean b : elves_asking){
			n = b ? n++ : n;
		}
		return n;
	}
	
	public int reindeersHereNumber(){
		int n = 0;
		for(boolean b : reindeers_here){
			n = b ? n++ : n;
		}
		return n;
	}
	
	
	
}
