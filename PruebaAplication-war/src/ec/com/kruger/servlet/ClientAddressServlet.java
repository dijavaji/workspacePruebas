package ec.com.kruger.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ClientAddressServlet extends HttpServlet {
	
	 public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

	        PrintWriter out = res.getWriter();
	        res.setContentType("text/plain");
	        // client's IP address
	        String remoteAddr = req.getRemoteAddr();
	        // client's hostname
	        String remoteHost = req.getRemoteHost();
	        out.write("remoteAddr = ");
	        out.write(remoteAddr);
	        out.write("n");
	        out.write("remoteHost = ");
	        out.write(remoteHost);
	        out.close();

	    }
	
}
