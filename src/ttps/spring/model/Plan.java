package ttps.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PLANES")
public class Plan {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="plan", cascade = CascadeType.REMOVE)
    private List<Material> materiales;
    
    @Column(name="RUTAS")
    private String rutas;
    
    @Column(name="LANZADO")
    private Boolean lanzado;
    
    @Column(name="NEGOCIADO")
    private Boolean renegociado;
    
    @OneToOne
    private Coleccion coleccion;
    
    public Plan() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Plan(List<Material> materiales, String rutas, Boolean lanzado,
            Boolean renegociado) {
        super();
        this.materiales = materiales;
        this.rutas = rutas;
        this.lanzado = lanzado;
        this.renegociado = renegociado;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public String getRutas() {
        return rutas;
    }

    public void setRutas(String rutas) {
        this.rutas = rutas;
    }


    public Boolean getLanzado() {
        return lanzado;
    }

    public void setLanzado(Boolean lanzado) {
        this.lanzado = lanzado;
    }

    public Boolean getRenegociado() {
        return renegociado;
    }

    public void setRenegociado(Boolean renegociado) {
        this.renegociado = renegociado;
    }
    
}
