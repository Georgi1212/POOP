package game;

import java.util.Locale;

public class Card {
    private String face;
    private String suit;

    public Card(String face, String suit) {
        setFace(face);
        setSuit(suit);
    }

    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    public void setFace(String face) {
        if(!isInFace(face.toUpperCase())){
            throw new RuntimeException("Invalid card face");
        }
        this.face = new String(face);
    }

    public void setSuit(String suit) {
        if(!isInSuit(suit.toUpperCase())){
            throw new RuntimeException("Invalid card suit");
        }
        this.suit = new String(suit);
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.face, this.suit);
    }

    public static boolean isInSuit(String value) {
        for (Suit s : Suit.values()) {
            if(s.name().equals(value)) { return true; }
        }
        return false;
    }

    public static boolean isInFace(String value) {
        for (Face f : Face.values()) {
            if(f.name().equals(value)) { return true; }
        }
        return false;
    }
}
