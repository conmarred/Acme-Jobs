
package acme.features.authenticated.messageThreads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThreads.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("usersAccount", entity.getUsers());

		request.unbind(entity, model, "title", "moment", "id");

	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		assert request != null;

		MessageThread res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.repository.findOneMessageThreadById(id);
		res.getUsers().size();
		res.getUsers().forEach(x -> x.getRoles().size());

		return res;
	}

}
