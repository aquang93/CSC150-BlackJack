/**
 * @author amartinez
 *User.java
 * Feb 27, 2013
 */
public class User extends Player
{	
	private int  handTotal = 0,numOfCards = 0;
	private double wallet = 100; //shadow variable
	private String[] hand;
	private final int MAX_HAND = 12;

	//constructor
	public User()
	{
		hand = new String[12];
	}

	//overloaded constructor
	public User(String name)
	{
		this.name = name;
		hand = new String[MAX_HAND];
	}

	//finds the values of the cards
	private int findCardValue(String card)
	{
		String value = card.substring(0,2);

		if(value.startsWith("10") || value.startsWith("J") || value.startsWith("Q") || value.startsWith("K"))
			return 10;
		if(value.startsWith("A"))
			return 11;
		else
		{
			value = value.substring(0, 1);
			int cardValue = Integer.parseInt(value);
			return cardValue;
		}
	}

	//gets the hands total
	@Override
	public int getHandTotal(String[] hand) 
	{
		handTotal = 0;

		for(int i = 0; i < hand.length; i++)
		{
			if(hand[i] == null)
				break;
			else
				handTotal += findCardValue(hand[i]);
		}
		
		softBust();

		return handTotal;
	}

	//setter for the hand
	public void setHand(String card)
	{
		if(numOfCards != hand.length)
		{
			hand[numOfCards] = card;
			numOfCards++;
		}
	}

	//gets the hand at a certain index
	public String getHand(int i) 
	{
		return hand[i];
	}
	
	//resets the hand to an empty array
	public void resetHand()
	{
		hand = new String[12];
		numOfCards = 0;
	}

	//gets the players wallet
	public double getWallet() 
	{
		return wallet;
	}

	//sets the players wallet
	public void setWallet(double wallet) 
	{
		this.wallet = wallet;
	}
	
	//adds to the players wallet
	public void addWallet(double w)
	{
		this.wallet += w;
	}
	
	//accounts for a soft bust(going over 21 but having an ace)
	private void softBust()
	{
		if(handTotal > 21)
		{
			for(int i = 0; i < hand.length; i++)
			{
				if(hand[i] == null)
					break;
				if(hand[i].startsWith("Ace"))
					handTotal -= 10;
			}
		}
	}
	
	//gets the players hand
	public String[] getHand() 
	{
		// TODO Auto-generated method stub
		return hand;
	}
}
