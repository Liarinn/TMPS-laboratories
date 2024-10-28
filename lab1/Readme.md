# Creational Design Patterns
***
## Author: Doni Corina
***
### Objectives
1. Study and understand Creational Design Patterns.
2. Choose a domain, define its main classes/models/entities, and apply appropriate instantiation mechanisms.
3. Use several creational design patterns for object instantiation in a sample project.
***

### The Used Design Patterns
1. **Factory Method Pattern**  
   This pattern defines an interface for creating an object but allows subclasses to alter the type of objects that will be created.

2. **Abstract Factory Pattern**  
   Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

3. **Builder**  
   Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
***

## Implementation

### 1. **Implementation of Factory Method Pattern**

The Factory Method pattern is used to create mobile phones of different brands. 

1. **Mobile Factory Interface**
    
    `MobileFactory` is responsible for deciding which specific mobile object to instantiate based on the given type.

    ```java
    public interface IMobileFactory {
    IMobile createMobile(String model);
    }
    ```

1. **IMobile Interface**  
   The `IMobile` interface defines the common properties and methods (`cost`, `pictureCapacity`, and `batteryPower`) that every mobile phone should have. This interface ensures that any mobile phone is created will have these methods, even if the specific details vary by brand.

   ```java
   public interface IMobile {
      public void cost();
      public void pictureCapacity();
      public void batteryPower();
   }
   ```

2. **Concrete Classes (Iphone and Samsung)**  
   There are two classes, `Iphone` and `Samsung`, which implement the `IMobile` interface. Each class provides its own version of `cost`, `pictureCapacity`, and `batteryPower`, making each mobile type unique in terms of attributes.

   ```java
  
   public class Samsung implements IMobile {
      @Override
      public void cost() {
         System.out.println("Samsung Cost starts from 6000");
      }

      @Override
      public void pictureCapacity() {
         System.out.println("Samsung camera capacity starts from 4 MP");
      }

      @Override
      public void batteryPower() {
         System.out.println("Samsung battery power starts from 1200 MAh");
      }
   }
   ```

3. **Factory Class (SimpleMobileFactory)**  
   The `SimpleMobileFactory` class contains the `createMobile` method, which takes a `type` parameter to decide which mobile object to create. If the `type` is `"iph"`, it creates a `Iphone` object; if it’s `"sam"`, it creates a `Samsung` object. This helps us hide the creation details from the client and makes it easy to add new mobile types.

   ```java
   public class SimpleMobileFactory {
      IMobile createMobile(String type) {
         IMobile mob = null;
         if ("iph".equalsIgnoreCase(type)) {
            mob = new Iphone();
            System.out.println("Iphone created");
         } else if ("sam".equalsIgnoreCase(type)) {
            mob = new Samsung();
            System.out.println("Samsung created");
         }
         return mob;
      }
   }
   ```

4. **Client Code (FactoryTest)**  
   The `FactoryTest` class is used to create objects. The client code calls `SimpleMobileFactory.createMobile` with a specified type and doesn’t need to know which concrete class is instantiated.

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

    Factory method is  creating and returning the appropriate mobile object based on the type specified in the client code.

### 2. **Implementation of Abstract Factory Pattern**

The Abstract Factory Pattern provides a way to create families of related or dependent objects without specifying their concrete classes. This pattern involves creating a set of related factories, which can create objects that are part of a family. This helps manage and encapsulate the instantiation process for groups of related objects.

1. **IMobileFactory Interface**
    The `IMobileFactory` interface defines a contract for creating mobile factory instances based on the provided type.

    ```java
    public interface IMobileFactory {
        IMobileFactory createMobile(String type);
    }
    ```
2. **AdvancedMobileFactory**
    The `AdvancedMobileFactory`implements the IMobileFactory interface and serves as the main factory to create mobile factories based on the type specified.

    ```java
    public class AdvancedMobileFactory implements IMobileFactory {
        @Override  
        public IMobileFactory createMobile(String type) {
            IMobileFactory mob = null;
            if ("lenf".equalsIgnoreCase(type)) {
                mob = new LenovoMobileFactory();
            } else if ("samf".equalsIgnoreCase(type)) {
                mob = new SamsungMobileFactory();
            }
            return mob;
        } 
    }
    ```

3. **AbstractFactoryTest**
    The `AbstractFactoryTest` demonstrates the usage of the abstract factory pattern by creating mobile objects through the appropriate factories.

    ```java
    public class AbstractFactoryTest {
        public static void main(String[] args) {
            MobileFactory factory = new MobileFactory();
            LenovoMobileFactory lmf = (LenovoMobileFactory) factory.createMobile("lenf");
            Lenovo ln = (Lenovo) lmf.createLenovoMobile();
            ln.pictureCapacity();
        }
    }
    ```

### 3. **Implementation of Builder Pattern**

The Builder pattern is used to build a complex object, a `Meal`, in steps. Each builder focuses on creating specific parts of the meal, while the `MealDirector` directs the construction process.

1. **MealBuilder Interface**
    The `MealBuilder` interface defines methods to set up each part of a meal (starter, main course, dessert) and a method to return the final meal.

    ```java
    public interface MealBuilder {
        public void buildStarter();
        public void buildMainCourse();
        public void buildDesserts();
        public Meal getMeal();
    }
    ```

2. **Concrete Builders**
    Each builder class (e.g., `KoreanMealBuilder`, `JapaneseMealBuilder`) creates a different type of meal by implementing the `MealBuilder` interface.

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

3. **MealDirector**
    The `MealDirector` class is responsible for coordinating the meal-building process. It takes a `MealBuilder` instance and calls its methods to create each part of the meal.

    ```java
    public class MealDirector {
        private MealBuilder mealBuilder;

        public MealDirector(MealBuilder mealBuilder) {
            this.mealBuilder = mealBuilder;
        }

        public void constructMeal() {
            mealBuilder.buildStarter();
            mealBuilder.buildMainCourse();
            mealBuilder.buildDesserts();
        }

        public Meal getMeal() {
            return mealBuilder.getMeal();
        }
    }
    ```

4. **BuilderTest Class**
    In`BuilderTest` we can create a `MealDirector` to manage the building process and a `KoreanMealBuilder` to specify what type of meal we want.

    ```java
    public class BuilderTest {
        public static void main(String[] args) {
            MealBuilder koreanMealBuilder = new KoreanMealBuilder();
            MealDirector mealDirector = new MealDirector(koreanMealBuilder);
            mealDirector.constructMeal();
            Meal meal = mealDirector.getMeal();
            System.out.println("Requested meal is: " + meal);
        }
    }
    ```

### Output
```
Iphone created
Iphone battery power starts from 3000 MAh
Samsung created
Samsung Cost starts from 5000

Iphone camera capacity starts from 10 MP

Requested meal is :Meal [starter=Korean Starter, mainCourse=Korean MainCourse, desserts=Korean Desserts]
```

