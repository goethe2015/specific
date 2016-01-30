package org.test.check.time;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckerServlet
 */
@WebServlet("/check")
public class CheckerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		FileChecker job = new FileChecker(new File("/home/kdiamantis/Schreibtisch/Workspaces/java_workspace/file-watcher-diam/src/main/resources/demo.xsd"));
		Timer timer = new Timer();
		job.isChanged();
		timer.schedule(job, new Date(), 1000);
		response.getWriter().append("Time Check: ").append("Execution" + job.scheduledExecutionTime());
	}

}
