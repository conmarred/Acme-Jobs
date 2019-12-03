
package acme.features.auditor.auditsJob;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.auditRecords.AuditRecordStatus;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditsOfAJobRepository extends AbstractRepository {

	@Query("select a from AuditRecord a where a.job.id = ?1 and ((a.status = ?2 and a.auditor.id = ?2) or a.status= ?3")
	Collection<AuditRecord> findAuditsOfAJob(int id, AuditRecordStatus ad, AuditRecordStatus ad1);

	@Query("select a from AuditRecord a where a.id = ?1")
	AuditRecord findOne(int id);

	//	@Query("select a from AuditRecord a where a.job.id = ?1 and ((a.status = 1 and a.auditor.id = ?2") or a.status= 0))

}
