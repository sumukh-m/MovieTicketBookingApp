
<jsp:useBean id = "reg" class = "org.drait.RegBean" scope = "request">
	<jsp:setProperty name = "reg" property = "*" />
</jsp:useBean>

<jsp:forward page = "register.do" />