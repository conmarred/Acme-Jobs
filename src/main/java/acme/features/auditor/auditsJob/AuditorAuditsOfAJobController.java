
package acme.features.auditor.auditsJob;

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
@RequestMapping("/auditor/audit-record/")
public class AuditorAuditsOfAJobController extends AbstractController<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditsOfAJobListService	listService;

	@Autowired
	AuditorAuditsOfAJobShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_AUDITS_JOB, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
