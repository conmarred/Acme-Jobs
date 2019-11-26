
package acme.features.employer.applications;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.job.employer.id = ?1")
	Collection<Application> findApplicacionAtMyJobs(int id);

	@Query("select a from Application a where a.id = ?1")
	Application findOne(int id);

}
