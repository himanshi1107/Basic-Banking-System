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


@WebServlet("/addmoney")
public class AddMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddMoney() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String upi_pin = (String) session.getAttribute("upi_pin");
		String id = (String) session.getAttribute("id");
		String acc_no = (String) session.getAttribute("acc_no");
		String balance = (String) session.getAttribute("balance");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time =dateFormat.format(date);
		
		String amount = request.getParameter("amount");
		String pin = request.getParameter("upi_pin");


		int bal1 = Integer.parseInt(balance);
		int bal2 = Integer.parseInt(amount);
		String total = String.valueOf(bal1 + bal2);


		if (pin.equals(upi_pin)) {

			int res = new CustomerDAO().updateMoney(total, id);

			if (res > 0) {
				String msg = new TransactionDAO().addMoney(acc_no, time, amount, total, "Credited");

				if (!msg.equals(null)) {
					System.out.print("Success");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("userDashboard.jsp");
					requestDispatcher.forward(request, response);
				}

			} else {
				System.out.print("Invalid");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("addMoney.jsp");
				requestDispatcher.forward(request, response);
			}

		}
	}


}
