
package acme.features.authenticated.jobs;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.status = 'PUBLISHED' and now()<j.deadline")
	Collection<Job> findActiveJobs();

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);
}
