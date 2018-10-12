import java.io.*;
import java.util.Enumeration;
import net.happygod.jerrymouse.server.*;

public class test extends Servlet
{
	@Override
	public void init()
	{
		System.out.println("Servlet -- init");
	}
	@Override
	public void doGet(Request request,Response response)
	{
		//response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head>");
		out.println("<title>ServletTest</title>");
		out.println("</head><body>");

		out.println("<h2>Headers</h2>");
		Enumeration headers=request.getHeaderNames();
		while(headers.hasMoreElements())
		{
			String header=(String)headers.nextElement();
			out.println(header+" : "+request.getHeader(header));
		}
		out.println("<br /><h2>Method</h2>");
		out.println(request.getMethod());

		out.println("<br /><h2>Parameters</h2>");
		Enumeration parameters=request.getParameterNames();
		while(parameters.hasMoreElements())
		{
			String parameter=(String)parameters.nextElement();
			out.println(parameter+" : "+request.getParameter(parameter));
		}

		out.println("<br /><h2>Query String</h2>");
		out.println(request.getQueryString());

		out.println("<br /><h2>Request URI</h2>");
		out.println(request.getRequestURI());

		out.println("</body></html>");
		out.flush();
	}

	@Override
	public void doPost(Request request,Response response)
	{
		doGet(request,response);
	}
}
