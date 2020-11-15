package pe.josue.util;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Util {
	
	public static double obtenerDesviacion(List<Integer> edades) {
		float media = 0;
		double varianza = 0.0;
		double desviacion = 0.0;
		int sumatoria = 0;
		sumatoria = edades.stream().reduce(0, Integer::sum);

		media = sumatoria / edades.size();
		System.out.println(media);
		for (Integer edad : edades) {
			double rango;
			rango = Math.pow(edad - media, 2f);
			varianza = varianza + rango;
		}
		System.out.println(varianza);
		varianza = varianza / edades.size();
		System.out.println(varianza);
		desviacion = Math.sqrt(varianza);
		System.out.println(desviacion);
		return desviacion;
	}
	
	public static double obtenerPromedio(List<Integer> edades) {
		int sumatoria = 0;
		sumatoria = edades.stream().reduce(0, Integer::sum);
		return sumatoria/edades.size();
	}
	
	public static Date generarFechaMuerte(Date birthDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthDate);
		int averageLifeMax = 80;
		int averageLifeMin = 34;
		int randomYearsPerson = new Random().nextInt((averageLifeMax - averageLifeMin) + 1) + averageLifeMin;
		int yearDeath = calendar.get(Calendar.YEAR) + randomYearsPerson;
		int monthDeath = new Random().nextInt((12)) + 1;
		YearMonth yearMonth = YearMonth.of(yearDeath, monthDeath);
		int daysInMonth = yearMonth.lengthOfMonth();
		return new GregorianCalendar(yearDeath,monthDeath,daysInMonth).getTime();
	}
}
