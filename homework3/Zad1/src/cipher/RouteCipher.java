package cipher;

import java.util.Arrays;

public class RouteCipher {
    private int key;


    public RouteCipher(int key) {
        setKey(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if (key != 0) {
            this.key = key;
        }
        else{
            this.key = 1;
        }
    }

    //method that encrypts a plain text
    public String encrypt(String plainText){
        char[] plainTextArray = changeArray(plainText.toCharArray()); // plain text (String) -> char[] without spaces, comma/s and other symbols that are other than a letter

        int col = (int)Math.abs(key);
        int row = (int)Math.ceil((double)(plainTextArray.length) / col);

        char[][] matrix = makeMatrixForEncryption(plainTextArray, row, col);

        int cipherLength = row * col;
        char[] cipherText = new char[cipherLength];
        int cipherTextIndex = 0;

        //depending on the key, we determine from where we start to traverse the matrix
        if(key > 0){ //here is the case in which key is > 0; and in this case we start to traverse the matrix from top left
            int maxRow = row - 1;
            int maxCol = col - 1;
            int minRow = 0;
            int minCol = 0;

            while(cipherTextIndex < cipherLength) {

                for(int i = minRow; i <= maxRow; i++)
                {
                    cipherText[cipherTextIndex++] = matrix[i][minCol];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(int i = minCol + 1; i <= maxCol; i++)
                {
                    cipherText[cipherTextIndex++] = matrix[maxRow][i];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(int i = maxRow - 1; i >= minRow; i--)
                {
                    cipherText[cipherTextIndex++] = matrix[i][maxCol];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(int i = maxCol- 1; i >= minCol + 1; i--)
                {
                    cipherText[cipherTextIndex++] = matrix[minRow][i];
                }
                minRow++;
                minCol++;
                maxRow--;
                maxCol--;
            }

        }
        else{  //here is the case in which key is < 0; and in this case we start to traverse the matrix from bottom right
            int maxRow = row - 1;
            int maxCol = col - 1;
            int minRow = 0;
            int minCol = 0;

            while(cipherTextIndex < cipherLength) {

                for(int i = maxRow; i >= minRow; i--)
                {
                    cipherText[cipherTextIndex++] = matrix[i][maxCol];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(int i = maxCol - 1; i >= minCol; i--)
                {
                    cipherText[cipherTextIndex++] = matrix[minRow][i];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(int i = minRow + 1; i <= maxRow; i++)
                {
                    cipherText[cipherTextIndex++] = matrix[i][minCol];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(int i = minCol + 1; i <= maxCol - 1; i++)
                {
                    cipherText[cipherTextIndex++] = matrix[maxRow][i];
                }
                minRow++;
                minCol++;
                maxRow--;
                maxCol--;
            }
        }

        return new String(cipherText);
    }

    //method that decrypts a ciphered text
    public String decrypt(String cipherText){
        char[] cipherTextArray = cipherText.toCharArray();

        int col = (int)Math.abs(key);
        int row = (int)Math.ceil((double)(cipherTextArray.length) / col);

        int cipherTextLength = cipherTextArray.length;

        char[][] encryptedMatrix = new char[row][col];

        int cipherTextIndex = 0;

        if(key > 0)
        {
            int maxRow = row - 1;
            int maxCol = col - 1;
            int minRow = 0;
            int minCol = 0;

            while(cipherTextIndex < cipherTextLength){

                for(int i = minRow; i <= maxRow; i++)
                {
                    encryptedMatrix[i][minCol] = cipherTextArray[cipherTextIndex++];
                }

                if(cipherTextIndex >= cipherTextLength) {
                    break;
                }

                for(int i = minCol + 1; i <= maxCol; i++)
                {
                    encryptedMatrix[maxRow][i] = cipherTextArray[cipherTextIndex++];
                }

                if(cipherTextIndex >= cipherTextLength) {
                    break;
                }

                for(int i = maxRow - 1; i >= minRow; i--)
                {
                    encryptedMatrix[i][maxCol] = cipherTextArray[cipherTextIndex++];
                }

                if(cipherTextIndex >= cipherTextLength) {
                    break;
                }

                for(int i = maxCol- 1; i >= minCol + 1; i--)
                {
                    encryptedMatrix[minRow][i] = cipherTextArray[cipherTextIndex++];
                }
                minRow++;
                minCol++;
                maxRow--;
                maxCol--;
            }
        }
        else{
            int maxRow = row - 1;
            int maxCol = col - 1;
            int minRow = 0;
            int minCol = 0;

            while(cipherTextIndex < cipherTextLength) {

                for(int i = maxRow; i >= minRow; i--) {
                    encryptedMatrix[i][maxCol] = cipherTextArray[cipherTextIndex++];
                }

                if(cipherTextIndex >= cipherTextLength) {
                    break;
                }

                for(int i = maxCol - 1; i >= minCol; i--) {
                    encryptedMatrix[minRow][i] = cipherTextArray[cipherTextIndex++];
                }

                if(cipherTextIndex >= cipherTextLength) {
                    break;
                }

                for(int i = minRow + 1; i <= maxRow; i++) {
                    encryptedMatrix[i][minCol] = cipherTextArray[cipherTextIndex++];
                }

                if(cipherTextIndex >= cipherTextLength) {
                    break;
                }

                for(int i = minCol + 1; i <= maxCol - 1; i++) {
                    encryptedMatrix[maxRow][i] = cipherTextArray[cipherTextIndex++];
                }
                minRow++;
                minCol++;
                maxRow--;
                maxCol--;
            }
        }
        char[] decryptedStringArray = makeArrayFromEncryptedMatrix(encryptedMatrix, row, col);
        return new String(decryptedStringArray);
    }

    //method that modifies a given array (returns an array only with letters)
    private char[] changeArray (char[] array){
        char[] resultArray;
        int resultArrayLength = 0;
        int resultArrayIndex = 0;


        for(int i = 0; i < array.length; i++) {
            if((array[i] >= 'a' && array[i] <= 'z') || (array[i] >= 'A' && array[i] <= 'Z')) {
                resultArrayLength++;
            }
        }

        resultArray = new char[resultArrayLength];

        for (int i = 0; i < array.length; i++) {
            if((array[i] >= 'a' && array[i] <= 'z') || (array[i] >= 'A' && array[i] <= 'Z')) {
                resultArray[resultArrayIndex++] = array[i];
            }
        }

        return resultArray;
    }

    //method that returns a matrix made from a given array and complements it with 'X' if necessary
    private char[][] makeMatrixForEncryption(char[] array, int rows, int columns) {
        char[][] resultMatrix;
        resultMatrix = new char[rows][columns];

        int arrayIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(arrayIndex < array.length) {
                    resultMatrix[i][j] = array[arrayIndex++];
                }
                else{
                    resultMatrix[i][j] = 'X';
                }
            }
        }

        return resultMatrix;
    }

    // method that makes a char[] from given matrix and pay attention to the 'X'
    private char[] makeArrayFromEncryptedMatrix(char[][] matrix, int rows, int columns) {
        int countX = 0;

        for(int i = 0; i < columns - 1; i++) {
            if(matrix[rows - 1][i] == 'X' && matrix[rows - 1][i + 1] == 'X') {
                countX++;
            }
        }

        char[] resultArray = new char[rows * columns - countX];
        int resultArrayIndex = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++){
                if(i == rows - 1 && j != columns - 1 &&
                        matrix[rows - 1][j] == 'X' && matrix[rows - 1][j + 1] == 'X') {
                    continue;
                }
                resultArray[resultArrayIndex++] = matrix[i][j];
            }
        }

        return resultArray;
    }

    @Override
    public String toString(){
        return String.format("The key is: %d", key);
    }
}
