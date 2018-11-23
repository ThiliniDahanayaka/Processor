public class ALUMux extends Mux implements Module{
    public AlLU a;
    public ALUMux(AlLU A){
        this.a = A;
    }

    public void clock(){
        a.in2 = this.setOutput();
    }
}
