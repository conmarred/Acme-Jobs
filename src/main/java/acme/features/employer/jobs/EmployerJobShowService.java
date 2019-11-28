
package acme.features.employer.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerJobShowService implements AbstractShowService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("duties", entity.getDescriptor().getDuties());

		request.unbind(entity, model, "reference", "status", "title", "deadline", "salary", "link", "descriptor.description");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job res = this.repository.findOne(request.getModel().getInteger("id"));
		res.getEmployer().getUserAccount().getRoles().size();
		res.getDescriptor().getDuties().size();

		return res;
	}

}