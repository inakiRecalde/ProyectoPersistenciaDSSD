package ttps.spring.model;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MATERIALES")
public class Material {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="CANTIDAD")
    private int cantidad;
    
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="plan_id")
    private Plan plan;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="proovedor_id")
    private Proveedor proveedor;
    
	@OneToOne(optional = true , cascade = CascadeType.REMOVE)
    private Plazo plazo;
	
    public Material() {
        super();
    }

    
    public Material(String nombre,int cantidad, Proveedor proveedor, Plazo plazo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.plazo = plazo;
    }
    
	public Plazo getPlazo() {
		return plazo;
	}


	public void setPlazo(Plazo plazo) {
		this.plazo = plazo;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Proveedor getProveedor() {
        return proveedor;
    }


    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
