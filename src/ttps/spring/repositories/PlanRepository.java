package ttps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.spring.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long>{

}
