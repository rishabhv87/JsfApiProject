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
<title>Transaction Overview</title>
<link rel="stylesheet" type="text/css" href="dnbAPI.css" />
</head>
<body  bgcolor="#D3ECFF">
<div id="header">
<h1>Transaction Overview</h1>
</div>



<f:view>

<h3 align="right"> 
<h:form>
<h:commandLink value="HOME" action="goToHome"></h:commandLink>
</h:form>
</h3>

<h:dataTable  width="800" bodyrows="1" cellspacing="5" cellpadding="20" bgcolor="#D3ECFF" var="txn" value="#{paymentOverview.keyList}" border="10">

<h:column >  
<f:facet name="header">
            <h:outputText value="TransactionId"></h:outputText>
        </f:facet>
 	<h:outputText  value="#{txn.transactionID}" />
 </h:column>
<h:column >  
<f:facet name="header">
            <h:outputText value="Account Nubmer"></h:outputText>
        </f:facet>
 	<h:outputText  value="#{txn.accountNumber}" />
 </h:column>
 
  <h:column >  
 <f:facet name="header">
            <h:outputText value="D/C Account number"></h:outputText>
        </f:facet>
 	<h:outputText  value="#{txn.transactionAccountNumber}" />
 </h:column>
  <h:column >  
 <f:facet name="header">
            <h:outputText value="Amount"></h:outputText>
        </f:facet>
 	<h:outputText  value="#{txn.amount}" />
 </h:column>
 
  <h:column >  
 <f:facet name="header">
            <h:outputText value="Debit/Credit"></h:outputText>
        </f:facet>
 	<h:outputText  value="#{txn.debitOrCredit}" />
 </h:column>
 
 <h:column > 
 
 
 <f:facet name="header">
            <h:outputText value="Date"></h:outputText>
        </f:facet>
 	<h:outputText  value="#{txn.date}" />
 </h:column>

 <h:column>
 <f:facet name="header">
            <h:outputText value="Message"></h:outputText>
        </f:facet>
 	<h:outputText  value="#{txn.msgOrKid}" />
 </h:column>
 


 

</h:dataTable>

</f:view>
</body>
</html>
</jsp:root>