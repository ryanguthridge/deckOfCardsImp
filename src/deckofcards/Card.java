package deckofcards;

public class Card {
	
	//Sets the suit of the card
	private String cardSuit;	
	//Sets the rank of the card
	private int cardRank;
	//Sets if it is a face card or not
	private String cardFace;
		//Set if the card has been dealt or not
	private boolean dealt = false;
	
	public Card(String suit, int rank) {
		// TODO Auto-generated constructor stub
		cardSuit = suit;
		cardRank = rank;
		
		//If the value is over 10 it is a face card
		if(cardRank > 10){
			if(cardRank == 11){
				cardFace = "Jack";
			}else if(cardRank == 12){
				cardFace = "Queen";
			}else if(cardRank == 13){
				cardFace = "King";
			}
		}else if(cardRank == 1){
			cardFace = "Ace";
		}else{
			cardFace = null;
		}
	}
	
	/**
	 * @return the card suit
	 */
	public String getCardSuit() {
		return cardSuit;
	}

	/**
	 * @param card suit the card suit to set
	 */
	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	/**
	 * @return the card rank
	 */
	public int getCardRank() {
		return cardRank;
	}

	/**
	 * @param card rank the card rank to set
	 */
	public void setCardRank(int cardRank) {
		this.cardRank = cardRank;
	}
	
	/**
	 * @return the card face
	 */
	public String getCardFace() {
		return cardFace;
	}

	/**
	 * @param card face the card face to set
	 */
	public void setCardFace(String cardFace) {
		this.cardFace = cardFace;
	}

	/**
	 * @return the dealt
	 */
	public Boolean getDealt() {
		return dealt;
	}

	/**
	 * @param dealt the dealt to set
	 */
	public void setDealt(Boolean dealt) {
		this.dealt = dealt;
	}
	
}
