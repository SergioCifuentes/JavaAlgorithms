package DeckOfCards;

public class BlackJackCard extends Card {

    public BlackJackCard(int faceValue, Suit suit) {
        super(faceValue, suit);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int value() {
        if(isAce()) return 11;
        else if (isFaceCard()) return 10;
        else return faceValue;       
    }
    public int minValue(){
        if(isAce()) return 1;
        else return value();
    }
    public int maxValue(){
        if(isAce()) return 11;
        else return value();
    }

    public boolean isAce(){
        return this.faceValue==1;
    }
    public boolean isFaceCard(){
        return faceValue >= 11 && faceValue <= 13;
    }
    
}
