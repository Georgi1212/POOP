import java.text.NumberFormat;
import java.util.Random;

public class RandomNumber {

    public static int drawRandomNumber()
    {
        Random random = new Random();
        int number;
        number = random.nextInt(100);

        if(number <= 20) { return 1; }
        else if(number <= 30) { return 2; }
        else return 3;
    }

    public static void calculateResult(int allPossible)
    {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for(int i = 0; i < allPossible; i++)
        {
            int randomNumber = drawRandomNumber();

            switch(randomNumber)
            {
                case 1: count1++; break;
                case 2: count2++; break;
                case 3: count3++; break;
            }
        }

        calculatePossibilities(allPossible, count1, count2, count3);
    }

    public static void calculatePossibilities(int _allPossible, int _count1, int _count2, int _count3)
    {
        //format probabilities as percentages
        NumberFormat numberFormat = NumberFormat.getPercentInstance();

        System.out.println("P(1) for allPossible: " + numberFormat.format(_count1/(double)_allPossible));
        System.out.println("P(2) for allPossible: " + numberFormat.format(_count2/(double)_allPossible));
        System.out.println("P(3) for allPossible: " + numberFormat.format(_count3/(double)_allPossible));
    }

    public static void main(String[] args) {

        System.out.println("Calculate result for 10 000");
        calculateResult(10_000);

        System.out.println("Calculate result for 60 000");
        calculateResult(60_000);

    }
}
