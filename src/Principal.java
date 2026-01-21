import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {


        boolean continuar = true;
        Scanner lectura = new Scanner(System.in);

        while (continuar) {

            String separador1 = "-----------------------------------------------------------------";
            String separador2 = "*****************************************************************";
            String menu = """
                        ****** Seleccione las MONEDA digitando el numero del menu *******
                              ************************  MENU  *************************
                              *     [1]. USD - Dólar estadounidense                   *
                              *     [2]. DOP - Peso dominicano                        *
                              *     [3]. ARS - Peso argentino                         *
                              *     [4]. COP - Peso colombiano                        *
                              *     [5]. VES - Bolívar Soberano venezolano            *
                              *     [6]. EUR - Euro                                   *
                              *     [7]. HTG - Gourde haitiano                        *
                              *     [8]. Otras monedas (Digitar Código de la Moneda)  *
                              *     [9]. Ver Historia de Conversiones                 *
                              *     [0]. Salir                                        *
                              *********************************************************
                        """;

            System.out.println(separador2);
            System.out.println("֍֍֍֍֍֍֍֍֍֍֍- Bienvenido/a a Currency Convert Master  -֍֍֍֍֍֍֍֍֍֍֍".toUpperCase());
            System.out.println(separador2);

            System.out.println("\n" + menu);
            System.out.println(separador1 + "\n");

            String monedaOrigen = "";
            String monedaDestino = "";
            double monto = 0;

            ConversorService conversorService = new ConversorService();
            Utilidades utilidades = new Utilidades();
            ConvertirMonedas convertirMonedas = new ConvertirMonedas();

            // Aquí se captura la moneda origen
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Moneda ORIGEN: --> ");
                    if (!lectura.hasNextInt()) {
                        lectura.next();
                        throw new IllegalArgumentException("No se debe ingresar letras, solo números del menu");
                    }
                    int opcion = lectura.nextInt();

                    // Aquí se verificar si el usuario quiere salir
                    if (opcion == 0) {
                        System.out.println("\nSaliendo. Muchas gracias y vuelva pronto!");
                        continuar = false;
                        entradaValida = true;
                        break;
                    }

                    monedaOrigen = convertirMonedas.elegirOpcion(opcion);
                    entradaValida = true;

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Inténtelo nuevamente.\n");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Inténtelo nuevamente.\n");
                }
            }

            if (!continuar) {
                break;
            }

            // Aquí se captura la moneda destino
            entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Moneda DESTINO: --> ");
                    if (!lectura.hasNextInt()) {
                        lectura.next();
                        throw new IllegalArgumentException("No se debe ingresar letras, solo números del menu");
                    }
                    int opcion = lectura.nextInt();

                    // Aquí se verifica si el usuario quiere salir
                    if (opcion == 0) {
                        System.out.println("\nSaliendo. Muchas gracias y vuelva pronto!");
                        continuar = false;
                        entradaValida = true;
                        break;
                    }

                    monedaDestino = convertirMonedas.elegirOpcion(opcion);
                    entradaValida = true;

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Inténtelo nuevamente.\n");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Inténtelo nuevamente.\n");
                }
            }


            if (!continuar) {
                break;
            }

            //Aquí se captura el monto
            entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Monto: --> ");
                    if (!lectura.hasNextDouble()) {
                        lectura.next();
                        throw new IllegalArgumentException("No se debe ingresar letras, solo números enteros o decimales con comas (,)");
                    }
                    monto = lectura.nextDouble();

                    if (monto <= 0) {
                        throw new IllegalArgumentException("El monto debe ser mayor a 0");
                    }
                    entradaValida = true;

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Intente nuevamente.\n");
                } catch (Exception e) {
                    System.out.println("Error inesperado: " + e.getMessage());
                    System.out.println("Intente nuevamente.\n");
                }
            }

            //  Aquí se realiza la Conversion
            try {
                PairConversionModel pairConversionModel = conversorService.convertirMonedasPorPares(monedaOrigen, monedaDestino, monto);

                if (pairConversionModel == null) {
                    System.out.println("\nOcurrió un error, reintente otra vez\n");
                } else {
                    System.out.println("\n" + separador1);
                    System.out.println(pairConversionModel);
                    System.out.println(separador1);
                    utilidades.guardarHistoricoConversiones(pairConversionModel);
                    System.out.println("✓ Conversión guardada en el historial\n");
                }

            } catch (Exception e) {
                System.out.println("Error en la conversión: " + e.getMessage() + "\n");
            }

            // Aquí se pregunta si el usuario desea realizar otra conversión
            System.out.print("\n¿Desea realizar otra conversión? (S/N): --> ");
            String respuesta = lectura.next().toUpperCase();

            if (!respuesta.equals("S")) {
                System.out.println("\nSaliendo. Muchas gracias y vuelva pronto!");
                continuar = false;
            }
            System.out.println();
        }

        lectura.close();
    }
}