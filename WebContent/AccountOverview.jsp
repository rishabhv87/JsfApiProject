<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ui="http://java.sun.com/jsf/facelets" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Liquidity Overview</title>
<link rel="stylesheet" type="text/css" href="dnbAPI.css" />
</head>
<body bgcolor="#D3ECFF">

<div id= "header">
<h1>Liquidity Overview</h1>
</div>

<f:view> 

<div align="right"><h4>
<h:form>
<h:commandLink value="HOME" action="goToHome"/></h:form>
</h4></div>

 <h3>
<div align="right">
<h:outputLabel tabindex="4" value=" Welcome #{customer.firstName}  #{customer.lastName}"/> <br/>
</div></h3>

<div align="right"><h4>
<h:outputLabel value = "Total Liquidity :"/>
<h:outputText value = "#{accountOverview.totalLiquidity} NOK"/>
</h4></div>



<h:form>

 
 <h:dataTable  width="800" bodyrows="1" cellspacing="5" cellpadding="20" bgcolor="#D3ECFF" var="acc" value="#{accountOverview.accountList}" border="1">
 <h:column > 
 <f:facet name="header">
            <h:outputText value="Account Number"></h:outputText>
        </f:facet>
 	<h:commandLink  value="#{acc.accountNumber}" action="#{acc.getAccountDetail}">
 	<f:param name="customerID" value="#{customer.customerID}" />
 	<f:param name="accountNumber" value="#{acc.accountNumber}" /> 
 	</h:commandLink>
 </h:column>
 <h:column> 
 <f:facet name="header">
            <h:outputText value="Account Type"></h:outputText>
        </f:facet> 
        <h:outputText value="#{acc.accountType}"/>  
</h:column>  
<h:column>  
<f:facet name="header">
            <h:outputText value="Account Balance"></h:outputText>
        </f:facet>
	<h:outputText value="#{acc.accountBalance}"/>  
</h:column>  

<h:column>  
<f:facet name="header">
            <h:outputText value="Account Currency"></h:outputText>
        </f:facet>
	<h:outputText value="#{acc.currency}"/>  
</h:column>  

<h:column>  
<f:facet name="header">
            <h:outputText value="Nok Equivalent"></h:outputText>
        </f:facet>
	<h:outputText value="#{acc.equivalentNokBalance}"/>  
</h:column>  

<h:column>  
<f:facet name="header">
            <h:outputText value="Bank Name"></h:outputText>
        </f:facet>
	<h:outputText value="#{acc.bankName}"/>  
</h:column>  

</h:dataTable  >


</h:form> 

</f:view> 
</body>
</html>
</jsp:root>