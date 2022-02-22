import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static boolean playingGames = true;
	static BlackJack b = new BlackJack();
	private static int total = 0;
	
	public static void main(String[] args) throws IOException 
	{ 
		
	    // Using string to implement the variables
		String greeting = " Welcome";
		User user1 = new User("Lucia", "Winner");
		User user2 = new User("Zaine", "Lucky");
		User user3 = new User("Brooke", "Record");
		
		System.out.println(greeting + "\n" + user1.getUsername() + "\n" + user2.getUsername() + "\n" + user3.getUsername());
			
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		
		while(playingGames) {
			
			//Choose between to play either Black Jack or PickUpSticks 
			System.out.println(" To Play Black Jack 1 is the number you must enter, if you want to play Pick Up Sticks then 2 is the number you must enter");
			try {
				// pick game 1 for blackjack 2 for 
				String choice = br.readLine();
			
				
				if(choice.equals("1")) {
				
					b.startGame();
					total += b.getbScore();
					
				}
				//call second game
				else if(choice.equals("2")) {
					
					//create object
					PickUpSticks.startGame();
					//start game
				}
				else {
					System.out.println("Please enter 1 or 2");
				}
				
				System.out.println("Want to continue playing? n for no and y for yes");
				
				choice = br.readLine();
				if(choice.toLowerCase().equals("n")) {
					System.out.println("Thanks for playing your score is: " + total);
					System.exit(0);
				}
	
			}
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
	}
	
	}
}
