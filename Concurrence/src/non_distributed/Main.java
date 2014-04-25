package non_distributed;

public class Main {
	public static void main(String [] args){
		
		// variables 
		int nb_elves = 7;
		int nb_reindeers = 9;
		
		// Initialisation
		SantaVar santavar = new SantaVar();
		ElvesVar elvesvar = new ElvesVar(nb_elves,santavar);
		ReindeersVar reindeersvar = new ReindeersVar(nb_reindeers,santavar);
		Santa santa = new Santa(elvesvar,reindeersvar,santavar);
		Elf [] elves = new Elf [nb_elves];
		for(int i=0;i<nb_elves;i++){
			elves[i] = new Elf(i, elvesvar);
		}
		elvesvar.setElves(elves);
		Reindeer [] reindeers = new Reindeer [nb_reindeers];
		for(int i=0;i<nb_reindeers;i++){
			reindeers[i] = new Reindeer(i, reindeersvar);
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
