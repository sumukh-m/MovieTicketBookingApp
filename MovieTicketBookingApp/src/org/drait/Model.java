package org.drait;

import java.util.List;

public class Model {
	
	public String register(RegBean bean)
	{
		String msg = bean.validate();
		if ( msg.equals(Constants.SUCCESS)) {
			MVCDAO dao = DAOFactory.getDAO(Constants.DAO);
			String res = dao.save(bean);
			if(res.equals(Constants.SUCCESS))
				return Constants.SUCCESS;
			else
				return res;
		}
		else
			return msg;
		
	}
	
	public String authenticate(LoginBean bean)
	{
			MVCDAO dao = DAOFactory.getDAO(Constants.DAO);
			boolean res = dao.checkUser(bean);
			if(res)
				return Constants.SUCCESS;
			else
				return "Email and Password combination is invalid!Try again!!";
	}
	
	public String bookTicket(TicketBean bean, String email)
	{
			MVCDAO dao = DAOFactory.getDAO(Constants.DAO);
			String res = dao.save(bean, email);
			if(res.equals(Constants.SUCCESS))
				return Constants.SUCCESS;
			else
				return res;
	}
	
	public List<RegBean> getUsersInfo() {
		
		MVCDAO dao = DAOFactory.getDAO(Constants.DAO);
		
		return dao.getRegUsers();
	}
}
