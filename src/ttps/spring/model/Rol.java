package ttps.spring.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ROLES")
public class Rol {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="ROL")
	private String rol;
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public Rol() {	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Rol(String unRol) {
		this.rol= unRol;	}
}
