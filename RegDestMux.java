public class RegDestMux extends Mux implements Module {

    RegisterSet regs;

    public RegDestMux(RegisterSet r){
        this.regs = r;
    }

    @Override
    public void clock() {
        regs.writeRegister = this.setOutput();
    }
}
