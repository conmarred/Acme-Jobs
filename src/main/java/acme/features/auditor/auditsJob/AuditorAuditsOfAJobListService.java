
package acme.features.auditor.auditsJob;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.auditRecords.AuditRecordStatus;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class AuditorAuditsOfAJobListService implements AbstractListService<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditsOfAJobRepository repository;


	@Override
	public boolean authorise(final Request<AuditRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<AuditRecord> request, final AuditRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment");

	}

	@Override
	public Collection<AuditRecord> findMany(final Request<AuditRecord> request) {
		assert request != null;

		List<AuditRecord> res = new ArrayList<AuditRecord>();

		res.addAll(this.repository.findAuditsOfAJob(Integer.parseInt(request.getServletRequest().getParameter("id")), AuditRecordStatus.PUBLISHED));
		res.addAll(this.repository.findMyAuditOfAJob(Integer.parseInt(request.getServletRequest().getParameter("id")), AuditRecordStatus.DRAFT, request.getPrincipal().getActiveRoleId()));

		return res;
	}

}
