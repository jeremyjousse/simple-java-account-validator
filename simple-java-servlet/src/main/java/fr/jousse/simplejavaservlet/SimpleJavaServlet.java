package fr.jousse.simplejavaservlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class SimpleJavaServlet {
  public static void main(String[] args) throws Exception {

    // Create a server that listens on port 8080.
    Server server = new Server(8080);

    //WebAppContext webAppContext = new WebAppContext();


    var handler = new ServletHandler();
    server.setHandler(handler);
    handler.addServletWithMapping(SimpleHttpServlet.class, "/*");

    // Load static content from inside the jar file.



    // Start the server! 🚀
    server.start();
    System.out.println("Server started!");

    // Keep the main thread alive while the server is running.
    server.join();
  }
}
