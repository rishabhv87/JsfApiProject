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
<body bgcolor="#D3ECFF" >
<f:view>
<h3>
<div align="right">
<h:outputLabel tabindex="4" value=" Welcome #{customer.firstName}  #{customer.lastName}"/> <br/>
</div>
</h3>

<h2><u>BRANCH DETAILS</u></h2>
<H4>
<br/>
<br/>
<div align="center">
<h:panelGrid columns="2" border="1" width="600" bgcolor="#D3ECFF">
<h:outputLabel value="Branch ID : " />
<h:outputText value="#{branch.branchID}" />
<h:outputLabel value="Branch Name :" />
<h:outputText value="#{branch.branchName}" />
<h:outputLabel value="Phone Number :" />
<h:outputText value="#{branch.phoneNumber}" />
<h:outputLabel value="Lattitude : " />
<h:outputText value="#{branch.location.latitude}" />
<h:outputLabel value="Longitude : " />
<h:outputText value="#{branch.location.longitude}" />
<h:outputLabel value="Street : " />
<h:outputText value="#{branch.branchAddress.street}" />
<h:outputLabel value="City : " />
<h:outputText value="#{branch.branchAddress.city}" />
<h:outputLabel value="Postal Code : " />
<h:outputText value="#{branch.branchAddress.postalcode}" />
<h:outputLabel value="Country : "/>
<h:outputText value="#{branch.branchAddress.country}" />
</h:panelGrid>
</div>
</H4>
</f:view>
</body>
</html>
</jsp:root>