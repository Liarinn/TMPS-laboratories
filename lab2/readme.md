# Structural Design Patterns
***
## Author: Doni Corina
***
### Objectives
1.Study and understand Creational Design Patterns.
2.Choose a domain, define its main classes/models/entities, and apply appropriate instantiation mechanisms.
3.Use several creational design patterns for object instantiation in a sample project.
***

### The Used Design Patterns
1. **Adapter Pattern**  
   Adapter Method or Adapter Design Pattern also knows as wrapper. It converts the interface of a class into another interface which clients expect. Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.

2. **Facade Pattern**  
   Facade Method Design Pattern provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

3. **Decorator Pattern**  
   Adding additional features or actions to an item without changing its structure is possible with the Decorator Method Design Pattern. Consider that you want to add things like milk, sugar, or whipped cream to your simple coffee. Instead of creating a whole new coffee type for every possible combination, the decorator pattern lets you “wrap” the plain coffee with add-ons.
***

## Implementation

The code extends the restaurant from the previous laboratory. Supose the owner of the restaurant has decided to make the UI of the app more fancy. To use a library that uses a different format than than other library already used for the app, it is decided to use the adapter pattern.

### 1. **Implementation of Adapter Pattern**

Adapter pattern conects the gap between:
-Existing XML based data (used by the old UI).
-New JSON based fancy UI library (FancyUIService), which requires JSON input.

1. **Target Interface (IMultiRestoApp)**
    
    IMultiRestoApp interface defines the methods displayMenus and displayRecommendations. This interface is used by both the old UI and the adapter for the new UI, allowing them to be interchangeable.

    ```java
    public interface IMultiRestoApp {
    void displayMenus(XmlData xmlData);
    void displayRecommendations(XmlData xmlData);
    }

    ```

2. ** Adaptee Class (FancyUIService)**  
   
   FancyUIService class represents the new library with fancier UI. It’s designed to display menus and recommendations but expects data in JSON format, not XML.

   ```java
   public class FancyUIService {
    public void displayMenus(JsonData jsonData) {
        System.out.println("Using fancy UI to display menus...");
    }

    public void displayRecommendations(JsonData jsonData) {
        System.out.println("Using fancy UI to display recommendations...");
    }
    }

   ```

3. ** Adapter Class (FancyUIServiceAdapter)**  
   
   FancyUIServiceAdapter implements IMultiRestoApp, making it compatible with clients expecting IMultiRestoApp implementations. But, it internally adapts XmlData to JsonData so that it can use the FancyUIService class.

   ```java
  public class FancyUIServiceAdapter implements IMultiRestoApp {
    
    private final FancyUIService fancyUIService;

    // Constructor initializes the fancy UI service
    public FancyUIServiceAdapter() {
        fancyUIService = new FancyUIService();
    }

    @Override
    public void displayMenus(XmlData xmlData) {
        JsonData jsonData = convertXmlToJson(xmlData); // Convert XML to JSON
        System.out.println("Displaying Fancy Menus using converted JSON data...");
        fancyUIService.displayMenus(jsonData); // Use fancy UI to display menus
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        JsonData jsonData = convertXmlToJson(xmlData); // Convert XML to JSON
        System.out.println("Displaying Fancy Recommendations using converted JSON data...");
        fancyUIService.displayRecommendations(jsonData); // Use fancy UI to display recommendations
    }

    // Helper method that simulates converting XmlData to JsonData
    private JsonData convertXmlToJson(XmlData xmlData) {
        System.out.println("Converting XML to JSON...");
        return new JsonData(); // Returns a new JsonData instance
    }
    }

   ```
Client (MainApp): Uses IMultiRestoApp to display menus and recommendations.
    
Adapter (FancyUIServiceAdapter): Adapts XmlData (existing format) to JsonData (required by FancyUIService).

Adaptee (FancyUIService): Provides enhanced UI display methods but only works with JsonData.


### 2. **Implementation of Facade Pattern**

The Facade pattern here is implemented through the RestoFacade class. Facade pattern simplifies and centralizes the interaction with different components involved in displaying menus and recommendations.

     **RestoFacade Class**  
   ```java
   public class FactoryTest {
      public static void main(String[] args) {
         SimpleMobileFactory factory = new SimpleMobileFactory();
         
         Iphone iph = (Iphone)factory.createMobile("iph");
         iph.batteryPower();

         Samsung sam = (Samsung)factory.createMobile("sam");
         sam.cost();
      }
   }
   ```
   The RestoFacade class wraps the IMultiRestoApp interface, so it is easier for the client (MainApp) to interact with the application. In result, instead of calling displayMenus and displayRecommendations directly on IMultiRestoApp, the client interacts with the simpler showMenus and showRecommendations methods provided by RestoFacade.

     **MainApp Class**  
   ```java
   public class MainApp {
    public static void main(String[] args) {
        XmlData myData = new XmlData();
        RestoFacade restoFacade = new RestoFacade(new FancyUIServiceAdapter());

        // Use facade to show menus and recommendations
        restoFacade.showMenus(myData);
        restoFacade.showRecommendations(myData);
    }   
    }
   ```
   The MainApp creates a single RestoFacade instance, which allows it to work with either the old or new UI. Here, FancyUIServiceAdapter is passed to the facade, so the app will use the more fancy UI library.



Without a Facade, each time its needed to add a new feature, its necessary to modify MainApp or any other client using the IMultiRestoApp directly. However, with the Facade pattern, it is possible to simply add these new features to RestoFacade, and the client code can remain the same.

### 3. **Implementation of Decodator Pattern**

Decorator pattern increases the maintainability and extensibility of the code by keeping concerns like logging separate from the main application logic.
Decorator will wrap existing implementations of IMultiRestoApp, such as MultiRestoApp and FancyUIServiceAdapter, adding logging functionality to them.

1. **MainApp.java class **

    ```java
    public static void main(String[] args) {

        XmlData myData = new XmlData();

        // Use RestoFacade wrapped with LoggingDecorator
        IMultiRestoApp restoFacadeWithLogging = new LoggingDecorator(new RestoFacade());
        restoFacadeWithLogging.displayMenus(myData);
        restoFacadeWithLogging.displayRecommendations(myData);

        System.out.println("==========================================");

        // Additional configurations for other UI components could be added here
    }
    ```
    RestoFacade with Logging: Here, RestoFacade is wrapped in LoggingDecorator, so any method called on restoFacadeWithLogging will automatically include logging.
    RestoFacade continues to manage the complexity of data conversion or other service interactions, while LoggingDecorator is solely responsible for logging without altering the core functionality.

2. **LoggingDecorator Class**
    
    LoggingDecorator class implements the IMultiRestoApp interface and wraps an existing IMultiRestoApp object. Inside each method, it adds logging messages before or after sending to the wrapped object.

    ```java
    public class KoreanMealBuilder implements MealBuilder {
        Meal meal = new Meal();

        @Override
        public void buildStarter() {
            meal.setStarter("Korean Starter");
        }
        
        @Override
        public void buildMainCourse() {
            meal.setMainCourse("Korean Main Course");
        }
        
        @Override
        public void buildDesserts() {
            meal.setDesserts("Korean Desserts");
        }
        
        @Override
        public Meal getMeal() {
            return meal;
        }
    }
    ```
    -Constructor: Takes any object that implements IMultiRestoApp and stores it in decoratedApp.
    -displayMenus: Logs a message and then calls the displayMenus method of the decorated object.
    -displayRecommendations: Logs a message and then calls the displayRecommendations method of the decorated object.


### Output
```
Logging: Displaying menus...
Facade: Displaying menus...
Logging: Displaying recommendations...
Facade: Displaying recommendations...
==========================================
```

### Conclusion
```
By implementing these creational design patterns, I have learned how to impliment them. Each on of them made the code follow better the Logic principles.
The Adapter pattern ensures that it is possible to integrate a new UI library without significant changes to existing codebase, simply by creating an adapter that translates data formats and interfaces. FancyUIServiceAdapter adapted the interface of a new UI service to the expected interface of IMultiRestoApp. This allowed me to integrate a new service (FancyUIService) that needed JSON data while keeping the existing interface that expected XML data.
In this code, without using facade pattern, the MainApp (client) would need to directly interact with IMultiRestoApp and potentially other classes if the requirements grew. By introducing the RestoFacade, MainApp only needs to know about a single class (RestoFacade). This encapsulates the complexity of the underlying system and simplifies client code.
Decorator pattern increases the maintainability and extensibility of the code by keeping concerns like logging separate from the main application logic. LoggingDecorator in the project was used to add logging functionality to the IMultiRestoApp implementations. By wrapping the RestoFacade and other IMultiRestoApp objects, I was able to add logging behavior without changing their core logic.
Writing the code that uses the Facade, Decorator, and Adapter patterns, it helped me better understand how to design flexible and maintainable systems using OOP principles.