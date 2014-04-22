
public class Main {
	public static void main(String [] args){
		// Initialisation
		Reindeer [] reindeers = new Reindeer [9];
		for(int i=0;i<9;i++){
			reindeers[i] = new Reindeer(i);
		}
		Elf [] elves = new Elf [7];
		for(int i=0;i<7;i++){
			elves[i] = new Elf(i);
		}
		Santa santa = new Santa();
		// Start()
		for(Reindeer r : reindeers){
			r.start();
		}
		for(Elf e : elves){
			e.start();
		}
		santa.start();
	}
}
