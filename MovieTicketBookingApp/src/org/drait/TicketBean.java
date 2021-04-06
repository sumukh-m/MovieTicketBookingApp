package org.drait;

import java.io.Serializable;

public class TicketBean implements Comparable<TicketBean>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String no_of_tickets, date, start_time, t_name, location, seat_no, seat_row, mov_name, ticket_id;
	
	

	public TicketBean() {
		// TODO Auto-generated constructor stub
	}



	
	public String getNo_of_tickets() {
		return no_of_tickets;
	}




	public void setNo_of_tickets(String no_of_tickets) {
		this.no_of_tickets = no_of_tickets;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public String getStart_time() {
		return start_time;
	}




	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}




	public String getT_name() {
		return t_name;
	}




	public void setT_name(String t_name) {
		this.t_name = t_name;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getSeat_no() {
		return seat_no;
	}




	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}




	public String getSeat_row() {
		return seat_row;
	}




	public void setSeat_row(String seat_row) {
		this.seat_row = seat_row;
	}




	public String getMov_name() {
		return mov_name;
	}




	public void setMov_name(String mov_name) {
		this.mov_name = mov_name;
	}




	public String getTicket_id() {
		return ticket_id;
	}




	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((mov_name == null) ? 0 : mov_name.hashCode());
		result = prime * result + ((no_of_tickets == null) ? 0 : no_of_tickets.hashCode());
		result = prime * result + ((seat_no == null) ? 0 : seat_no.hashCode());
		result = prime * result + ((seat_row == null) ? 0 : seat_row.hashCode());
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
		result = prime * result + ((t_name == null) ? 0 : t_name.hashCode());
		result = prime * result + ((ticket_id == null) ? 0 : ticket_id.hashCode());
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
		TicketBean other = (TicketBean) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (mov_name == null) {
			if (other.mov_name != null)
				return false;
		} else if (!mov_name.equals(other.mov_name))
			return false;
		if (no_of_tickets == null) {
			if (other.no_of_tickets != null)
				return false;
		} else if (!no_of_tickets.equals(other.no_of_tickets))
			return false;
		if (seat_no == null) {
			if (other.seat_no != null)
				return false;
		} else if (!seat_no.equals(other.seat_no))
			return false;
		if (seat_row == null) {
			if (other.seat_row != null)
				return false;
		} else if (!seat_row.equals(other.seat_row))
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
			return false;
		if (t_name == null) {
			if (other.t_name != null)
				return false;
		} else if (!t_name.equals(other.t_name))
			return false;
		if (ticket_id == null) {
			if (other.ticket_id != null)
				return false;
		} else if (!ticket_id.equals(other.ticket_id))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "TicketBean [no_of_tickets=" + no_of_tickets + ", date=" + date + ", start_time=" + start_time
				+ ", t_name=" + t_name + ", location=" + location + ", seat_no=" + seat_no + ", seat_row=" + seat_row
				+ ", mov_name=" + mov_name + ", ticket_id=" + ticket_id + "]";
	}




	public int compareTo(TicketBean bean) {
		return this.date.compareTo(bean.getDate());
	}
}
