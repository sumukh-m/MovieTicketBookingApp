<jsp:useBean id = "ticket" class = "org.drait.TicketBean" scope = "request">
	<jsp:setProperty name = "ticket" property = "*" />
</jsp:useBean>

<jsp:forward page = "bookingConfirm.do" />