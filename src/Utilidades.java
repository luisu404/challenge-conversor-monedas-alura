import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utilidades {

    Scanner lectura = new Scanner(System.in);

    public boolean guardarHistoricoConversiones(PairConversionModel pairConversionModel) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        File archivo = new File("HistorialConversiones.json");
        List<PairConversionModel> historial = new ArrayList<>();

        if (archivo.exists() && archivo.length() > 0) {
            try (FileReader reader = new FileReader(archivo)) {
                Type tipoLista = new TypeToken<List<PairConversionModel>>() {}.getType();
                historial = gson.fromJson(reader, tipoLista);

                if (historial == null) {
                    historial = new ArrayList<>();
                }
            } catch (IOException e) {
                System.err.println("Error al leer historial: " + e.getMessage());
                return false;
            }
        }
        pairConversionModel.fecha_registro = new Date();
        historial.add(pairConversionModel);

        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(historial, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar historial: " + e.getMessage());
            return false;
        }
    }

    public List<PairConversionModel> leerHistoricoConversiones() {
        File archivo = new File("HistorialConversiones.json");

        if (!archivo.exists() || archivo.length() == 0) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(archivo)) {
            Gson gson = new Gson();
            Type tipoLista = new TypeToken<List<PairConversionModel>>() {}.getType();
            List<PairConversionModel> historial = gson.fromJson(reader, tipoLista);

            return historial != null ? historial : new ArrayList<>();

        } catch (IOException e) {
            System.err.println("Error al leer el historial: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public String mostrarHistoricoConversiones() {
        List<PairConversionModel> historial = leerHistoricoConversiones();

        if (historial.isEmpty()) {
            return "No hay conversiones en el historial.";
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("\n════════════════ HISTORIAL DE CONVERSIONES ════════════════\n\n");

        int contador = 1;
        for (PairConversionModel item : historial) {
            resultado.append("──────────── Conversión #").append(contador).append(" ────────────\n");
            resultado.append(item.toString()).append("\n");

            if (item.fecha_registro != null) {
                resultado.append("Fecha de registro: ").append(formatearFecha(item.fecha_registro)).append("\n");
            }

            resultado.append("\n");
            contador++;
        }

        resultado.append("════════════════════════════════════════════════════════════\n");
        resultado.append("Total de conversiones: ").append(historial.size()).append("\n");

        return resultado.toString();
    }

    private String formatearFecha(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formato.format(fecha);
    }

    public String formatearFecha(String fechaUTC) {
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
            Date fecha = formatoEntrada.parse(fechaUTC);
            SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return formatoSalida.format(fecha);
        } catch (Exception e) {
            return fechaUTC;
        }
    }

    public void eliminarHistoricoConversiones() {
        System.out.print("\n¿Está seguro que desea eliminar todo el historial? (S/N): --> ");
        String confirmar = lectura.next().toUpperCase();
        lectura.nextLine();
        File archivo = new File("HistorialConversiones.json");

        if (Objects.equals(confirmar, "S")){
            if (archivo.exists()) {
                if (archivo.delete()) {
                    System.out.println("✓ Historial eliminado correctamente");
                }
                else {
                    System.err.println("✗ No se pudo eliminar el historial");
                }
            } else {
                System.out.println("No existe historial para eliminar");
            }
        }

         else {
            System.out.println("x Operación cancelada\n");
        }
    }

    public int contarConversiones() {
        List<PairConversionModel> historial = leerHistoricoConversiones();
        return historial.size();
    }

}
