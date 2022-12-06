package ttps.spring.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COLECCIONES")
public class Coleccion {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="CARACTERISTICAS")
	private String caracteristicas;
    
    @ManyToMany
	private List<Modelo> modelos;
	
    @Column(name="FECHAINICIO")
    private String fechaInicio;
    
    @Column(name="FECHAFIN")
    private String fechaFin;
    
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="usuario_id")
    private Usuario usuario;

	
	//private List<Image> imagenesLentes;
	

    @Column(name="DESCRIPCIONLENTES")
	private String descripcionLentes;
	

	
	public Coleccion(String caracteristicas, List<Modelo> modelos, String fechaInicio, String fechaFin,
            String descripcionLentes, Usuario usuario) {
        super();
        this.caracteristicas = caracteristicas;
        this.modelos = modelos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcionLentes = descripcionLentes;
        this.usuario = usuario;
    }
	
	public Coleccion (String caracteristicas, String fechaInicio, String fechaFin,
            String descripcionLentes) {
        super();
        this.caracteristicas = caracteristicas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcionLentes = descripcionLentes;
    }

    public Coleccion() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}


	public String getDescripcionLentes() {
		return descripcionLentes;
	}
	public void setDescripcionLentes(String descripcionLentes) {
		this.descripcionLentes = descripcionLentes;
	}
    public List<Modelo> getModelos() {
        return modelos;
    }
    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
	
}
