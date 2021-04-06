package org.drait;

import java.util.List;

public interface MVCDAO {

	public String save(RegBean bean);
	public String save(TicketBean bean, String email);
	public boolean checkEmailExists(String email); 
	public boolean checkUser(LoginBean bean);
	public List<RegBean> getRegUsers();
}
