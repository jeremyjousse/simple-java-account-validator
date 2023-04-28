package fr.jousse.simplejavaservlet;


import fr.jousse.simplejavaservlet.validations.InDatabaseLoginValidation;
import fr.jousse.simplejavaservlet.validations.LoginValidation;
import fr.jousse.simplejavaservlet.validations.ValidationBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class SimpleHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        //ServletOutputStream out = res.getOutputStream();
        /*
        res.setContentType("application/json");
        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().println("{ \"status\": \"ok\"}");

         */

        new InDatabaseLoginValidation();

        LoginValidation validation = ValidationBuilder.build();



        res.setContentType("text/html;");
        res.getWriter().println("<h1>Hello Jérôme and Laurent " + validation.getClass() +  "!</h1>");
    }
}
