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
<title>Customer Login</title>
<link rel="stylesheet" type="text/css" href="dnbAPI.css" />
</head>
<body>
<div id="header"><h1>Automated Cash Manager</h1></div>
<f:view>
<div align="center" >
<h:form>
<br/><br/>
<h:panelGrid columns="2">
UserId : <h:inputText required="true" requiredMessage="Mandatory field" label="customerID" value="#{user.userId}"/>
Password   : <h:inputSecret label="password" value="#{login.password}"/>
</h:panelGrid>
<h:commandButton value="Submit" action="#{user.getCustomerDetails}"/>
</h:form>
</div>
</f:view>
</body>
</html>
</jsp:root>