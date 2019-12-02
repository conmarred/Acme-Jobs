
package acme.features.auditor.nonAuditsJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class NonAuditorAuditsOfAJobShowService implements AbstractShowService<Auditor, AuditRecord> {

	@Autowired
	NonAuditorAuditsOfAJobRepository repository;


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

		request.unbind(entity, model, "title", "status", "moment", "body");

	}

	@Override
	public AuditRecord findOne(final Request<AuditRecord> request) {
		assert request != null;

		AuditRecord res = this.repository.findOne(request.getModel().getInteger("id"));

		return res;
	}

}
