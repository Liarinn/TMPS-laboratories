package client;

import domain.AuthService;
import domain.handlers.Handler;
import domain.handlers.UserExistsHandler;
import domain.handlers.ValidPasswordHandler;
import domain.handlers.RoleCheckHandler;
import utilities.Database;

public class MainApp {

    public static void main(String[] args) {

        Database database = new Database();
        Handler handler = new UserExistsHandler(database);
        handler.setNextHandler(new ValidPasswordHandler(database))
                .setNextHandler(new RoleCheckHandler());

        AuthService service = new AuthService(handler);

        System.out.println("==========================================");

        System.out.println(service.logIn("username", "password"));

        System.out.println("==========================================");

        System.out.println(service.logIn("user_username", "password"));

        System.out.println("==========================================");

        System.out.println(service.logIn("admin_username", "admin_password"));

        System.out.println("==========================================");
    }
}
