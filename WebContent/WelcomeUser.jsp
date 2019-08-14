<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" version="2.0">
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
<title>Welcome Customer</title>
<link rel="stylesheet" type="text/css" href="dnbAPI.css" />
</head>
<body bgcolor="#D3ECFF" >
<f:view >

<div id="header" ><h1>HOME</h1>
<div id="loggedUser" align="right">
<h:form>
<h:commandLink  value="USER PROFILE" action="#{customer.updateCustomer}" >  
<f:param name="customerID" value="#{customer.customerID}" />
</h:commandLink></h:form><br/>
<h:outputText value="#{customer.firstName}  #{customer.lastName}"/>
</div></div>

<div id="main" align="center">
<h4>
<h:form>
<h:panelGrid  columns="1" border="0">


<h:commandLink  value="LIQUIDITY" action="#{accountOverview.getAccountListed}" >  
<f:param name="customerID" value="#{customer.customerID}" />
</h:commandLink><br/>

<h:commandLink  value="PAYMENT INITIATION" action="successPaymentWithoutKid" >  
</h:commandLink><br/>

<h:commandLink  value="TRANSACTION OVERVIEW" action="#{paymentOverview.getAllAccountTxnStatement}" >  
</h:commandLink><br/>

<!--<h:commandLink  value="PAYMENT SEARCH" action="successPaymentSearch" >   
</h:commandLink><br/>

<h:commandLink  value="BANKS" action="bankSuccess" >
</h:commandLink><br/>

<h:commandLink  value="CURRENCY XCHANGE" action="CurrencyOverviewSuccess" > 
</h:commandLink><br/> -->
</h:panelGrid>
</h:form> 
</h4>
</div>


</f:view>
<DIV id="footer">
Copyright TEAM_K TCS
</DIV>

</body>
</html>
</jsp:root>