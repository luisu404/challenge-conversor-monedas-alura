import java.util.Scanner;

public class LectorDeMonedas {
    public String elegirOpcion(int opcion) {
        Scanner lectura = new Scanner(System.in);
        Utilidades utilidades = new Utilidades();

        String opcionSeleccionada = "";
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
                return "Saliendo. Muchas, gracias y vuelva pronto!";
        }
            return opcionSeleccionada;
    }
}




//        switch (origen){
//            case 1:
//                monedaOrigen = "USD";
//                break;
//            case 2:
//                monedaOrigen = "DOP";
//                break;
//            case 3:
//                monedaOrigen = "ARS";
//                break;
//            case 4:
//                monedaOrigen = "COP";
//                break;
//            case 5:
//                monedaOrigen = "VES";
//                break;
//            case 6:
//                monedaOrigen = "CLP";
//                break;
//            case 7:
//                monedaOrigen = "EUR";
//                break;
//            case 8:
//                System.out.print("CÓDIGO de la moneda de ORIGEN: -->");
//                monedaOrigen = lectura.next();
//                break;
//            case 9:
//                utilidades.mostrarHistoricoConversiones();
//
//            case 0:
//
//                break;
//
//        }



//
//        switch (destino){
//            case 1:
//                monedaDestino = "USD";
//                break;
//            case 2:
//                monedaDestino = "DOP";
//                break;
//            case 3:
//                monedaDestino = "ARS";
//                break;
//            case 4:
//                monedaDestino = "COP";
//                break;
//            case 5:
//                monedaDestino = "VES";
//                break;
//            case 6:
//                monedaDestino = "CLP";
//                break;
//            case 7:
//                monedaDestino = "EUR";
//                break;
//            case 8:
//                System.out.print("CÓDIGO de la moneda de DESTINO: -->");
//                monedaDestino = lectura.next();
//                break;
//            case 9:
//                utilidades.mostrarHistoricoConversiones();
//            case 0:
//                System.out.println("Saliendo. Muchas, gracias y vuelva pronto!");
//                break;
//
//        }