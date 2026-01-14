import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PairConversionModel {
    String time_last_update_utc;
    String base_code;
    String target_code;
    double conversion_rate;
    double conversion_result;



    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    //Date fecha = formatoFecha.parse(time_last_update_utc);
    String fechaFormateada = formatoFecha.format(time_last_update_utc);

    @Override
    public String toString() {
        return String.format(
                "A la Fecha %s 1 %s = %.2f \n %s a %s = %.2f",
                fechaFormateada,
                base_code,
                conversion_rate,
                base_code,
                target_code,
                conversion_result
        );
    }
}

