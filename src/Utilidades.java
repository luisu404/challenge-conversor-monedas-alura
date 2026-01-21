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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utilidades {

    public void guardarHistoricoConversiones(PairConversionModel pairConversionModel) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        File archivo = new File("HistorialConversiones.json");
        List<PairConversionModel> historial = new ArrayList<>();

        // 1. Leer si existe
        if (archivo.exists() && archivo.length() > 0) {
            try (FileReader reader = new FileReader(archivo)) {
                Type tipoLista = new TypeToken<List<PairConversionModel>>() {}.getType();
                historial = gson.fromJson(reader, tipoLista);

                if (historial == null) {
                    historial = new ArrayList<>();
                }
            } catch (IOException e) {
                System.err.println("Error al leer historial: " + e.getMessage());
            }
        }

        // 2. Agregar nueva conversión
        historial.add(pairConversionModel);

        // 3. Reescribir archivo
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar historial: " + e.getMessage());
        }
    }

    public List<PairConversionModel> leerHistoricoConversiones() {

        List<PairConversionModel> historial = null;

        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("HistorialConversiones.json");

            Type tipoLista = new TypeToken<List<PairConversionModel>>() {}.getType();
            historial = gson.fromJson(reader, tipoLista);

            reader.close();

        } catch (Exception e) {
            System.err.println("Error al leer el historial: " + e.getMessage());
        }

        return historial;
    }

    public String mostrarHistoricoConversiones() {
        List<PairConversionModel> historial = leerHistoricoConversiones();

        for (PairConversionModel item : historial){
           return item.toString();
        }
return "";

    }



    public String formatearFecha(String fechaSinFormato){
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
            SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");

            Date fecha = formatoEntrada.parse(fechaSinFormato);
            return formatoSalida.format(fecha);

        } catch (ParseException e) {
            throw new RuntimeException("Error al convertir la fecha: "+ fechaSinFormato +". Mensaje de Error: "+e.getMessage());
        }


    }


}
