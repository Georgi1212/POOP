package coins;

public enum Face {
    HEAD("HEAD"),
    TAIL("TAIL");

    private final String face;

    Face(String face){
        if(face != null){
            this.face = face;
        }
        else{
            this.face = "HEAD";
        }
    }

    @Override
    public String toString(){
        return String.format("face: %s", face);
    }
}
