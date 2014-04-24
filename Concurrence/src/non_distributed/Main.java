package non_distributed;

public class Main {
	public static void main(String [] args){
		
		// variables 
		int nb_elves = 7;
		int nb_reindeers = 9;
		
		// Initialisation
		SharedVariables var = new SharedVariables(nb_elves, nb_reindeers);
		Santa santa = new Santa(var);
		Elf [] elves = new Elf [nb_elves];
		for(int i=0;i<nb_elves;i++){
			elves[i] = new Elf(i, var);
		}
		Reindeer [] reindeers = new Reindeer [nb_reindeers];
		for(int i=0;i<nb_reindeers;i++){
			reindeers[i] = new Reindeer(i, var);
		}
		// Start()
		santa.start();
		for(Elf e : elves){
			e.start();
		}
		for(Reindeer r : reindeers){
			r.start();
		}
	}
}
