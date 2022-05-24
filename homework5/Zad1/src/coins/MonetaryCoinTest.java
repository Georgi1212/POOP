package coins;

public class MonetaryCoinTest {
    public static void main(String[] args) {
        MonetaryCoin monetaryCoin1 = new MonetaryCoin(Face.HEAD, 5);
        System.out.println("MonetaryCoin1: " + monetaryCoin1.toSting());
        monetaryCoin1.flip();
        System.out.println("MonetaryCoin1 after flipping: " + monetaryCoin1.getFace());

        MonetaryCoin monetaryCoin2 = new MonetaryCoin(Face.HEAD, 50);
        System.out.println("MonetaryCoin2: " + monetaryCoin2.toSting());
        monetaryCoin2.flip();
        System.out.println("MonetaryCoin2 after flipping: " + monetaryCoin2.getFace());

        MonetaryCoin monetaryCoin3 = new MonetaryCoin(Face.TAIL, 20);
        System.out.println("MonetaryCoin3: " + monetaryCoin3.toSting());
        monetaryCoin3.flip();
        System.out.printf("MonetaryCoin3 after flipping: %s\n",monetaryCoin3.getFace());

        System.out.println("After flipping monetaryCoin3 5 times: ");
        for(int i = 1; i <= 5; i++){
            monetaryCoin3.flip();
            System.out.printf("Flip %d: %s\n", i, monetaryCoin3.getFace());
        }

        System.out.println("The sum of these 3 coins: " + (monetaryCoin1.getValue() + monetaryCoin2.getValue() +
                                                            monetaryCoin3.getValue()));

    }
}
