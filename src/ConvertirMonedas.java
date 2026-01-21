import java.util.Scanner;

public class ConvertirMonedas {


    public String elegirOpcion(int opcion) {
        Scanner lectura = new Scanner(System.in);
        Utilidades utilidades = new Utilidades();


        if (opcion < 0 || opcion > 9) {
            throw new IllegalArgumentException("Opción inválida: Debe ingresar opciones disponible del menu (numero del [0] al [9])");
        }

        String opcionSeleccionada = null;
        switch (opcion) {
            case 1:
                opcionSeleccionada =  "USD";
                break;
            case 2:
                opcionSeleccionada =  "DOP";
                break;
            case 3:
                opcionSeleccionada =  "ARS";
                break;
            case 4:
                opcionSeleccionada =  "COP";
                break;
            case 5:
                opcionSeleccionada =  "VES";
                break;
            case 6:
                opcionSeleccionada =  "CLP";
                break;
            case 7:
                opcionSeleccionada =  "EUR";
                break;
            case 8:
                System.out.print("Digite el CÓDIGO de la moneda: --> ");
                opcionSeleccionada = lectura.next();
                break;
            case 9:
                return utilidades.mostrarHistoricoConversiones();
            case 0:
                opcionSeleccionada = "0";
                break;
            default :
                throw new IllegalStateException("Opción invalida: "+ opcionSeleccionada +" no es una opción del menu, debe ingresar solo números del [0] al [9].");

        }
            return opcionSeleccionada;
    }
}
