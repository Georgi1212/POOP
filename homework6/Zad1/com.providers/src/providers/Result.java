package providers;

import java.util.Arrays;

public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data){
        setChars(chars);
        setData(data);
    }

    public void setChars(char[] chars){
        if(chars == null){
            this.chars = new char[0];
        }
        else{
            this.chars = new char[chars.length];

            for (int i = 0; i < chars.length; i++) {
                this.chars[i] = chars[i];
            }
        }
    }

    public void setData(int data){
        if(data < 0){
            this.data = 0;
        }
        else{
            this.data = data;
        }
    }

    public char[] getChars() {
        char[] copy = new char[this.chars.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = this.chars[i];
        }
        return copy;
    }

    public int getData(){
        return data;
    }

    @Override
    public String toString(){
        return String.format("Chars: %s%nResult: %d", Arrays.toString(this.chars), this.data);
    }
}
