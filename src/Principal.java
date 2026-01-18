import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConversorService conversorService = new ConversorService();
        Utilidades utilidades = new Utilidades();

        String monedaOrigen = "";
        String monedaDestino = "";
        double monto;

        String separador1 = "-----------------------------------------------------------------";
        String separador2 = "*****************************************************************";
        String menu = """
                ****** Seleccione las MONEDA digitando el numero del menu ******* 
                      ************************  MENU  ***********************
                      *     1. USD - Dólar estadounidense                   *
                      *     2. DOP - Peso dominicano                        *
                      *     3. ARS - Peso argentino                         *
                      *     4. COP - Peso colombiano                        *
                      *     5. VES - Bolívar Soberano venezolano            *
                      *     6. EUR - Euro                                   *
                      *     7. HTG - Gourde haitiano                        *
                      *     8. Otras monedas (Digitar Código de la Moneda)  *
                      *     9. Ver Historia de Conversiones                 *
                      *     0. Salir                                        *
                      *******************************************************
                """;

        System.out.println(separador2);
        System.out.println("֍֍֍֍֍֍֍֍֍֍֍- Bienvenido/a a Currency Convert Master  -֍֍֍֍֍֍֍֍֍֍֍".toUpperCase());
        System.out.println(separador2);

        System.out.println("\n"+menu);
        System.out.println(separador1+ "\n");

        LectorDeMonedas lectorDeMonedas = new LectorDeMonedas();

        int opcion = -1;

        System.out.print("Moneda ORIGEN: --> ");
        opcion = lectura.nextInt();
        monedaOrigen = lectorDeMonedas.elegirOpcion(opcion);

        System.out.print("Moneda DESTINO: --> ");
        opcion = lectura.nextInt();
        monedaDestino = lectorDeMonedas.elegirOpcion(opcion);

        System.out.print("Monto: --> ");
        monto = lectura.nextDouble();

        try {
            PairConversionModel pairConversionModel =  conversorService.convertirMonedasPorPares(monedaOrigen, monedaDestino, monto);
            String fechaFormateada = utilidades.formatearFecha(pairConversionModel.time_last_update_utc);

            System.out.println(pairConversionModel.toString());

            utilidades.guardarHistoricoConversiones(pairConversionModel);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}