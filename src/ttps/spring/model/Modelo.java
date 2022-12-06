package ttps.spring.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MODELOS")
public class Modelo {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="NOMBRE")
    String nombre; 
    
    
    @OneToMany(mappedBy = "modelo",cascade = CascadeType.REMOVE)
    List<Tipo> tipo;
      
    @ManyToMany
    List<Material> materiales;

    public Long getId() {
        return id;
    }
    public Modelo() {
        super();
    }

    public Modelo(Long id, String nombre, List<Tipo> tipo, List<Material> materiales) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.materiales = materiales;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tipo> getTipo() {
        return tipo;
    }

    public void setTipo(List<Tipo> tipo) {
        this.tipo = tipo;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }
}
