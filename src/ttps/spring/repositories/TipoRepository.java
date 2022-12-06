package ttps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ttps.spring.model.*;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long>{

}
