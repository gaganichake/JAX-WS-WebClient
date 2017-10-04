package com.gagan.webservice.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gagan.webservice.Greeting;
import com.gagan.webservice.GreetingImplService;

public class Client extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {

			out.println("<html lang=\"en\">");
			out.println("<head>");
			out.println("<title>Servlet Client</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<i>Response:</i>");
			out.println("<p>" + sayHello("Gagan") + "</p>");
			out.println("</body>");
			out.println("</html>");

		} finally {
			out.close();
		}
	}

	private String sayHello(java.lang.String arg0) {

		GreetingImplService service = new GreetingImplService();
		Greeting greeting = service.getGreetingImplPort();

		return greeting.sayHello(arg0);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req,resp);
	}

}
