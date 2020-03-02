package pe.com.claro.website.admin.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;



/**
 * @author lucio
 *
 */
public class Fecha {

	public final static String language = "es";

	public final static String pais = "ES";

	public final static int OFFSET = 6;

	public final static String PATTERN_TIME_DATE = "dd/MM/yyyy H:mm:ss"; // Formato

	// fecha
	public final static String PATTERN_TIME_DATE_SIN_ANO = "dd/MM H:mm:ss"; // completa

	public final static String PATTERN_TIME_YEAR = "yyyy";
	
	public final static String PATTERN_TIME_MES = "MM";
	
	public final static String PATTERN_TIME_DAY = "dd";

	public final static String PATTERN_TIMEDATE_STR = "EEEE, dd 'de' MMMM 'de' yyyy";

	public final static String PATTERN_TIME = "H:mm:ss";

	public final static String PATTERN_TIME_SS = "ss";

	public final static String PATTERN_FECHAHORA_STR = "H:mm:ss - EEEE, dd 'de' MMMM 'de' yyyy";

	public final static String PATTERN_TIME_SHORT = "H:mm";

	public final static String PATTERN_DATE_SHORT = "d MMM yy";

	public final static String PATTERN_DATE_SEP_GUION = "dd-MM-yyyy";

	public final static String PATTERN_DATE_SEP_BARRA = "dd/MM/yyyy";

	public final static String PATTERN_DATE_JUNTO = "dd-MM-yyyy-H-mm-ss";

	public final static String PATTERN_HORA = "H";

	public final static String PATTERN_HORAMIN_NUMBER = "Hmm";

	public final static String PATTERN_DATE_NORMAL = "dd-MMM-yyyy";

	public final static String PATTERN_LOTUS = "dd/MM/yyyy H:mm";

	public final static String PATTERN_DATE_TIMEHM = "dd/MM/yyyy H:mm";

	public final static String PATTERN_MYSQL = "yyyy-MM-dd HH:mm:ss";

	public static Date getDateEs() {

		Date fechaServ = new Date(System.currentTimeMillis());

		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaServ);

		cal.add(Calendar.HOUR_OF_DAY, OFFSET);
		Date fechaEsp = cal.getTime();

		return fechaEsp;

	}

	public static String convDateToStr(Date fechaEsp, String formato) {

		try {

			if (fechaEsp == null)
				return "";

			Locale localeEs = new Locale(language, pais);

			SimpleDateFormat formatter;
			formatter = new SimpleDateFormat(formato, localeEs);

			return formatter.format(fechaEsp);

		} catch (Exception e) {
			return null;
		}

	}



	public static Date convStrToDate(String fechaStr, String formato) {

		try {

			SimpleDateFormat formatter = new SimpleDateFormat(formato);
			Date fecha = formatter.parse(fechaStr);

			return fecha;

		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("deprecation")
	public static Date convStrToDateMyJob(String fechaStr, String formato) {
		Date fecha;
		try {
			Locale localeEs = new Locale(language, pais);
			SimpleDateFormat formatter = new SimpleDateFormat(formato, localeEs);
			fecha = formatter.parse(fechaStr);

		} catch (Exception e) {
			return null;
		}

		String dateI = convDateToStr(fecha, Fecha.PATTERN_TIME_DATE);
		String dateII = dateI.replaceAll(getDateProyecto(), "2008");

		fecha = convStrToDate(dateII, Fecha.PATTERN_TIME_DATE);
		return fecha;
	}

	public static java.sql.Date getSqlDate(java.util.Date date) {

		if (date == null)
			return null;
		else
			return new java.sql.Date(date.getTime());
	}

	public static boolean isDiaLaborable() {
		// Dias laborables de la semana
		int[] diasSemana = { Calendar.MONDAY, Calendar.TUESDAY,
				Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY };

		int diaSemana = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

		boolean laborable = false;
		for (int i = 0; i < diasSemana.length; i++) {
			if (diaSemana == diasSemana[i]) {
				laborable = true;
				break;
			}
		}

		return laborable;
	}

	public static int diaDeSemana(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
		return diaSemana;
	}

	public static void diasSemana() {

		int[] diasSemana = { Calendar.MONDAY, Calendar.TUESDAY,
				Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY };
		for (int i = 0; i < diasSemana.length; i++) {
			System.out.println("Dia:" + diasSemana[i]);
		}
	}

	public static Date getFechaActual() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date temp = calendar.getTime();
		Date hoy = new Date(temp.getTime());
		return hoy;
	}
	
	/**
	 * Gets the fecha actual.
	 * @return 
	 */
	public String getFechaActualTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		return formattedDate;
	}

	public static Date addDiasAFecha(Date f1, int totalDias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(f1);
		calendar.add(Calendar.DAY_OF_MONTH, totalDias);
		Date f2 = new Date(calendar.getTime().getTime());
		return f2;
	}

	public static Date addMinutosAFecha(Date f1, int minutos) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(f1);
		calendar.add(Calendar.MINUTE, minutos);
		Date f2 = new Date(calendar.getTime().getTime());
		return f2;
	}


	public static String getDateProyecto() {
		Date fechaEsp = new Date();
		try {

			if (fechaEsp == null)
				return "";

			Locale localeEs = new Locale(language, pais);

			SimpleDateFormat formatter;
			formatter = new SimpleDateFormat(Fecha.PATTERN_TIME_YEAR, localeEs);

			return formatter.format(fechaEsp);

		} catch (Exception e) {
			return null;
		}

	}


	public static void main(String[] args) throws Exception {
		// String diaSemana = Fecha.convDateToStr(new Date() , "E");
/*
		System.out.println("data es:" + getDateProyecto());
		Date dat1 = convStrToDate("10/02/2008 19:20:00",
				Fecha.PATTERN_TIME_DATE);
		Date dat2 = convStrToDateMyJob("10/02/2008 19:20:00",
				Fecha.PATTERN_TIME_DATE);
		System.out.println("dat:1:" + dat1);
		System.out.println("dat:2" + dat2);

		diasSemana();
		Date date = new Date();*/
		Date date = new Date();
		date=Fecha.addDiasAFecha(date, -20);
		System.out.println(Fecha.convDateToStr(date, Fecha.PATTERN_TIME_YEAR));  // //convStrToDate("15/02/2011", Fecha.PATTERN_TIME_YEAR));
		System.out.println(Fecha.convDateToStr(date, Fecha.PATTERN_TIME_MES));   //("15/02/2011", Fecha.PATTERN_TIME_MES));
		System.out.println(Fecha.convDateToStr(date, Fecha.PATTERN_TIME_DAY));   //("15/02/2011", Fecha.PATTERN_TIME_DAY));

	}

}
