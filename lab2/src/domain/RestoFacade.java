package domain;

import models.XmlData;

public class RestoFacade implements IRestoApp {

    // Default constructor
    public RestoFacade() {
        // Initialization logic, if needed
    }

    @Override
    public void displayMenus(XmlData xmlData) {
        System.out.println("Facade: Displaying menus...");
        // Add logic to handle menu display
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        System.out.println("Facade: Displaying recommendations...");
        // Add logic to handle recommendations
    }
}
