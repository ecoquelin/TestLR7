<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp" %>

<%
String balance = ParamUtil.getString(request, "balance");
String userName = "MEHDI01";
String password= "pass@123";
String companyStr = "MA0011001";
String transactionId= "136212745";
%>

<canvas id="myChart" width="400" height="400"></canvas>

<aui:script require="js-logger/logger.es" >

var Logger = jsLoggerLoggerEs.default;
var loggerOne = new Logger('*** >>>>>> ');
loggerOne.log('Hello Eric');
loggerOne.draw("myChart");

</aui:script>

<h1>Consultation de balance: <%=balance %></h1>

<liferay-portlet:actionURL name="checkAccountBalance" var="checkAccountBalanceURL">
	<liferay-portlet:param name="mvcPath" value="/balance.jsp"/>
</liferay-portlet:actionURL>

<aui:form action="<%=checkAccountBalanceURL %>">
	<aui:input name="userName" label="user-name2" value="<%=userName %>"></aui:input>
	<aui:input name="password" label="password" value="<%=password %>"></aui:input>
	<aui:input name="company" label="company" value="<%=companyStr %>"></aui:input>
	<aui:input name="transactionId" label="transaction-id" value="<%=transactionId %>"></aui:input>
	<aui:button-row>
		<aui:button type="submit" value="check-my-balance"> </aui:button>
	</aui:button-row>
</aui:form>


