public class ALUControl implements Module{
    boolean [] ALUOp = new boolean[2];
    byte instruction; //bit 0-5 of instruction
    public AlLU a;

    public ALUControl(AlLU A){
        this.a = A;
    }

    @Override
    public void clock() {
        if (!ALUOp[1]){
            if(ALUOp[0]){
                a.ALUcontroller = 0b0110;
            }else{
                a.ALUcontroller = 0b0010;
            }
        }else if(instruction==0b1010)a.ALUcontroller = 0b0111;
        else if(instruction==0b0101)a.ALUcontroller = 0b0001;
        else if(instruction==0b0100)a.ALUcontroller = 0b0000;
        else if(instruction==0b0010)a.ALUcontroller = 0b0110;
        else if(instruction==0b0000)a.ALUcontroller = 0b0010;
    }

}
