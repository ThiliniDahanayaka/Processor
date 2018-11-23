public class AddressMux1 extends Mux implements Module {

    public AddressMux2 addmux;

    public AddressMux1(AddressMux2 m){
        this.addmux = m;
    }

    @Override
    public void clock() {
        addmux.in1 = this.setOutput();
    }
}
