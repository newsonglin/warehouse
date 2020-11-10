package com.lin.cxf.servlet;
import com.lin.cxf.client.CustomerClient;
import com.lin.cxf.vo.CustomerResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestClientServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        CustomerClient client = ctx.getBean("customerClient", CustomerClient.class);

        CustomerResponse response=client.processCustomer();


        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.print("customer Details: " + response.toString());
        pw.flush();
    }
}
