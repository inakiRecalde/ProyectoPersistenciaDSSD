package ttps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByUsernameAndPassword(String username, String password);
	
}
