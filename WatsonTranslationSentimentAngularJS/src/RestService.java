

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestService
 */
@WebServlet("/RestService")
public class RestService extends HttpServlet {
	private static final String REST_ENDPOINT = "http://4olaf.mybluemix.net";
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RestService() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL(REST_ENDPOINT+"/olli?message="+URLEncoder.encode(request.getParameter("message")));

	    URLConnection conn = url.openConnection();
	    conn.connect();

	    BufferedReader br = new BufferedReader(
	        new InputStreamReader(conn.getInputStream()));  // This line is generating the error
	    String line = "";
	    PrintWriter pw = response.getWriter();
	    while((line = br.readLine()) != null) {
	        pw.println(line);
	    } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
