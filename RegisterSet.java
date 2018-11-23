
public class RegisterSet implements Module{

    private int [] registerset = new int[32];

    public boolean RegWrite;
    public int readRegister1;
    public int readRegister2;
    public int writeRegister;
    public int writeData;

    public AlLU A;
    public Mux m1;
    public DataMem DM;


    public RegisterSet(AlLU a, Mux m, DataMem d){
        this.A = a;
        this.m1 = m;
        this.DM = d;
    }

    public void clock(){
        A.in1 = (registerset[readRegister1]);
        m1.in1 = (registerset[readRegister2]);
        DM.writeData = (registerset[readRegister2]);
        if(RegWrite) registerset[writeRegister] = writeData;
    }
}
