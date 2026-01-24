import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PairConversionModel {
    public String time_last_update_utc;
    public String base_code;
    public String target_code;
    public double conversion_rate;
    public double conversion_result;

    public Date fecha_registro;

    @Override
    public String toString() {

        Utilidades utilidades = new Utilidades();
        String fechaFormateada = utilidades.formatearFecha(time_last_update_utc);

        return String.format(
                "    Convirtiendo de: %s a %s%n" +
                        "    A la Fecha (%s) 1 %s = %.2f %s%n" +
                        "    Resultado: %.2f %s",
                base_code, target_code,
                fechaFormateada, base_code, conversion_rate, target_code,
                conversion_result, target_code
        );

    }

}

