<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp" %>

<%
String balance = ParamUtil.getString(request, "balance");
%>

<h1><%=balance %></h1>

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="mvcPath" value="/view.jsp"/>
</liferay-portlet:renderURL>

<aui:a  href="<%=backURL %>" cssClass="btn btn-primary" value="Retour au formulaire"/>


