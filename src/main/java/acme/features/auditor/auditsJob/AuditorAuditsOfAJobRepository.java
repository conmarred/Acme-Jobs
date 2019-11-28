
package acme.features.auditor.auditsJob;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditsOfAJobRepository extends AbstractRepository {

	@Query("select j.audits from Job j where (select a.id from AuditRecord a where a.job.id = j.id) = ?1")
	Collection<AuditRecord> findAuditsOfAJob(int id);

	@Query("select a from AuditRecord a where a.id = ?1")
	AuditRecord findOne(int id);

}
