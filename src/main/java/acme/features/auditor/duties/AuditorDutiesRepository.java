
package acme.features.auditor.duties;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.duties.Duty;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorDutiesRepository extends AbstractRepository {

	@Query("select d from Duty d where d.descriptor.id = (select j.descriptor.id from Job j where j.id = ?1)")
	Collection<Duty> findMany(int id);

	@Query("select d from Duty d where d.id = ?1")
	Duty findOne(int id);
}
