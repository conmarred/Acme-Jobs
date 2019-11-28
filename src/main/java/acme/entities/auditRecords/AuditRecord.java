
package acme.entities.auditRecords;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@NonNull
	private AuditStatus			status;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@NotBlank
	private String				body;

	// Relationships ----------------------------------------------------------

	@NonNull
	@Valid
	@ManyToOne(optional = false)
	private Job					job;

	@NonNull
	@Valid
	@ManyToOne(optional = false)
	private Auditor				auditor;

}
