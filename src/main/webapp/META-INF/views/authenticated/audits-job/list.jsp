
<%--
- list.jsp
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

<acme:list readonly="false">
<acme:list-column code="authenticated.audits-of-a-job.list.label.moment" path="moment" width="20%"/>
	<acme:list-column code="authenticated.audits-of-a-job.list.label.title" path="title" width="20%"/>
	<acme:list-column code="authenticated.audits-of-a-job.list.label.job-title" path="job.title" width="20%"/>
	<acme:list-column code="authenticated.audits-of-a-job.list.label.workerUsername" path="workerUsername" width="20%"/>
</acme:list>

<acme:form-return code="authenticated.audits-of-a-job.list.button.return"/>




