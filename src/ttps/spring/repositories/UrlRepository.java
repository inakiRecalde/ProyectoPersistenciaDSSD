package ttps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.spring.model.Url;

public interface UrlRepository extends JpaRepository<Url, Long>{

}
