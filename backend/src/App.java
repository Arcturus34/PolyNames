import java.sql.SQLException;

import controllers.GameController;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        WebServer webserver = new WebServer();
        webserver.listen(8080);

        webserver.getRouter().get("/cartes", (WebServerContext context) -> {
            try {
                GameController.createCards(context);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        });
    }
}
