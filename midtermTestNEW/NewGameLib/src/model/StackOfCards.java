package model;

import java.util.Arrays;
import java.util.Random;

public class StackOfCards {
    Card[] cards; // масив от всички карти в тестето от карти
    Card[] pack1; // масив на първото тесте след деленето на картите
    Card[] pack2; // масив на второто тесте след деленето на картите
    Card[] hand; // текущо изтеглена ръка от най- много 12 карти
    int trump; // индекс на цвят в Cards.suits, Коз на играта
    Random random; // генератор на случайни числа
    int currentCard; // брой карти изтеглени текущо от cards
    int currentPack1; // брой карти изтеглени текущо от pack2
    int currentPack2; // брой карти изтеглени текущо от pack1

    public StackOfCards() {
        cards = new Card[64];
        this.random = new Random();
        trump = random.nextInt(4);
        int current = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                cards[current++] = new Card(i, j);
            }
        }

        hand = new Card[12];
        Arrays.fill(hand, null);
    }

    public int getTrump() {
        return this.trump;
    }

    public void shuffleCards() {
        this.random = new Random();
        this.currentCard = 0;

        for (int i = 0; i < 64; i++) {
            int shuffleIndex = random.nextInt(64);

            Card tempCard = new Card(cards[i].getFace(), cards[i].getSuit());
            cards[i] = new Card(cards[shuffleIndex].getFace(), cards[shuffleIndex].getSuit());
            cards[shuffleIndex] = new Card(tempCard.getFace(), tempCard.getSuit());
        }
    }

    public String printCards() {
        StringBuilder toPrint = new StringBuilder();

        for (int i = 0; i < hand.length && hand[i] != null; i++) {
            toPrint.append(hand[i].toString());
            toPrint.append(", ");
            if ((i + 1) % 4 == 0) {
                toPrint.append('\n');
            }
        }
        return toPrint.toString();
    }

    public void make2packs() {
        shuffleCards();

        int n = 16 + random.nextInt(33);

        this.pack1 = new Card[n];
        this.pack2 = new Card[64 - n];

        for (int i = 0; i < n; i++) {
            this.pack1[i] = new Card(cards[currentCard].getFace(), cards[currentCard].getSuit());
            currentCard++;
        }

        for (int i = 0; i < 64 - n; i++) {
            this.pack2[i] = new Card(cards[currentCard].getFace(), cards[currentCard].getSuit());
            currentCard++;
        }

        this.currentPack1 = 0;
        this.currentPack2 = 0;
    }

    public boolean dealHand() {
        for (int i = 0; i < 12 && this.hand[i] != null; i++) {
            if (i % 2 == 0) {
                if (currentPack1 < pack1.length - 1) {
                    this.hand[i] = new Card(pack1[currentPack1].getFace() - 1,
                            pack1[currentPack1].getSuit() - 1);
                    currentPack1++;
                } else if (currentPack2 < pack2.length - 1) {
                    this.hand[i] = new Card(pack2[currentPack2].getFace() - 1,
                            pack2[currentPack2].getSuit() - 1);
                    currentPack2++;
                }
            } else {
                if (currentPack2 < pack2.length - 1) {
                    this.hand[i] = new Card(pack2[currentPack2].getFace() - 1, pack2[currentPack2].getSuit() - 1);
                    currentPack2++;
                } else if (currentPack1 < pack1.length - 1) {
                    this.hand[i] = new Card(pack1[currentPack1].getFace() - 1, pack1[currentPack1].getSuit() - 1);
                    currentPack1++;
                }
            }
        }
        return this.hand[11] != null;
    }

    public boolean hasKQ(){
        boolean flagKQsameSuit = false;
        boolean hasK = false;
        boolean hasQ = false;
        int suitIndexK = 0;
        int suitIndexQ = 0;

        for(int i = 0; i < hand.length && this.hand[i] != null; i++){
            if(hand[i].getFace() - 1 == 6){
                hasK = true;
                suitIndexK = hand[i].getSuit();
            }
            if(hand[i].getFace() - 1 == 5){
                hasQ = true;
                suitIndexQ = hand[i].getSuit();
            }
        }

        if(hasK && hasQ && suitIndexK == suitIndexQ){
            flagKQsameSuit = true;
        }

        return flagKQsameSuit;
    }

    public boolean has4ACE(){
        int numberAce = 0;

        for(int i = 0; i < hand.length && this.hand[i] != null; i++) {
            if(hand[i].getFace() - 1 == 7){
                numberAce++;
            }
        }

        return numberAce == 4;
    }
}
