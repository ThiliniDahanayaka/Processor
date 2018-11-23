public class Controller implements Module{
    /*public Boolean RegWrite;
    public Boolean ALUSrc;
    public Boolean MemWrite;
    public Boolean MemtoReg;
    public Boolean MemRead;
    public Boolean Branch;
    public Boolean Jump;
    public Boolean RegDst;
    public boolean [] ALUOp;*/

    public RegDestMux destreg;
    public AddressMux2 addmux2;
    public AlLU A;
    public DataMem dm;
    public RegWriteBackMux writereg;
    public ALUControl aCon;
    public ALUMux aluMux;
    public RegisterSet r1;

    int in;

    private int opcode;
    private int function;

    public Controller(RegDestMux destreg,AddressMux2 addmux2, AlLU A, DataMem dm, RegWriteBackMux writereg, ALUControl aCon, ALUMux aluMux, RegisterSet r1 ){
        this.destreg = destreg;
        this.addmux2 = addmux2;
        this.A = A;
        this.dm = dm;
        this.writereg = writereg;
        this.aCon = aCon;
        this.aluMux = aluMux;
        this.r1 = r1;
    }

    @Override
    public void clock() {
        this.decode();

        //R type
        if(opcode == 0b000000){
            destreg.control = true;
            r1.RegWrite = true;
            aluMux.control = false;
            dm.MemWrite = false;
            dm.MemRead = false;
            writereg.control = false;

            aCon.ALUOp[0] = false;
            aCon.ALUOp[1] = true;
            aCon.instruction = (byte)function;
        }

    }

    private void decode(){
        //Extract opcode (bit 26-31)
        int temp = 0b11111100000000000000000000000000;
        opcode = in & temp;
        opcode = opcode >>26;

        //extract function (useful only for R type)(bit 0-5)
        temp = 0b00000000000000000000000000111111;
        function = in & function;

    }
}
