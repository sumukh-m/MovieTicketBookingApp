package org.drait;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In doGet method");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in process() of CS");
		
		try {
			Model model = new Model();
			String uri  = request.getRequestURI();
			RequestDispatcher rd = null;
			System.out.println("CS->uri = "+uri);
			
			if ( uri.contains("/openRegisterView") )
			{
				System.out.println("In open Register View");
				rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			}

			if ( uri.contains("/openLoginView") )
			{
				System.out.println("In open Login View");
				rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}

			if ( uri.contains("/register.do") )
			{
				RegBean bean = (RegBean)request.getAttribute("reg");
				String result = model.register(bean);

				if ( result.equals(Constants.SUCCESS) )
				{
					request.setAttribute("message", "Yay, Your Registration is Successful<br/><br/><a href='HomePage.html'>Click this to go back to HomePage</a>");
					rd = request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("Register.jsp");
					rd.forward(request, response);
				}

			}

			if ( uri.contains("/login.do"))
			{
				LoginBean bean = (LoginBean)request.getAttribute("login");
				String result = model.authenticate(bean);

				if ( result.equals(Constants.SUCCESS))
				{
					HttpSession session = request.getSession(true);
					session.setAttribute("user", bean.getEmail());
					rd = request.getRequestDispatcher("Menu.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}

			if(uri.contains("/logout.do"))
			{
				HttpSession session  = request.getSession(false);
				if(session!=null)
				{
					session.removeAttribute("user");
					session.invalidate();
				}
				request.setAttribute("message", "You Have Successfully Logged Out, See you later .<br/><br/><a href='HomePage.html'>Click to this to go back to HomePage</a>");
				rd =request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);

			}
			
			if ( uri.contains("/bookingConfirm.do") )
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("Tbean", request.getAttribute("ticket") );
				rd = request.getRequestDispatcher("Confirmation.jsp");
				rd.forward(request, response);
			}
			
			if ( uri.contains("/bookingDone.do") )
			{
				HttpSession session = request.getSession(true);
				TicketBean bean = (TicketBean)session.getAttribute("Tbean");
				String email = (String)session.getAttribute("user");
				String result = model.bookTicket(bean, email);

				if ( result.equals(Constants.SUCCESS) )
				{
					session = request.getSession(false);
					if ( session != null )
					{
						session.removeAttribute("Tbean");
					}
					request.setAttribute("message", "Yay, The Ticket has been Booked.<br/> Enjoy the Show !<br/><br/><a href='Menu.jsp'>Click this to go back to Book More Movies</a>");
					rd = request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("Register.jsp");
					rd.forward(request, response);
				}

			}
			
			if ( uri.contains("/openBookTicketView"))
			{
				System.out.println("In Open Book Ticket View");
				String img = request.getParameter("movieImg");
				String name = request.getParameter("movieName");
				request.setAttribute("Img", img);
				request.setAttribute("Name", name);
				rd = request.getRequestDispatcher("BookTicket.jsp");
				rd.forward(request, response);
			}
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			request.setAttribute("errorMsg", "Something bad has happened msg = "+t.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In doPost method");
		process(request, response);
	}

}
