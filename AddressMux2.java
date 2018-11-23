public class AddressMux2 extends Mux implements Module {
    public PC pc;

    public AddressMux2(PC p){
        this.pc = p;
    }

    @Override
    public void clock() {
        pc.in = this.setOutput();
    }
}
