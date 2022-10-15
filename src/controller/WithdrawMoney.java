package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.TransactionDAO;



@WebServlet("/withdrawmoney")
public class WithdrawMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public WithdrawMoney() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String pin = (String) session.getAttribute("upi_pin");
		String id = (String) session.getAttribute("id");
		String acc_no = (String) session.getAttribute("acc_no");
		String balance = (String) session.getAttribute("balance");
		String amount = request.getParameter("amount");
		String upi_pin = request.getParameter("upi_pin");
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time =dateFormat.format(date);

		int bal1 = Integer.parseInt(balance);
		int bal2 = Integer.parseInt(amount);
		String total = String.valueOf(bal1 - bal2);

		if (pin.equals(upi_pin)) {

			int a = new CustomerDAO().updateMoney(total, id);

			if (a > 0) {
				
				String str = new TransactionDAO().withdrawMoney(acc_no, time, amount, total, "Debited");

				if (!str.equals(null)) {
					System.out.print("Success");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("userDashboard.jsp");
					requestDispatcher.forward(request, response);
				}

			} else {
				System.out.print("Invalid");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("withdrawMoney.jsp");
				requestDispatcher.forward(request, response);
			}

		}
	}

}
