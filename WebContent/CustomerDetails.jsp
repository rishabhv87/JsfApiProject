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
<title>Customer details</title>
</head>
<body  bgcolor="#D3ECFF">
<f:view>
<h3>
<div align="right">
<h:outputLabel tabindex="4" value=" Welcome #{customer.firstName}  #{customer.lastName}"/> <br/>
</div>
</h3>

<h1><u>Customer details</u></h1>
<H4>
<h:panelGrid columns="2" border="1" width="600" bgcolor="#D3ECFF">
<h:outputLabel value="Customer Name : " />
<h:outputText value="#{customer.firstName} #{customer.lastName}" />
<h:outputLabel value="Personal Number :" />
<h:outputText value="#{customer.personalNumber}" />
<h:outputLabel value="Gender :" />
<h:outputText value="#{customer.gender}" />
<h:outputLabel value="Date of birth : " />
<h:outputText value="#{customer.dateOfBirth}" />
<h:outputLabel value="Nationality : " />
<h:outputText value="#{customer.nationality}" />
<h:outputLabel value="Email : " />
<h:outputText value="#{customer.email}" />
<h:outputLabel value="Phone Number : " />
<h:outputText value="#{customer.phoneNumber}" />
<h:outputLabel value="idType : " />
<h:outputText value="#{customer.idType}" />
<h:outputLabel value="Id Number : "/>
<h:outputText value="#{customer.idnumber}" />
<h:outputLabel value="Street : " />
<h:outputText value="#{customer.address.street}" />
<h:outputLabel value="City : " />
<h:outputText value="#{customer.address.city}" />
<h:outputLabel value="Postal code : " />
<h:outputText value="#{customer.address.postalcode}" />
<h:outputLabel value="Country : " />
<h:outputText value="#{customer.address.country}" />
</h:panelGrid>
</H4>


</f:view>
</body>
</html>
</jsp:root>