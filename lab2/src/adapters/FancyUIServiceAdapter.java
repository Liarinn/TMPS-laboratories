package adapters;

import domain.IRestoApp;
import models.JsonData;
import models.XmlData;
import services.FancyUIService;

public class FancyUIServiceAdapter implements IRestoApp {

    private final FancyUIService fancyUIService;

    public FancyUIServiceAdapter() {
        fancyUIService = new FancyUIService();
    }

    @Override
    public void displayMenus(XmlData xmlData) {
        JsonData jsonData = convertXmlToJson(xmlData);
        System.out.println("Displaying Fancy Menus using converted JSON data...");
        fancyUIService.displayMenus(jsonData);
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        JsonData jsonData = convertXmlToJson(xmlData);
        System.out.println("Displaying Fancy Recommendations using converted JSON data...");
        fancyUIService.displayRecommendations(jsonData);
    }

    private JsonData convertXmlToJson(XmlData xmlData) {
        // Converts XmlData to JsonData and return it
        System.out.println("Converting XML to JSON...");
        return new JsonData();
    }

}
