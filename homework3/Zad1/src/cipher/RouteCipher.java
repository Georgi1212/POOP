package cipher;

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

    public String encrypt(String plainText){
        char[] plainTextArray = plainText.toCharArray();
        plainTextArray = changeArray(plainTextArray);

        char[][] matrix = makeMatrixForEncryption(plainTextArray);

        int row = matrix.length;
        int col = matrix[0].length;
        int cipherLength = row * col;

        char[] cipherText = new char[cipherLength];
        int cipherTextIndex = 0;

        if(key > 0){
            int level = 0;
            int rowCount = row - 1;
            int colCount = col - 1;
            int rowIndex = 0;
            int colIndex = 0;

            while(cipherTextIndex < cipherLength)
            {
                for(rowIndex = level; rowIndex <= rowCount; rowIndex++)
                {
                    cipherText[cipherTextIndex++] = matrix[rowIndex][level];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(colIndex = level + 1; colIndex <= colCount; colIndex++)
                {
                    cipherText[cipherTextIndex++] = matrix[rowCount][colIndex];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(rowIndex = rowCount - 1; rowIndex >= level; rowIndex--)
                {
                    cipherText[cipherTextIndex++] = matrix[rowIndex][colCount-1];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(colIndex = colCount - 1; colCount >= level + 1; colCount--)
                {
                    cipherText[cipherTextIndex++] = matrix[level][colIndex];
                }

                rowCount--;
                colCount--;
                level++;
            }

        }
        else{
            int level = 0;
            int rowCount = row - 1;
            int colCount = col - 1;
            int rowIndex = 0;
            int colIndex = 0;

            while(cipherTextIndex < cipherLength)
            {
                for(rowIndex = rowCount; rowIndex >= level; rowIndex--)
                {
                    cipherText[cipherTextIndex++] = matrix[rowIndex][colCount];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(colIndex = colCount - 1; colIndex >= level; colIndex--)
                {
                    cipherText[cipherTextIndex++] = matrix[level][colIndex];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(rowIndex = level + 1; rowIndex <= rowCount; rowIndex++)
                {
                    cipherText[cipherTextIndex++] = matrix[rowIndex][level];
                }

                if(cipherTextIndex >= cipherLength) {
                    break;
                }

                for(colIndex = level + 1; colCount <= colCount - 1; colCount++)
                {
                    cipherText[cipherTextIndex++] = matrix[rowCount][colIndex];
                }

                rowCount--;
                colCount--;
                level++;
            }
        }

        String text = new String (cipherText);
        return text;
    }

    public String decrypt(String cipherText){
        char[] cipherTextArray = cipherText.toCharArray();
    }

    private char[] changeArray (char[] array){
        char[] resultArray;
        int resultArrayLength = 0;
        int resultArrayIndex = 0;


        for(int i = 0; i < array.length; i++)
        {
            if((array[i] >= 'a' && array[i] >= 'z') ||
                (array[i] >= 'A' && array[i] >= 'Z'))
            {
                resultArrayLength++;
            }
        }

        resultArray = new char[resultArrayLength];

        for (int i = 0; i < array.length; i++) {
            if((array[i] >= 'a' && array[i] >= 'z') ||
                (array[i] >= 'A' && array[i] >= 'Z'))
            {
                resultArray[resultArrayIndex] = array[i];
                resultArrayIndex++;
            }
        }

        return resultArray;
    }

    private char[][] makeMatrixForEncryption(char[] array) {
        char[][] resultMatrix;
        int columns = Math.abs(key);
        int rows = (int)Math.ceil((double)(array.length) / columns);

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

    @Override
    public String toString() {
        return String.format("The key is: %d", key);
    }
}
