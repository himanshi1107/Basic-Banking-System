package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;

@WebServlet("/signInserv")
public class SignInServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SignInServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id= String.valueOf(request.getParameter("id"));
		String password=request.getParameter("password");
		
	
		if(new CustomerDAO().checkCustomerDetails(id, password))
		{
			  HttpSession session=request.getSession();  
		       session.setAttribute("id",id);  
		       session.setAttribute("password",password); 	   
			response.sendRedirect("userDashboard.jsp");
		}else
		{
			out.print("Customer not exist");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		
	}

}
