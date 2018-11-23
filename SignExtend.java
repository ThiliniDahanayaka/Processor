public class SignExtend implements Module {

    public int in; //16 bit signed integer

    public ShiftLeft1 s;
    public ALUMux m;

    public SignExtend(ShiftLeft1 s, ALUMux m){
        this.s = s; this.m = m;
    }

    @Override
    public void clock() {
        m.in2 = signextend();
        s.in = m.in2;
    }

    private int signextend(){
        int temp1 = 0b11111111111111110000000000000000;
        if(in>=15) return (in|temp1);
        else return in;
    }
}
