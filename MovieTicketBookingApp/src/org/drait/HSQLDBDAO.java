package org.drait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HSQLDBDAO implements MVCDAO {
	

	@Override
	public List<RegBean> getRegUsers() {
		
		List<RegBean> users = new ArrayList<RegBean>();
		
		Connection con = null;
		PreparedStatement ps_sel=null;
		ResultSet rs = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				throw new RuntimeException("Connection not established. Contact DBA!");
			else
			{
				ps_sel = con.prepareStatement("select name,email from customer");
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();
				
				while(rs.next())
				{
					RegBean bean = new RegBean();
					//bean.setUname(rs.getString("name"));
					bean.setEmail(rs.getString("email"));
					users.add(bean);
				}
				return users;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}
	}
	
	
	
	@Override
	public boolean checkUser(LoginBean bean) {
		
		Connection con = null;
		PreparedStatement ps_sel=null;
		ResultSet rs = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				throw new RuntimeException("Connection not established. Contact DBA!");
			else
			{
				ps_sel = con.prepareStatement("select email,pass from customer where email = ? and pass = ?");
				ps_sel.setString(1, bean.getEmail());
				ps_sel.setString(2, bean.getPass());
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();
				
				if(rs.next())
					return true;
				else
					return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}

	}
	
	
	
	public String save(RegBean bean) {
		
		Connection con = null;
		PreparedStatement ps_sql,ps_ins=null;
		ResultSet rs = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				throw new RuntimeException("Connection not established. Contact DBA!");
			else
			{	
				
				ps_sql = con.prepareStatement("Select * from customer where email = ? and pass = ?");
				ps_sql.setString(1, bean.getEmail());
				ps_sql.setString(2, bean.getPass());
				ps_sql.execute();
				
				rs = ps_sql.getResultSet();
				if ( rs.next() )
					return "Email is already Registered. Enter new Email!";
				else
				{
					ps_ins = con.prepareStatement("insert into customer(fname, lname, email, pass, address, phone_no) values(?,?,?,?,?,?)");
					ps_ins.setString(1, bean.getFname());
					ps_ins.setString(2, bean.getLname());
					ps_ins.setString(3, bean.getEmail());
					ps_ins.setString(4, bean.getPass());
					ps_ins.setString(5, bean.getAddress());
					ps_ins.setString(6, bean.getPhone_no());
				
					ps_ins.execute();
				
					return Constants.SUCCESS;
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_ins);
			JDBCHelper.close(con);
		}				
		
	}

	public String save(TicketBean bean, String email) {

		Connection con = null;
		PreparedStatement ps_sql = null,ps_ins=null;
		ResultSet rs = null;
		int sl_no;
		int ticket_sl_no;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				throw new RuntimeException("Connection not established. Contact DBA!");
			else
			{	
					ps_sql = con.prepareStatement("select sl_no from customer where email = ?");
					ps_sql.setString(1, email);
					ps_sql.execute();
					rs = ps_sql.getResultSet();
					rs.next();
					sl_no = rs.getInt(1);
					
					ps_ins = con.prepareStatement("insert into ticket(ticket_id, total_amount, no_of_tickets, customer_sl_no) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
					ps_ins.setString(1, bean.getTicket_id());
					int amt = Integer.parseInt(bean.getNo_of_tickets()) * 250;
					ps_ins.setInt(2, amt);
					ps_ins.setString(3, bean.getNo_of_tickets());
					ps_ins.setInt(4, sl_no);
					ps_ins.execute();
					rs = ps_ins.getGeneratedKeys();
					rs.next();
					ticket_sl_no = rs.getInt(1);
					
					ps_ins = con.prepareStatement("insert into theatre(t_name, location, audi_no, ticket_sl_no) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
					ps_ins.setString(1, bean.getT_name());
					ps_ins.setString(2, bean.getLocation());
					ps_ins.setInt(3, (int)(Math.random()*10));
					ps_ins.setInt(4, ticket_sl_no);
					ps_ins.execute();
					rs = ps_ins.getGeneratedKeys();
					rs.next();
					sl_no = rs.getInt(1);
					
					ps_ins = con.prepareStatement("insert into seats(seat_row, seat_no) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
					ps_ins.setString(1, bean.getSeat_row());
					ps_ins.setInt(2, Integer.parseInt( bean.getSeat_no()));
					ps_ins.execute();
					rs = ps_ins.getGeneratedKeys();
					rs.next();
					
					ps_ins = con.prepareStatement("insert into theatre_seats_master(theatre_sl_no, seats_sl_no) values(?,?)", Statement.RETURN_GENERATED_KEYS);
					ps_ins.setInt(1, sl_no);
					ps_ins.setInt(2, rs.getInt(1) );
					ps_ins.execute();
					
					ps_ins = con.prepareStatement("insert into show(start_time, date) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
					ps_ins.setString(1, bean.getStart_time());
					ps_ins.setString(2, bean.getDate());
					ps_ins.execute();
					rs = ps_ins.getGeneratedKeys();
					rs.next();
					sl_no = rs.getInt(1);
					
					ps_ins = con.prepareStatement("insert into movie(mov_name, language, length, rating, show_sl_no) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
					if ( bean.getMov_name().contains("KGF") )
					{
						ps_ins.setString(1, bean.getMov_name());
						ps_ins.setString(2, "Kannada");
						ps_ins.setString(3, "1:55");
						ps_ins.setString(4, "U");
						ps_ins.setInt(5, sl_no);
					}
					if ( bean.getMov_name().contains("Infinity"))
					{
						ps_ins.setString(1, bean.getMov_name());
						ps_ins.setString(2, "English");
						ps_ins.setString(3, "1:35");
						ps_ins.setString(4, "U");
						ps_ins.setInt(5, sl_no);
					}
					if ( bean.getMov_name().contains("Tenet"))
					{
						ps_ins.setString(1, bean.getMov_name());
						ps_ins.setString(2, "English");
						ps_ins.setString(3, "2:15");
						ps_ins.setString(4, "U");
						ps_ins.setInt(5, sl_no);
					}
					if ( bean.getMov_name().contains("JOJO"))
					{
						ps_ins.setString(1, bean.getMov_name());
						ps_ins.setString(2, "English");
						ps_ins.setString(3, "2:25");
						ps_ins.setString(4, "U");
						ps_ins.setInt(5, sl_no);
					}
					if ( bean.getMov_name().contains("Parasite"))
					{
						ps_ins.setString(1, bean.getMov_name());
						ps_ins.setString(2, "Parasite");
						ps_ins.setString(3, "2:00");
						ps_ins.setString(4, "A");
						ps_ins.setInt(5, sl_no);
					}
					if ( bean.getMov_name().contains("3"))
					{
						ps_ins.setString(1, bean.getMov_name());
						ps_ins.setString(2, "English");
						ps_ins.setString(3, "2:25");
						ps_ins.setString(4, "A");
						ps_ins.setInt(5, sl_no);
					}
					if ( bean.getMov_name().contains("Lucia"))
					{
						ps_ins.setString(1, bean.getMov_name());
						ps_ins.setString(2, "Kannada");
						ps_ins.setString(3, "1:55");
						ps_ins.setString(4, "U");
						ps_ins.setInt(5, sl_no);
					}
					else 
					{
						ps_ins.setString(1, bean.getMov_name());
						ps_ins.setString(2, "English");
						ps_ins.setString(3, "2:05");
						ps_ins.setString(4, "A");
						ps_ins.setInt(5, sl_no);
					}
					ps_ins.execute();

					return Constants.SUCCESS;
				}
			}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_ins);
			JDBCHelper.close(ps_sql);
			JDBCHelper.close(con);
		}				

	}

	public boolean checkEmailExists(String email) {
	
		Connection con = null;
		PreparedStatement ps_sel=null;
		ResultSet rs = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				throw new RuntimeException("Connection not established. Contact DBA!");
			else
			{
				ps_sel = con.prepareStatement("select email from customer where email = ?");
				ps_sel.setString(1, email);
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();
				
				if(rs.next())
					return true;
				else
					return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}

	}
	
}
