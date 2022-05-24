package providers;

import services.Cipherable;

public class CipherGenerator {
    public static Result countDistinct(Cipherable cipher, int seed){
        char[] resultArray = cipher.getSecretChars(seed);
        int data = 0;
        boolean unique;

        for(int i = 0; i < resultArray.length; i++){
            unique = true;
            for(int j = 0; j < resultArray.length; j++){
                if(resultArray[i] == resultArray[j] && i != j){
                    unique = false;
                    break;
                }
            }
            if(unique){
                data++;
            }
        }
        return new Result(resultArray, data);
    }
}
