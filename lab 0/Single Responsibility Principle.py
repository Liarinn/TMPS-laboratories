class Book:
    def __init__(self, name, author, price):
        self.name = name
        self.author = author
        self.price = price

class Order:
    def __init__(self, order_id, books) :
        self.order_id = order_id
        self.books = books

    def calculate_total(self):
        total = sum(book.price for book in self.books)
        return total
    
class OrderManager:
    def place_order(self, order):
        total = order.calculate_total()
        print(f'The tootal is: {total}')


order_books = [
    Book("It ends with us", "Colleen Hoover", 350),
    Book("It starts with us", "Colleen Hoover" , 300),
    Book("Reversed insanity", "Gu Zhen Re", 429)
]

order = Order (123523, order_books)
order_manager = OrderManager ()

order_manager.place_order(order)