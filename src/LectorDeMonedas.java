import java.util.Map;
import java.util.Scanner;

public class LectorDeMonedas {
    private static String leerMoneda(Scanner lectura, Map<Integer, String> monedas, String tipo) {
        System.out.print("Moneda " + tipo + ": --> ");
        int opcion = lectura.nextInt();

        if (opcion == 0) {
            System.out.println("Saliendo del programa...");
            System.exit(0);
        }

        if (opcion == 9) {
            System.out.print("CÓDIGO de la moneda de " + tipo + ": --> ");
            return lectura.next().toUpperCase();
        }

        return monedas.get(opcion);
    }
}
