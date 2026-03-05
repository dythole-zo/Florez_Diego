package banco;
public class Cuenta {
    private int num_cuenta;
    private float saldo;

    public Cuenta(){

    }
    public Cuenta(int num_cuenta, float saldo){
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
    }

    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }
    public int getNum_cuenta() {
        return num_cuenta;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public float getSaldo() {
        return saldo;
    }
    @Override
    public String toString() {
        return num_cuenta + " " + saldo ;
    }

}