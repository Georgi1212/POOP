package zad1;

import java.util.ArrayList;
import java.util.Random;

public class KidsEgg {
    private static ArrayList<Integer> hero = new ArrayList<>();

    public static void generateAnimalHero()
    {
        for (int i = 0; i < 10; ++i)
        {
            hero.add(i, i + 1);
        }
    }

    public static int getEgg()
    {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    public static boolean findInList(int egg)
    {
        for(int i = 0; i < hero.size(); ++i)
        {
            if(hero.contains(egg))
            {
                if(hero.remove((Object) egg))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        double sum = 0;
        int countAnimalHero = 0;
        int countEggs = 0;
        generateAnimalHero();
        int egg;
        while(sum < 7 && hero.size() > 0)
        {
            egg = getEgg();
            if(findInList(egg))
            {
                ++countAnimalHero;
            }
            ++countEggs;
            sum += 0.5;
        }

        System.out.printf("You have %d different heroes and average sum is: %f", countAnimalHero, sum/countEggs);

        hero.clear();
    }
}
