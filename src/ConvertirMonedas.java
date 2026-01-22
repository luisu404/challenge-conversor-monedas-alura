import java.util.Scanner;

public class ConvertirMonedas {

    public String convertirMonedas() {

        ConversorService conversorService = new ConversorService();
        Utilidades utilidades = new Utilidades();
        Scanner lectura = new Scanner(System.in);

        String separador1 = "-----------------------------------------------------------------";
        String menu = """
                
                ****** Seleccione las MONEDAS digitando el numero del menu *******
                      ************************  MENU  *************************
                      *     [1]. USD - Dólar estadounidense                   *
                      *     [2]. DOP - Peso dominicano                        *
                      *     [3]. BRL - Real Brasileño                         *
                      *     [4]. ARS - Peso argentino                         *
                      *     [5]. COP - Peso colombiano                        *
                      *     [6]. VES - Bolívar Soberano venezolano            *
                      *     [7]. EUR - Euro                                   *
                      *     [8]. HTG - Gourde haitiano                        *
                      *     [9]. Otras monedas (Digitar Código de la Moneda)  *
                      *     [0]. Volver al menú principal                     *
                      *********************************************************
                """;

        System.out.println(menu);
        System.out.println(separador1);

        String monedaOrigen = "";
        String monedaDestino = "";
        double monto = 0;

        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Moneda ORIGEN: --> ");

                if (!lectura.hasNextInt()) {
                    lectura.next();
                    System.out.println("Error: No se debe ingresar letras, solo números del menú");
                    System.out.println("Inténtelo nuevamente.\n");
                    continue;
                }

                int opcion = lectura.nextInt();

                if (opcion == 0) {
                    System.out.println("\n← Volviendo al menú principal...\n");
                    return "0";
                }

                monedaOrigen = elegirOpcion(opcion);

                if (monedaOrigen == null || monedaOrigen.isEmpty()) {
                    System.out.println("Error: No se pudo obtener la moneda");
                    continue;
                }

                entradaValida = true;

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Inténtelo nuevamente.\n");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("Inténtelo nuevamente.\n");
            }
        }

        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Moneda DESTINO: --> ");

                if (!lectura.hasNextInt()) {
                    lectura.next();
                    System.out.println("Error: No se debe ingresar letras, solo números del menú");
                    System.out.println("Inténtelo nuevamente.\n");
                    continue;
                }

                int opcion = lectura.nextInt();

                if (opcion == 0) {
                    System.out.println("\n← Volviendo al menú principal...\n");
                    return "0";
                }

                monedaDestino = elegirOpcion(opcion);

                if (monedaDestino == null || monedaDestino.isEmpty()) {
                    System.out.println("Error: No se pudo obtener la moneda");
                    continue;
                }

                entradaValida = true;

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Inténtelo nuevamente.\n");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("Inténtelo nuevamente.\n");
            }
        }

        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Monto: --> ");

                if (!lectura.hasNextDouble()) {
                    lectura.next();
                    System.out.println("Error: No se debe ingresar letras, solo números enteros o decimales");
                    System.out.println("Inténtelo nuevamente.\n");
                    continue;
                }

                monto = lectura.nextDouble();

                if (monto <= 0) {
                    System.out.println("Error: El monto debe ser mayor a 0");
                    System.out.println("Inténtelo nuevamente.\n");
                    continue;
                }

                entradaValida = true;

            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("Intente nuevamente.\n");
            }
        }


        try {
            PairConversionModel pairConversionModel = conversorService.convertirMonedasPorPares(monedaOrigen, monedaDestino, monto);

            String mensajeHistorial = "";
            if (utilidades.guardarHistoricoConversiones(pairConversionModel)) {
                mensajeHistorial = "✓ Conversión guardada en el historial";
            } else {
                mensajeHistorial = "✗ No se pudo guardar la conversión en el historial";
            }

            return pairConversionModel.toString() + "\n" + mensajeHistorial;

        } catch (NullPointerException e) {
            return "✗ Ocurrió un error: " + e.getMessage();
        } catch (Exception e) {
            return "✗ Error en la conversión: " + e.getMessage();
        }
    }

    public String elegirOpcion(int opcion) {
        Scanner lectura = new Scanner(System.in);

        if (opcion < 0 || opcion > 9) {
            throw new IllegalArgumentException("Opción inválida: Debe ingresar opciones disponibles del menú (número del [0] al [9])");
        }

        String opcionSeleccionada = null;

        switch (opcion) {
            case 1:
                opcionSeleccionada = "USD";
                break;
            case 2:
                opcionSeleccionada = "DOP";
                break;
            case 3:
                opcionSeleccionada = "BRL";
                break;
            case 4:
                opcionSeleccionada = "ARS";
                break;
            case 5:
                opcionSeleccionada = "COP";
                break;
            case 6:
                opcionSeleccionada = "VES";
                break;
            case 7:
                opcionSeleccionada = "EUR";
                break;
            case 8:
                opcionSeleccionada = "HTG";
                break;
            case 9:
                System.out.print("Digite el CÓDIGO de la moneda (3 letras): --> ");
                opcionSeleccionada = lectura.next().toUpperCase();

                if (opcionSeleccionada.length() != 3) {
                    throw new IllegalArgumentException("El código de moneda debe tener exactamente 3 caracteres");
                }
                break;
            case 0:
                opcionSeleccionada = "0";
                break;
            default:
                throw new IllegalArgumentException("Opción inválida: " + opcion + " no es una opción del menú");
        }

        return opcionSeleccionada;
    }
}