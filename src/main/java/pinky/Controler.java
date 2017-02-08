package pinky;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Controler implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    public void greet(final int port) throws Exception {

        final URL obj = new URL("http://localhost:8090/register/");

        final HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(20000);
        con.setDoOutput(true);

        final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.write(("{\"name\":\"Pinky\",\"url\":\"http://localhost:" + port + "/sayHello/\"}").getBytes());
        wr.flush();
        wr.close();

        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        final StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        System.out.println(response.toString());
    }

    @Override
    public void onApplicationEvent(final EmbeddedServletContainerInitializedEvent event) {

        try {
            this.greet(event.getEmbeddedServletContainer().getPort());
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
