
package acme.features.employer.jobs;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.employer.id = ?1")
	Collection<Job> findMany(int id);

	@Query("select j from Job j where j.id = ?1")
	Job findOne(int id);

}
