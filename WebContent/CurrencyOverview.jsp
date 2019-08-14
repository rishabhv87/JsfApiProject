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

<h1>Currency Overview</h1>
<br/>

<H3><u>Get Exchange Rates by base currency</u></H3>
<h:form>
<h4 align="center">
<h:panelGrid columns="2" border="1" width="600" bgcolor="#D3ECFF">
<h:outputText value="Enter base currency : "></h:outputText>
<h:inputText label="Base currency" value="#{currencyXchange.baseCurrency}"></h:inputText>
<h:outputText value="Date : "></h:outputText>
<h:inputText label="Date" value="#{currencyXchange.date}"></h:inputText><br/>
<h:commandButton value="Submit" action="#{currencyXchange.getExchangeRatesList}" ></h:commandButton>
</h:panelGrid></h4>
</h:form>

</f:view>
</body>
</html>
</jsp:root>