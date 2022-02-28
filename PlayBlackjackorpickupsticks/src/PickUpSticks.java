import java.util.Scanner;

public class PickUpSticks {
	
	/* Alannah Cullinane Cooney
	 * algorithm
	 * 
	 */

	public static void startGame() {
		
		// TODO Auto-generated method stub
		int numberOfSticks=21;
		System.out.println("Would you like to start? Y/N");
		Scanner input = new Scanner(System.in);
		String first = input.nextLine();
		int sticksTaken = 0;
		
		//Code runs until numberOfSticks variable = 0
		while (numberOfSticks > 0) {
			
			//If user says yes
			if(first.equalsIgnoreCase("Y"))
			{
				//get user input for the first turn
				System.out.println("There are "+numberOfSticks+" Sticks.");
				System.out.println("How many Sticks do you want to take, 1 or 2?");
				sticksTaken = input.nextInt();
				
				//declares number of sticks taken by player
				if(sticksTaken > 2)
				{
					sticksTaken = 2;
				}
				else if(sticksTaken < 1) 
				{
					sticksTaken = 1;
				}
				
				numberOfSticks -= sticksTaken;
				
				//Computer takes sticks 
				if(numberOfSticks <= 0)
				{
					System.out.println("GAME \nOVER!");
				}
				else 
				{
					if((numberOfSticks - 2)% 3 == 0 || numberOfSticks -2 == 0) {
						sticksTaken = 1;
					}
					else {
						sticksTaken = 2;
					}
				}
				System.out.println("Computer has taken "+sticksTaken+" Sticks.");
				numberOfSticks -= sticksTaken;
				
				if(numberOfSticks <= 0)
				{
					System.out.println("You win");
				}
			}
			//If user says no
			else 
			{
				if((numberOfSticks - 2)% 3 == 0 || numberOfSticks -2 == 0) {
					sticksTaken = 1;
				}
				else {
					sticksTaken = 2;
				}
				
				System.out.println("Computer has taken "+sticksTaken+" Sticks.");
				numberOfSticks -= sticksTaken;
				
				if(numberOfSticks <=0)
				{
					System.out.println("You win");
				}
				else
				{
					System.out.println("There are "+numberOfSticks+" Sticks.");
					System.out.println("How many Sticks do you want to take, 1 or 2?");
					sticksTaken = Integer.parseInt(input.nextLine());
					
					if(sticksTaken > 2)
					{
						sticksTaken= 2;
					}
					else if(sticksTaken < 1) 
					{
						sticksTaken = 1;
					}
					
					numberOfSticks -= sticksTaken;
					
					if(numberOfSticks <= 0)
					{
						System.out.println("GAME \nOVER!");
					}
				}
				
			}
		}

	}

}


