package acciones;
import banco.Cuenta;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Pedir numero y saldo inicial
        System.out.print("Digita tu numero de cuenta: ");
        int numcuenta = sc.nextInt();

        float saldoIni;
        do { //para dar la oportunidad de que pueda poner un valor valido
            System.out.print("Digite el saldo inicial (no puede ser negativo): ");
            saldoIni = sc.nextFloat();
            if (saldoIni < 0) {
                System.out.println("Error, el saldo no puede ser negativo");
            }
        } while (saldoIni < 0);

        Cuenta n_cuenta;
        if (saldoIni <= 0) {
            n_cuenta = new Cuenta(numcuenta, 0);
            System.out.println("Cuenta creada con saldo $0");
        } else {
            n_cuenta = new Cuenta(numcuenta, saldoIni);
            System.out.println("Cuenta creada con saldo $" + saldoIni);
        }

        // crear el menu de opciones
        int opc;
        do {
            System.out.println("--- MENU ---");
            System.out.println("1. Consignar ");
            System.out.println("2. Retirar ");
            System.out.println("3. Ver saldo ");
            System.out.print("Seleccione una opcion: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1: //para consignar
                    System.out.print("Digite el monto a consignar: ");
                    float consignar = sc.nextFloat();
                    if (consignar > 0) {
                        n_cuenta.setSaldo(n_cuenta.getSaldo() + consignar);
                        System.out.println("Consignación exitosa, saldo: $" + n_cuenta.getSaldo());
                    } else {
                        System.out.println("Error: el monto debe ser mayor a $0");
                    }
                    break;

                case 2: // para retirar
                    System.out.print("Digite el monto a retirar: ");
                    float retiro = sc.nextFloat();
                    if (retiro > 0 && retiro <= n_cuenta.getSaldo()) {
                        n_cuenta.setSaldo(n_cuenta.getSaldo() - retiro);
                        System.out.println("Retiro exitoso, saldo: $" + n_cuenta.getSaldo());
                    } else {
                        System.out.println("Error, sobrepasaste tu saldo");
                    }
                    break;

                case 3: //para ver el saldo
                    System.out.println("Su cuenta "+ numcuenta +" tiene saldo de $" + n_cuenta.getSaldo());
                    System.out.println("Hasta la proxima");
                    break;

                default: //mensaje por si pone un numero diferente al de las opciones
                    System.out.println("Error, intentelo de nuevo");
            }
        } while (opc != 3); //lo devuelve al menu hasta que elija bien las opciones

        sc.close();
    }
}
