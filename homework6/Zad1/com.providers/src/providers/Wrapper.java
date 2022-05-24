package providers;

import services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    private class FixedRandom implements Cipherable{
        @Override
        public char[] getSecretChars(int seed){
            Random generator = new Random(seed);
            char[] result = new char[size];

            for (int i = 0; i < result.length; i++) {
                result[i] = (char)(generator.nextInt(26) + 'A');
            }
            return result;
        }
    }

    private class FixedSelection implements Cipherable{
        @Override
        public char[] getSecretChars(int seed){
            Random generator = new Random();
            char[] randomGeneratedSymbols = new char[seed];
            char[] randomSymbolsResult = new char[size];

            for (int i = 0; i < randomGeneratedSymbols.length; i++){
                randomGeneratedSymbols[i] = (char)(generator.nextInt(26) + 'A');
            }

            int index;
            for(int i = 0; i < randomSymbolsResult.length; i++){
                index = generator.nextInt(seed);
                randomSymbolsResult[i] = randomGeneratedSymbols[index];
            }

            return randomSymbolsResult;
        }
    }

    public Wrapper(int size){
        setSize(size);
    }

    public void setSize(int size){
        if(size < 0){
            this.size = 0;
        }
        else {
            this.size = size;
        }
    }

    public int getSize(){
        return size;
    }

    public Cipherable makeFixedSelection(){
        return new FixedRandom();
    }

    public Cipherable makeFixedRandom(){
        return new FixedSelection();
    }
}
