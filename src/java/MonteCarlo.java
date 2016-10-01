package java;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Michael on 01.10.2016.
 *
 */

@Path("MonteCarlo")
public class MonteCarlo {

    @GET
    @Path("Pi/{numberOfDrops}")
    @Produces(MediaType.TEXT_XML)
    public String calcPi(@PathParam("numberOfDrops") int numberOfDrops) {

        int dropsHit = 0;

        for (int i = 0; i < numberOfDrops; ++i) {
            double x = Math.random();
            double y = Math.random();

            if (Math.hypot(x, y) <= 1) {
                ++dropsHit;
            }
        }

        float pi = (4 * dropsHit) / numberOfDrops;

        return "<MonteCarlo>" +
                    "<Result>" +
                        "<Pi>" +
                            "<Name>" + "Pi is : " + "</Name>" +
                            "<Value>" + pi + "</Value>" +
                "</Pi></Result></MonteCarlo>";
    }
}