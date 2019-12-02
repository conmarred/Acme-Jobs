
package acme.features.auditor.nonAuditsJob;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.auditRecords.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/auditor/non-audit-record/")
public class NonAuditorAuditsOfAJobController extends AbstractController<Auditor, AuditRecord> {

	@Autowired
	NonAuditorAuditsOfAJobListService	listService;

	@Autowired
	NonAuditorAuditsOfAJobShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_NON_AUDITS_JOB, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
