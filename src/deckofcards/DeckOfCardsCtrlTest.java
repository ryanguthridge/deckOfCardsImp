package deckofcards;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckOfCardsCtrlTest {

	@Test
	public void testBuildDeck() {
		
		DeckOfCardsCtrl deckOfCardsCtrlTest = new DeckOfCardsCtrl();
		
		Card[] initialDeck = new Card[53];
		initialDeck = deckOfCardsCtrlTest.buildDeck();
		
		//Make sure it isn't null
		assertNotNull(initialDeck);
		
		//Make sure the deck is the correct number of cards
		if(initialDeck.length == 52){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
	
	@Test
	public void buildAndShuffleDeck(){
		
		
		DeckOfCardsCtrl deckOfCardsCtrlTest = new DeckOfCardsCtrl();
		
		Card[] initialDeck = new Card[53];
		initialDeck = deckOfCardsCtrlTest.buildDeck();
				
		Card[] shuffledDeck = new Card[53];
		shuffledDeck = deckOfCardsCtrlTest.shuffleDeck(initialDeck.clone());
		
		//Make sure the deck isn't the same after shuffling
		assertNotSame(initialDeck, shuffledDeck);
		
	}
	
	@Test
	public void dealCardsAndShowThem(){
		
		DeckOfCardsCtrl deckOfCardsCtrlTest = new DeckOfCardsCtrl();
		
		Card[] initialDeck = new Card[53];
		initialDeck = deckOfCardsCtrlTest.buildDeck();
		
		System.out.println("Brand new deck:");
		deckSizeRunner(initialDeck);
		
		
		System.out.println("\nShuffled deck:");
		Card[] shuffledDeck = new Card[53];
		shuffledDeck = deckOfCardsCtrlTest.shuffleDeck(initialDeck.clone());
		
		deckSizeRunner(shuffledDeck);
		
	}
	
	public void deckSizeRunner(Card[] cardDeck){
		
		DeckOfCardsCtrl deckOfCardsCtrlTest = new DeckOfCardsCtrl();
		
		//Let's deal all of the cards in the deck
		for(int i = 0; i < 53; i++){
			String dealtHand = deckOfCardsCtrlTest.dealCardsAndShowThem(cardDeck);
			
			//Making sure that when we are dealt a hand, there's something there
			assertNotNull(dealtHand);
			
			//Lets see it
			System.out.println(dealtHand);
			
			//Cheesy error message
			String errorMsg = "Nothing. We ran out of cards.";
			
			//We should be out of cards, let's make sure
			if(i == 52){
				assertSame(dealtHand, errorMsg);
			}
		}
	}
	
}
