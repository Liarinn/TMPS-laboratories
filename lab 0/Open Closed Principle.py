from abc import ABC, abstractmethod

class Shape (ABC) :
    @abstractmethod
    def area (self) :
        pass

class Rhombus(Shape) :
    def __init__(self, base, height):
        self.base = base
        self.height = height
        
    def area (self) :
        return self.height * self.base
    
class Circle(Shape) :
    def __init__(self, radius):
        self. radius = radius

    def area(self):
        return 3.14159 * self. radius * self. radius

def calculate_total_area (shapes) :
    total_area = sum(shape.area() for shape in shapes)
    return total_area

shapes = [Rhombus(12, 5), Circle(6)]
total_area = calculate_total_area (shapes)
print ("Total area is: ", total_area)