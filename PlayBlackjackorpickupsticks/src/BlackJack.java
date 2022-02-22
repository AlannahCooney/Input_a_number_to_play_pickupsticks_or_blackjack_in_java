import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BlackJack {

		//Use Random class to generate a random choice
		private Random random = new Random();
		
		//Declare variables 
		private boolean gameActive, playerMove = true;
		private int playerTotal;
		private int dealerTotal;
		private int dealerCard1, dealerCard2, dealerNextCard, playerCard1, playerCard2, playerNextCard;
		
    	private int bScore = 0;

		public BlackJack()
    	{
    		
    	
    	}
    	
    	public void startGame() throws IOException{
    		
		gameActive = true;
		playerMove = true;
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		//dealers first two random cards and card total
		dealerCard1 = random.nextInt(10) + 1;
		dealerCard2 = random.nextInt(11) + 1;
		dealerTotal = dealerCard1 + dealerCard2;
          
		//players first two random cards and card total
		playerCard1 = random.nextInt(10) + 1;
		playerCard2 = random.nextInt(11) + 1;
		playerTotal = playerCard1 + playerCard2;
          
		//display dealers card total
		System.out.println("Dealer cards: " + dealerCard1 + ", " + dealerCard2);
		System.out.println("Dealer total: "+ dealerTotal);
		          
		//display players first two cards & card total
		System.out.println("Your cards: " + playerCard1 + ", " + playerCard2);
		System.out.println("Your total: "+ playerTotal);
         
		while(gameActive)
		{	 
			dealDealer();
 			
        	System.out.println("Dealers card total: " + dealerTotal);
        	 
        	playerMove = true;
        	 
        while(playerMove)
        {     
        	System.out.println("Would you like another Card (y/n)?: \n");
			String choice = br.readLine();
				 
		if(choice.toLowerCase().equals("y"))
		{			 
			givePlayerAnotherCard();
					 
			System.out.println("Your new total: "+ playerTotal);
					 
			playerMove = false;			 
		}
		
		else if(choice.equals("n"))
		{		 			 	 
			playerMove = false;
					 
		}
		
		else
		{			 
			System.out.println("Please choose y or n");
		}
        }	 
			
			checkPossibleWin();
			
    	}	
         
			playAgain();
    }


    	//getting a random card
    	public int getCard()
    	{
		return random.nextInt(10) + 1;
    	}
    	
    	public void dealDealer(){
		
    	//the dealer will keep taking another card until they reach 17	
		if(dealerTotal < 17)
		{	
			dealerNextCard = random.nextInt(11) + 1;
        	dealerTotal += dealerNextCard;
        	System.out.println("Dealers new card: " + dealerNextCard);
		}
		
    }
	
    	public void givePlayerAnotherCard(){
		
		if(playerTotal >= 21)
		{	
			System.out.println("Can't get another card");
		}
		
		else
		{
			playerNextCard = random.nextInt(11) + 1;
		 	playerTotal += playerNextCard;
		 	System.out.println("Your new card: " + playerNextCard);
		}	
    }
	
	public void checkPossibleWin(){
		//compare player cards to the dealers cards and display a winner
		if (playerTotal == 21)
        {
			System.out.println("You Win \nYour Total: " + playerTotal + "\nDealer Total " + dealerTotal);
			gameActive = false;
			bScore++;
        }
		
		else if (dealerTotal == 21)
        {
			System.out.println("You Lose \nYour Total: " + playerTotal + "\nDealer Total " + dealerTotal);
			gameActive = false;
			bScore++;
        }
		
		else if(dealerTotal >= 17 && playerTotal > 17 && playerTotal <= 21 && playerTotal > dealerTotal)
		{
			System.out.println("You Win \nYour Total: " + playerTotal + "\nDealer Total " + dealerTotal);
			gameActive = false;
			bScore++;	
		}
		
		else if(dealerTotal > 21 && playerTotal < 21)
		{
			System.out.println("You Win \nYour Total: " + playerTotal + "\nDealer Total " + dealerTotal);
			gameActive = false;
			bScore++;	
		}
		
		else if(playerTotal > 21 && dealerTotal < 21)
		{
			System.out.println("Dealer Wins \nDealer Total: " + dealerTotal + "\nYour Total " + playerTotal);
			gameActive = false;
		}
		
		else if((dealerTotal >= 21 && playerTotal >= 21))
		{
			System.out.println("Draw \nDealer Total: " + dealerTotal + "\nYour Total " + playerTotal);
			gameActive = false;
		}
	}
	
	public void playAgain() throws IOException{
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.println("Would you like to play again?");
		String choice = br.readLine();
		
		//if player chooses to play again restart the game
		if(choice.toLowerCase().equals("y"))
		{	
			this.startGame();	
		}
		
		else
		{
			System.out.println("Thanks for playing");
		}
	}

	public int getbScore() {
		// TODO Auto-generated method stub
		return bScore;
	}
	public void setbScore(int bScore) {
		this.bScore = bScore;
	}

}

	
	


	

	
		
	
	


