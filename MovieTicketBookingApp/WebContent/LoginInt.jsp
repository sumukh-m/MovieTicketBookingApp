<jsp:useBean id = "login" class = "org.drait.LoginBean" scope = "request">
	<jsp:setProperty name = "login" property = "*" />
</jsp:useBean>

<jsp:forward page = "login.do" />