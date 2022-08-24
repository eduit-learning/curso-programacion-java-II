package Servlets;

import jakarta.jws.WebService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/primer-servlet")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.print("<!DOCTYPE html>");
        pw.print("<html>");
        pw.print("<head>");
        pw.print("<meta charset=\"UTF-8\">");
        pw.print("<title>Hola a mi primer servlet</title>");
        pw.print("</head>");
        pw.print("<body>");
        pw.print("<h1>Hola a mi primer servlet</h1>");
        pw.print("</body>");
        pw.print("</html>");

        pw.close();
    }
}
