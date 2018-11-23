public class Wire {
    private int width; //size of wire in bits
    private int data; //value of wire

    public Wire(int width){
        this.width = width;
    }

    public void setValue(int val){
        this.data = val;
    }

    public int getValue(){
        return this.data;
    }
}
