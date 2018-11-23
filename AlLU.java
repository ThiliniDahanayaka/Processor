public class AlLU implements Module {
    public int in1;
    public int in2;
    public byte ALUcontroller;

    public AddressMux1 amux;
    public DataMem dm;
    public RegWriteBackMux mux;

    private int result;
    private boolean overflow;
    private boolean carry;
    public boolean branch;
    public boolean zero;

    public AlLU(AddressMux1 a, DataMem d, RegWriteBackMux m){
        this.amux = a;
        this.dm = d;
        this.mux = m;
        this.zero = false;
    }

    @Override
    public void clock() {
        this.Calc();
        dm.Address = result;
        mux.in1 = result;
        amux.control = branch & zero ;
    }

    private void Calc(){
        //Add
        if(ALUcontroller == 0b0010){
            result = in1+in2;
            if (result==0) zero = true;
            else zero = false;

        }
        //Subtract
        else if (ALUcontroller == 0b0110){
            result = in1-in2;
            if (result==0) zero = true;
            else zero = false;
        }
        //bitwise AND
        else if (ALUcontroller == 0b0000){
            result = in1&in2;
            if (result==0) zero = true;
            else zero = false;
            overflow = false;
            carry = false;
        }
        //bitwise OR
        else if (ALUcontroller == 0b0001){
            result = in1|in2;
            if (result==0) zero = true;
            else zero = false;
            overflow = false;
            carry = false;
        }
        //set-on-less-than
        else if (ALUcontroller == 0b0111){
            if(in1<in2)result= 1;
            else result = 0;
        }


    }
}
