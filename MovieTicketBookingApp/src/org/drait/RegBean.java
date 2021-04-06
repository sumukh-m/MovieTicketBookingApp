package org.drait;

import java.io.Serializable;

public class RegBean implements Comparable<RegBean>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname, lname, email, pass, rpwd, address, phone_no;
	
	public RegBean() {
		
		// TODO Auto-generated constructor stub
	}

	
	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getRpwd() {
		return rpwd;
	}


	public void setRpwd(String rpwd) {
		this.rpwd = rpwd;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((phone_no == null) ? 0 : phone_no.hashCode());
		result = prime * result + ((rpwd == null) ? 0 : rpwd.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegBean other = (RegBean) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (phone_no == null) {
			if (other.phone_no != null)
				return false;
		} else if (!phone_no.equals(other.phone_no))
			return false;
		if (rpwd == null) {
			if (other.rpwd != null)
				return false;
		} else if (!rpwd.equals(other.rpwd))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "RegBean [fname=" + fname + ", lname=" + lname + ", email=" + email + ", pass=" + pass + ", rpwd=" + rpwd
				+ ", address=" + address + ", phone_no=" + phone_no + "]";
	}
	public int compareTo(RegBean bean) {
		return fname.compareTo(bean.getFname());
	}
	
	public String validate()
	{
		StringBuilder sb = new StringBuilder("");
		MVCDAO dao = DAOFactory.getDAO(Constants.DAO);
		
		if ( dao.checkEmailExists(email) )
			sb.append("Email is already register, Please enter a new Email ! ");
		if (  !pass.equals(rpwd) ) 
			sb.append( "Re-Entered Password must be same as the given Password!!" );
		
		String msg = sb.toString();
		if ( msg.equals("") )
			return Constants.SUCCESS;
		else
			return msg;
	}
}
