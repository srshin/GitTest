

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SshConnect
 */

@WebServlet("/csvMonitor.go")
public class CsvMonitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsvMonitorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String command = "";
		String path = "";
		String result = "";
		String result1 = "";
		String result2 = "";
		SshConnectUtil2 scu = new SshConnectUtil2();
        try {
//			TimeUnit.MILLISECONDS.sleep(3000);
	    	command = "ls -l -t /home/srshin/bitcoin/csv/bitthumbitCoin  >  ";
	    	path = "list1.txt";
			result = scu.sshConnect(command, path);
			TimeUnit.MILLISECONDS.sleep(3000);

 
			path = "list2.txt";
			result = scu.sshConnect(command, path);
			TimeUnit.MILLISECONDS.sleep(3000);

			command = "diff ";
			path = "list2.txt  list1.txt";
			result1 = scu.sshConnect(command, path);

			command = "cat ";
			path = " list1.txt";
			result2 = scu.sshConnect(command, path);
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("result1", result1);

		request.setAttribute("result2", result2);
		RequestDispatcher rd = 
				request.getRequestDispatcher("output.jsp");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
