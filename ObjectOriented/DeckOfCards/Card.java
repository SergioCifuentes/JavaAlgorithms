package DeckOfCards;
public abstract class Card{
    private boolean available=true;
    protected int faceValue;
    private Suit suit;
    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }
    public abstract int value();
    public Suit suit(){return suit;}

    public boolean isAvailable(){return available;}
    public void markUnavailable(){available =false;}
    public void markAvailable(){available =true;}

    public int getValue() {
        return faceValue;
    }



    public Suit getSuit() {
        return suit;
    }



    public enum Suit{
        Club(0), Diamond(1), Heart(2), Spade(3);
        private int value;
        private Suit(int v){ value = v;}
        public int getValue(){ return value;}
        public static Suit getSuitFromValue(int value){
            
            switch (value) {
                case 0:
                    return Club;
                case 1:
                    return Diamond;
                case 2:
                    return Heart;
                case 3:
                    return Spade;
                default:
                    return null;
            }
        }
    }
}