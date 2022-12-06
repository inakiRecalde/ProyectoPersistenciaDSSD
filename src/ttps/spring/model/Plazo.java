package ttps.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLAZOS")
public class Plazo {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	



	@Column(name="FECHAINICIO")
	private Date fechaInicio;
	
	@Column(name="FECHAFIN")
	private Date fechaFin;
	
	


	public Plazo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plazo(Date fechaInicio, Date fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	
	
}
