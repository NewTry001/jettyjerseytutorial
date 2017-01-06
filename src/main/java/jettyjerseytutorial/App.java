package jettyjerseytutorial;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * https://www.acando.no/thedailypassion/200555/a-rest-service-with-jetty-and-jersey
 *
 */
public class App 
{
    public static void main( String[] args )
            {

        ResourceConfig config = new ResourceConfig();
        config.packages("jettyjerseytutorial");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));


        Server server = new Server(2222);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");


        try {
            server.start();
            server.join();
        }
        catch (Exception ex ){
            System.out.println(ex.toString());
        }
        finally {
        server.destroy();
    }

    }
}
