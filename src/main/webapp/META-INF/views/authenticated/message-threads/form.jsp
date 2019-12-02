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
	<acme:form-textbox code="authenticated.message-threads.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.message-threads.form.label.moment" path="moment"/>
	<acme:form-panel code="authenticated.message-threads.form.label.users">
		<jstl:forEach var="user" items="${usersAccount}">
			<acme:print value="${user.username}"/> <br/>
		</jstl:forEach>
	</acme:form-panel>
	<br/>
	<acme:form-submit code="authenticated.message-threads.form.button.messages" action="/authenticated/message/list?id=${id}" method="get"/>
  	<acme:form-return code="authenticated.message-threads.form.button.return"/>
</acme:form>
