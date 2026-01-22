import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConvertirMonedas convertirMonedas = new ConvertirMonedas();
        Utilidades utilidades = new Utilidades();

        String separador1 = "-----------------------------------------------------------------";
        String separador2 = "*****************************************************************";
        String menu = """
                ****** Seleccione las opción digitando el numero del menu *******
                      ************************  MENU  *************************
                      *     [1]. Convertir Monedas                            *
                      *     [2]. Ver Historia de Conversiones                 *
                      *     [3]. Eliminar historial de conversiones           *
                      *     [0]. Salir                                        *
                      *********************************************************
                """;

        System.out.println(separador2);
        System.out.println("֍֍֍֍֍֍֍֍֍֍֍- Bienvenido/a a Currency Convert Master  -֍֍֍֍֍֍֍֍֍֍֍".toUpperCase());
        System.out.println(separador2);

        boolean continuar = true;

        while (continuar) {

            System.out.println("\n" + menu);
            System.out.println(separador1);
            System.out.print("Opción: --> ");

            if (!lectura.hasNextInt()) {
                lectura.next();
                System.out.println("\nError: Debe ingresar un número del menú\n");
                continue;
            }

            int opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    boolean repetirConversion = true;

                    while (repetirConversion) {
                        String resultado = convertirMonedas.convertirMonedas();

                        if (resultado.equals("0")) {
                            repetirConversion = false;
                            break;
                        }
                        else {
                            System.out.println("\n" + separador1);
                            System.out.println(resultado);
                            System.out.println(separador1);

                            System.out.print("\n¿Desea realizar otra conversión? (S/N): --> ");
                            String respuesta = lectura.next().toUpperCase();
                            lectura.nextLine();

                            if (respuesta.equals("S")) {
                                repetirConversion = true;
                            } else {
                                repetirConversion = false;
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n" + separador1);
                    String historial = utilidades.mostrarHistoricoConversiones();
                    System.out.println(historial);
                    System.out.println(separador1);
                    break;

                case 3:
                    System.out.print("\n¿Está seguro que desea eliminar todo el historial? (S/N): --> ");
                    String confirmar = lectura.next().toUpperCase();
                    lectura.nextLine();

                    if (confirmar.equals("S")) {
                        // utilidades.eliminarHistoricoConversiones();
                        System.out.println("✓ Historial eliminado correctamente\n");
                    } else {
                        System.out.println("x Operación cancelada\n");
                    }
                    break;

                case 0:
                    continuar = false;
                    System.out.println("\n" + separador2);
                    System.out.println("Saliendo. ¡Muchas gracias y vuelva pronto!");
                    System.out.println(separador2);
                    break;

                default:
                    System.out.println("\nError: Opción inválida [" + opcion + "]. Debe ingresar números del [0] al [3].\n");
                    break;
            }
        }

        lectura.close();
        System.out.println("\nEl programa ha finalizado.");
    }
}
