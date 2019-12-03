<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.job.form.label.title" path="title"/>
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.status" path="status"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-url code="employer.job.form.label.link" path="link"/>
	<acme:form-panel code="employer.job.form.panel.descriptor">
		<acme:form-textbox code="employer.job.form.panel.descriptor.description" path="descriptor.description"/>
		<jstl:forEach var="duty" items="${duties}">
			<acme:form-panel code="employer.job.form.panel.descriptor.duties">
				<acme:print value="${duty.title}"/> <br/>
				<acme:print value="${duty.description}"/><br/>
				<acme:print value="${duty.time}"/> % <br/>
				<br/>
			</acme:form-panel>
		</jstl:forEach>
	</acme:form-panel>
	
	<acme:form-submit code="employer.audits-record.form.button.list-audits-job" action="/employer/audit-record/list-audits-job?id=${id}" method="get"/>
  	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>
