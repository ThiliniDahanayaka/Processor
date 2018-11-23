public class RegWriteBackMux extends Mux implements Module {
    public RegisterSet r1;

    public RegWriteBackMux(RegisterSet r){
        this.r1 = r;
    }

    @Override
    public void clock() {
        r1.writeData = this.setOutput();
    }
}
