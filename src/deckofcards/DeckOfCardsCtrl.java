package deckofcards;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCardsCtrl {
	
	//Max cards
	public static final int maxCards = 52;
	public static final int maxCardsPerSuit = 13;
	
	//Set the suits
	private String[] cardSuits = {"Diamonds","Spades","Hearts","Clubs"};
	
	//Allow interaction
	Scanner reader = new Scanner(System.in);  // Reading from System.in
	
	//Deck constructor
	public Card[] buildDeck(){
		
		Card[] deckOfCards;
		
		//init the array
		deckOfCards = new Card[maxCards];
		
		int cardN = 0;
		
		for(int i = 0; i < cardSuits.length; i++){
			for(int j = 0; j < maxCardsPerSuit; j++){
				//Get the true rank of the card
				int cardRank = j + 1;
				deckOfCards[cardN++] = new Card(cardSuits[i], cardRank);
			}
		};
		
		return deckOfCards;
	}
	
	//Leveraging the Durstenfeld algorithm, appears to be more performant than the Fisher Yates
	public Card[] shuffleDeck(Card[] deckOfCards){
		
		Card[] shuffledDeckOfCards = null;
		
		for(int i = 0; i < maxCards; i++){
			int  j = ThreadLocalRandom.current().nextInt(i, maxCards);
			shuffledDeckOfCards = swapCards(deckOfCards, j, i);
		}

		deckOfCards = shuffledDeckOfCards;
		
		return deckOfCards;
	}
	
	//Worker method for the shuffling of the cards
	public Card[] swapCards(Card[] deckOfCards, int position1, int position2){
		
		Card[] tempCardArray = deckOfCards;
		
		Card tempCard = tempCardArray[position1];
		
		//Set the card to undealt, since we're shuffling
		tempCard.setDealt(false);
		
		tempCardArray[position1] = tempCardArray[position2];
		tempCardArray[position2] = tempCard;
		
		return tempCardArray;
	}
		
	public String dealCardsAndShowThem(Card[] deckOfCards){
		
		//Pre-emptively getting ready to run out of cards
		String dealtCardsString = "Nothing. We ran out of cards.";
		
		int numberToDeal = 1;
		
		Card[] tempCardArray = new Card[numberToDeal];
		tempCardArray = dealCards(deckOfCards, numberToDeal);
		
		StringBuffer stringBufferForCardOutput = new StringBuffer();
		
		for(int i = 0; i < numberToDeal; i++){
			
			Card tempCard = tempCardArray[i];
			
			if(tempCard == null){
				return dealtCardsString;
			}
			
			//Building out the string to tell you what card you were dealt
			stringBufferForCardOutput.append("The ");
			
			String cardFace = tempCard.getCardFace();					
			if(cardFace != null){
				stringBufferForCardOutput.append(cardFace);
			}else{
				int cardRank = tempCard.getCardRank();
				stringBufferForCardOutput.append(cardRank);
			}
			
			stringBufferForCardOutput.append(" of ");
			
			String cardSuit = tempCard.getCardSuit();
			stringBufferForCardOutput.append(cardSuit);

		}

		dealtCardsString = stringBufferForCardOutput.toString();
		
		return dealtCardsString;
		
	}
	
	//Deals the number of cards requested
	public Card[] dealCards(Card[] deckOfCards, int numberToDeal){
		
		Card[] currentHandBeingDealt = new Card[numberToDeal];
		
		for(int i = 0; i < numberToDeal; i++){
			Card tempCard = dealSingleCard(deckOfCards);
			currentHandBeingDealt[i] = tempCard;
		}
		
		Card[] dealtCards = currentHandBeingDealt;
		
		return dealtCards;
	}
	
	//Dealer pulls a single card at a time
	public Card dealSingleCard(Card[] deckOfCards){
		
		Card dealtCard = null;
		
		//Here we are going to only deal the non-dealt cards
		for(int i = 0; i < maxCards; i++){
			Card tempCard = deckOfCards[i];
			boolean isDealt = tempCard.getDealt();
			if(!isDealt){
				dealtCard = tempCard;
				tempCard.setDealt(true);
				return dealtCard;
			}
		}
		return null;
	}
}
