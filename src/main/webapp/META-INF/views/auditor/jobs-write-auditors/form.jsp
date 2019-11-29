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
	<acme:form-textbox code="auditor.jobs-write-auditors.form.label.title" path="title"/>
	<acme:form-textbox code="auditor.jobs-write-auditors.form.label.reference" path="reference"/>
	<acme:form-textbox code="auditor.jobs-write-auditors.form.label.status" path="status"/>
	<acme:form-moment code="auditor.jobs-write-auditors.form.label.deadline" path="deadline"/>
	<acme:form-money code="auditor.jobs-write-auditors.form.label.salary" path="salary"/>
	<acme:form-url code="auditor.jobs-write-auditors.form.label.link" path="link"/>
	<acme:form-panel code="auditor.jobs-write-auditors.form.panel.descriptor">
		<acme:form-textbox code="auditor.jobs-write-auditors.form.panel.descriptor.description" path="descriptor.description"/>
		<jstl:forEach var="duty" items="${duties}">
			<acme:form-panel code="auditor.jobs-write-auditors.form.panel.descriptor.duties">
				<acme:print value="${duty.title}"/> <br/>
				<acme:print value="${duty.description}"/><br/>
				<acme:print value="${duty.time}"/> % <br/>
				<br/>
			</acme:form-panel>
		</jstl:forEach>
	</acme:form-panel>
	
	<a href="/acme-jobs/auditor/audit-record/list?id=${id}" type="button"><acme:message code="auditor.jobs-write-auditors.form.button.list-audits"/></a> <br/><br/>
<!--	<acme:form-submit code="auditor.jobs-write-auditors.form.button.list-audits" action="/auditor/audit/list"/> -->
  	<acme:form-return code="auditor.jobs-write-auditors.form.button.return"/>
</acme:form>
