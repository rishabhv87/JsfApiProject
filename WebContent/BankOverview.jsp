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

<h1>Bank Overview</h1>

<H2>Search Bank by Branch Id</H2>

<h:form>
<h:outputText value="Enter Branch Id : "></h:outputText>
<h:inputText label="Branch Id" value="#{branch.branchID}"></h:inputText><br/>
<h:commandButton value="Submit" action="#{branch.getBranchDetails}" ></h:commandButton>
</h:form>
<br/>

<H2>Search Bank by Zip Code</H2>

<h:form>
<h3>
<div align="right">
<h:outputLabel tabindex="4" value=" Welcome #{customer.firstName}  #{customer.lastName}"/> <br/>
</div>
</h3>

<h:outputText value="Enter Zip Code : "></h:outputText>
<h:inputText label="Zip Code" value="#{branch.zipCode}"></h:inputText><br/>
<h:commandButton value="Submit" action="#{branch.getBranchDetails}" ></h:commandButton>
</h:form>
<br/>



</f:view>
</body>
</html>
</jsp:root>