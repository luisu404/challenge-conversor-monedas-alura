import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConversorService conversorService = new ConversorService();
        PairConversionModel pairConversionModel = new PairConversionModel();

        String separador1 = "-----------------------------------------------------------------";
        String separador2 = "*****************************************************************";
        String menu = """
                ****** Seleccione las MONEDA digitando el numero del menu ******* 
                      ***********************  MENU  **********************
                      *     1. USD - Dólar estadounidense                 *
                      *     2. DOP - Peso dominicano                      *
                      *     3. ARS - Peso argentino                       *
                      *     4. COP - Peso colombiano                      *
                      *     5. VES - Bolívar Soberano venezolano          *
                      *     6. CLP - Peso chileno                         *
                      *     7. EUR - Euro                                 *
                      *     8. HTG - Gourde haitiano                      *
                      *     9. Otras monedas                              *
                      *     0. Salir                                      *
                      *****************************************************
                """;

        System.out.println(separador2);
        System.out.println("֍֍֍֍֍֍֍֍֍֍֍- Bienvenido/a a Currency Convert Master  -֍֍֍֍֍֍֍֍֍֍֍".toUpperCase());
        System.out.println(separador2);

        System.out.println("\n"+menu);
        System.out.println(separador1+ "\n");

//        System.out.print("Moneda ORIGEN: --> ");
//        pairConversionModel.base_code = lectura.next();
//        System.out.print("Moneda DESTINO: --> ");
//        pairConversionModel.target_code = lectura.next();
//        System.out.print("Monto: --> ");
//        pairConversionModel.conversion_rate = lectura.nextDouble();
        //System.out.println(separador1);


        int origen = -1;
        System.out.print("Moneda ORIGEN: --> ");
        origen = lectura.nextInt();
        switch (origen){
            case 1:
                pairConversionModel.base_code = "USD";
                break;
            case 2:
                pairConversionModel.base_code = "DOP";
                break;
            case 3:
                pairConversionModel.base_code = "ARS";
                break;
            case 4:
                pairConversionModel.base_code = "COP";
                break;
            case 5:
                pairConversionModel.base_code = "VES";
                break;
            case 6:
                pairConversionModel.base_code = "CLP";
                break;
            case 7:
                pairConversionModel.base_code = "EUR";
                break;
            case 8:
                pairConversionModel.base_code = "HTG";
                break;
            case 9:
                System.out.print("CÓDIGO de la moneda de ORIGEN: -->");
                pairConversionModel.base_code = lectura.next();
                break;
            case 0:

                break;

        }



        int destino = -1;
        System.out.print("Moneda DESTINO: --> ");
        destino = lectura.nextInt();
        switch (destino){
            case 1:
                pairConversionModel.target_code = "USD";
                break;
            case 2:
                pairConversionModel.target_code = "DOP";
                break;
            case 3:
                pairConversionModel.target_code = "ARS";
                break;
            case 4:
                pairConversionModel.target_code = "COP";
                break;
            case 5:
                pairConversionModel.target_code = "VES";
                break;
            case 6:
                pairConversionModel.target_code = "CLP";
                break;
            case 7:
                pairConversionModel.target_code = "EUR";
                break;
            case 8:
                pairConversionModel.target_code = "HTG";
                break;
            case 9:
                System.out.print("CÓDIGO de la moneda de DESTINO: -->");
                pairConversionModel.target_code = lectura.next();

                break;
            case 0:

                break;

        }

        System.out.print("Monto: --> ");
        pairConversionModel.conversion_rate = lectura.nextDouble();

try {
    System.out.println("Las monedas seleccionadas son: "+ pairConversionModel.base_code + " y " + pairConversionModel.target_code);
    pairConversionModel = conversorService.convertirMonedasPorPares(pairConversionModel.base_code, pairConversionModel.target_code, pairConversionModel.conversion_rate);

    System.out.println(pairConversionModel.toString());

}catch (Exception e)
{
    System.out.println(e.getMessage());
}






    }
}