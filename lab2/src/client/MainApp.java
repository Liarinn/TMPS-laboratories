package client;

import domain.IRestoApp;
import domain.LoggingDecorator;
import domain.RestoFacade;
import models.XmlData;

public class MainApp {

    public static void main(String[] args) {

        XmlData myData = new XmlData();

        // Use RestoFacade wrapped with LoggingDecorator
        IRestoApp restoFacadeWithLogging = new LoggingDecorator(new RestoFacade());
        restoFacadeWithLogging.displayMenus(myData);
        restoFacadeWithLogging.displayRecommendations(myData);

        System.out.println("==========================================");

        // Additional configurations for other UI components could be added here
    }
}
