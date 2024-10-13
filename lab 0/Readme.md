## Objectives:

    -> Get familiar with the Solid Principles;
    -> Choose 2 specific Solid letter;
    -> Implement these 2 Solid letters in a simple project.

## Used Solid Principles:

    - Single Responsibility Principle (SRP);
    - Open-Closed Principle (OCP);

## Implementation:

**Single Responsibility Principle**: a class should do one thing and therefore it should have only a single reason to change
    I made a program that calculates the order tatal price when you buy books, each class has only one responsability.
    
    The Book responsability is just to be an item:
    ```
    class Book:
    def __init__(self, name, author, price):
        self.name = name
        self.author = author
        self.price = price
    ```
    
    The class Order responsability is just to calculate the tatal of the order.
    ```
    class Order:
    def __init__(self, order_id, books) :
        self.order_id = order_id
        self.books = books

    def calculate_total(self):
        total = sum(book.price for book in self.books)
        return total
    ```

    The class OrderManager is just a place to place the order
    ```
    class OrderManager:
    def place_order(self, order):
        total = order.calculate_total()
        print(f'The tootal is: {total}')
    ```

    All the responsabilities in the aplication are isolated from each other in different classes and functions.

**Open-Closed Principle**:  classes should be open for extension and closed to modification.
    I made a program that calculates the total area of 2 shapes a circle and a rhombus. The code can be extended without modifing the code of the clases that already exist.

    The class Shape is an abstract class that is a common interface for all shapes.
    ```
    class Shape (ABC) :
        @abstractmethod
        def area (self) :
            pass
    ```

    Classes Circle and Rhombus inherit from the Shape interface and calculate the are method
    ```
    class Rhombus(Shape) :
    def __init__(self, base, height):
        self.base = base
        self.height = height
        
    def area (self) :
        return self.height * self.base
    ```

    The functioin calculate_total_area can take any shapes from the list of shapes and return the total area, so we can add new shapes without modifying the code
    ```
    def calculate_total_area (shapes) :
        total_area = sum(shape.area() for shape in shapes)
        return total_area

    shapes = [Rhombus(12, 5), Circle(6)]
    ```

    You can add any other shape as rectangle or triangle, without the need to change the code that already exists. The area method is defined for each subclass, so claculating the are will remain consistent and calculate_total_area function works with any shape it inherits from Shape without needing to know the specific type.

## Conclusions / Screenshots / Results
    
In conclusion, this laboratory tought me successfully showed the application of two key SOLID principles: the Single Responsibility Principle (SRP) and the Open-Closed Principle (OCP). By following the SRP principle I made sure each class had a clear, single responsibility, leading to easy to read and maintainable code. The Book, Order, and OrderManager classes each focus on a distinct aspect of the program's functionality. Additionally, the implementation of OCP allowed us to extend the functionality of the code such as adding new shapes without altering the existing 

