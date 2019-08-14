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
<f:view>
<h3>
<div align="right">
<h:outputLabel tabindex="4" value=" Welcome #{customer.firstName}  #{customer.lastName}"/> <br/>
</div>
</h3>

<h1><u>Payment details</u></h1>
<H4>
<h:panelGrid columns="2" border="1" width="600" bgcolor="#D3ECFF">
<h:outputLabel value="Payment Id : " />
<h:outputText value="#{payment.paymentIDNumber}" />
<h:outputLabel value="Debit Account Currency :" />
<h:outputText value="#{payment.debitAccountNumber}" />
<h:outputLabel value="Credit Account currency :" />
<h:outputText value="#{payment.creditAccountNumber}" />
<h:outputLabel value="Payment Date : " />
<h:outputText value="#{payment.paymentDate}" />
<h:outputLabel value="Amount : " />
<h:outputText value="#{payment.amount}" />
<h:outputLabel value="Message : " />
<h:outputText value="#{payment.message}" />
</h:panelGrid>
</H4>


</f:view>
</body>
</html>
</jsp:root>