package domain;

import models.XmlData;

public class LoggingDecorator implements IRestoApp {

    private final IRestoApp decoratedApp;

    // Constructor that accepts any IMultiRestoApp object
    public LoggingDecorator(IRestoApp app) {
        this.decoratedApp = app;
    }

    @Override
    public void displayMenus(XmlData xmlData) {
        System.out.println("Logging: Displaying menus...");
        decoratedApp.displayMenus(xmlData); // Delegate to the wrapped object
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        System.out.println("Logging: Displaying recommendations...");
        decoratedApp.displayRecommendations(xmlData); // Delegate to the wrapped object
    }
}
