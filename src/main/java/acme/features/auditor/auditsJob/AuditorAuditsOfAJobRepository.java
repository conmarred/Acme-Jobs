
package acme.features.auditor.auditsJob;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.auditRecords.AuditRecordStatus;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditsOfAJobRepository extends AbstractRepository {

	@Query("select a from AuditRecord a where a.job.id = ?1 and a.status = ?2")
	Collection<AuditRecord> findAuditsOfAJob(int id, AuditRecordStatus ad);

	@Query("select a from AuditRecord a where a.job.id = ?1 and a.status = ?2 and a.auditor.id = ?3")
	Collection<AuditRecord> findMyAuditOfAJob(int id, AuditRecordStatus ad, int idA);

	@Query("select a from AuditRecord a where a.id = ?1")
	AuditRecord findOne(int id);

}
