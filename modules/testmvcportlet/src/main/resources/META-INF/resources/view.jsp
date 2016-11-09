<%@ include file="./init.jsp" %>

<h1>Titre 1</h1>

<p>
	<b><liferay-ui:message key="testmvcportlet_Testmvcportletmvcportlet.caption"/></b>
</p>

<aui:form>

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>">
			<aui:input name="birthDate" type="date"/>
			<aui:input name="color" type="color"/>
			<aui:input name="comments" type="editor"/>
			<aui:input name="range" type="range" min="10" max="100"/>
			<aui:input name="lastName" placeholder="Your last name"/>
			<aui:input name="firstName" placeholder="your first name"/>
			
			<aui:button-row>
        		<aui:button type="submit" />
			</aui:button-row>
		
		</aui:fieldset>
		
		
			
	</aui:fieldset-group>

	
	
</aui:form>