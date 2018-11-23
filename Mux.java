public class Mux{
    int in1;
    int in2;
    boolean control;

    public int setOutput(){
        if(control) return in1;
        else return in2;
    }
}
