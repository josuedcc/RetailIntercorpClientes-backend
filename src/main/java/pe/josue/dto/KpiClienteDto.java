package pe.josue.dto;

public class KpiClienteDto {
	Double promedioEdad;
	Double desviacionEstandar;
	public Double getPromedioEdad() {
		return promedioEdad;
	}
	public void setPromedioEdad(Double promedioEdad) {
		this.promedioEdad = promedioEdad;
	}
	public Double getDesviacionEstandar() {
		return desviacionEstandar;
	}
	public void setDesviacionEstandar(Double desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}
	public KpiClienteDto(Double promedioEdad, Double desviacionEstandar) {
		super();
		this.promedioEdad = promedioEdad;
		this.desviacionEstandar = desviacionEstandar;
	}
	
	public KpiClienteDto() {
	}
}
