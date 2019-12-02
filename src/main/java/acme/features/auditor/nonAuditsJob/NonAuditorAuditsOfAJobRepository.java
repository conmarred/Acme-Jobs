
package acme.features.auditor.nonAuditsJob;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface NonAuditorAuditsOfAJobRepository extends AbstractRepository {

	@Query("select a from AuditRecord a where a.job.id != ?1")
	Collection<AuditRecord> findNonAuditsOfAJob(int id);

	@Query("select a from AuditRecord a where a.id = ?1")
	AuditRecord findOne(int id);

}
