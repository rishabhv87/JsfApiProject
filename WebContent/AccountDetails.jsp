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
<title>Insert title here</title>
</head>
<body bgcolor="#D3ECFF">
<f:view >

 <h3>
<div align="right">
<h:outputLabel tabindex="4" value=" Welcome #{customer.firstName}  #{customer.lastName}"/> <br/>
</div>
</h3>
<H4 align="center">
<h:form>
<h:panelGrid columns="2" border="1" width="600">
<h:outputLabel value="Customer Id : " />
<h:outputText value="#{customer.customerID}"/>
<h:outputLabel value="Customer Name : " />
<h:outputText value="#{account.accountNumber}"/>
<h:outputLabel value="IBAN : " />
<h:outputText value="#{account.iban}"/>
<h:outputLabel value="Account Status : " />
<h:outputText value="#{account.accountStatus}"/>
<h:outputLabel value="Account Balance : " />
<h:outputText value="#{account.accountBalance}"/>
<h:outputLabel value="Book Balance : " />
<h:outputText value="#{account.bookBalance}"/>
<h:outputLabel value="Created : " />
<h:outputText value="#{account.created}"/>
<h:outputLabel value="Currency : " />
<h:outputText value="#{account.currency}"/>
</h:panelGrid>          
</h:form>
</H4>
</f:view>
</body>
</html>
</jsp:root>