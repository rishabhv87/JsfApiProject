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
<title>Payment without KID</title>
</head>
<body  bgcolor="#D3ECFF">
<f:view>
<h3 align="right">
<h:form>
<h:commandLink value="HOME" action="goToHome"></h:commandLink> 
</h:form>

<div align="right">
<h:outputLabel tabindex="4" value=" Welcome #{customer.firstName}  #{customer.lastName}"/> <br/>
</div>
</h3>
<BR /><BR/>
<h3><u>Please enter your Payment details</u></h3>


<h:form>
<h4 align="center">
<h:panelGrid columns="2" border="1">
<h:outputText value="Debit Acount Number"/>
<h:inputText label="Debit Acount Number" value="#{payment.debitAccountNumber}"></h:inputText>
<h:outputText value="Credit Acount Number"/>
<h:inputText label="Credit Acount Number" value="#{payment.creditAccountNumber}"></h:inputText>
<h:outputText value="Message"/>
<h:inputText label="Message" value="#{payment.message}"></h:inputText>
<h:outputText value="Transfer Amount"/>
<h:inputText label="Amount" value="#{payment.amount}"></h:inputText>
<h:outputText value="Payment Date"/>
<h:inputText label="payment date" value="#{payment.paymentDate}"></h:inputText><br/>
<h:commandButton value="Confirm Payment" action="#{payment.processPayment}"></h:commandButton>
</h:panelGrid>
</h4>
</h:form>

</f:view>
</body>
</html>
</jsp:root>