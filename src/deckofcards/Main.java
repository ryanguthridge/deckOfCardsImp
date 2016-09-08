package deckofcards;

import java.util.Scanner;

public class Main {
	
	static Scanner reader = new Scanner(System.in);
	private static Card[] deckOfCards;

	public static void main(String[] args) {
		
		DeckOfCardsCtrl deckOfCardsCtrl = new DeckOfCardsCtrl();
				
		//Lets build our deck of cards	
		System.out.println("Creating a new deck of cards.");
		deckOfCards = deckOfCardsCtrl.buildDeck();
		System.out.println("Created.\n");
		
		//Let's shuffle the cards now
		shuffleCards(deckOfCardsCtrl);
		
		//Fixing the Java bug that throws a weird error
		System.exit(0);
	}
	
	public static void dealCards(DeckOfCardsCtrl deckOfCardsCtrl){
		
		String thisCard = deckOfCardsCtrl.dealCardsAndShowThem(deckOfCards);
		
		if(thisCard == null){
			System.out.println("It looks like we ran out of cards, would you like me to re-shuffle them for you?");
			shuffleCardQuestion(deckOfCardsCtrl);
		}else{
			
			//Now Lets deal another one of those cards and show it
			System.out.println("Dealing out a card...");
			System.out.println("It looks like you got: " + thisCard);
			System.out.println("Cool.\n");
			
			System.out.println("Would you like to deal again? (yes or no)");
			String dealAgainAnswer = reader.next();
			if(dealAgainAnswer.equalsIgnoreCase("yes")){
				dealCards(deckOfCardsCtrl);
			}else{
				shuffleCardQuestion(deckOfCardsCtrl);
			}
		}
	};
	
	public static void shuffleCardQuestion(DeckOfCardsCtrl deckOfCardsCtrl){
		System.out.println("Would you like to reshuffle the deck?");
		String shuffleAgainAnswer = reader.next();
		if(shuffleAgainAnswer.equalsIgnoreCase("yes")){
			shuffleCards(deckOfCardsCtrl);
		}else{
			System.out.println("See ya later");
		}
	}
	
	public static void shuffleCards(DeckOfCardsCtrl deckOfCardsCtrl){		
		
		//Now lets shuffle the cards
		System.out.println("Shuffling our new deck of cards.");
		deckOfCards = deckOfCardsCtrl.shuffleDeck(deckOfCards);
		System.out.println("Shuffled.\n");
		
		//Let's deal out a card
		dealCards(deckOfCardsCtrl);
	};

}
