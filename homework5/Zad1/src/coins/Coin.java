package coins;

import java.util.Random;

public class Coin {
    private Random rand;
    private Face face;

    public Coin(Face face){
        rand = new Random();
        setFace(face);
    }

    public final Face getFace(){
        return face;
    }

    public final void setFace(Face face){
        if(face != null){
            this.face = face;
        }
        else{
            this.face = Face.HEAD;
        }
    }

    public void flip(){
        int result = rand.nextInt(2);
        if(result == 0){
            this.face = Face.HEAD;
        }
        else this.face = Face.TAIL;
    }

    public boolean isHeads(){
        return this.face == Face.HEAD;
    }

    @Override
    public String toString(){
        return face.toString();
    }
}
