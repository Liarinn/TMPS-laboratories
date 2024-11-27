# Behavioral Design Patterns
***
## Author: Doni Corina
***
### Objectives
    1. Study and understand the BehavioralDesign Patterns.

    2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.

    3. Implement some additional functionalities using behavioral design patterns.
***

### The Used Design Patterns
**Chain of Responsibility**  
   The Chain of Responsibility design pattern is a behavioral design pattern that allows an object to pass a request along a chain of handlers. Each handler in the chain decides either to process the request or to pass it along the chain to the next handler.
***

## Implementation

The code extends the restaurant from the previous laboratory. Supose the owner of the restaurant has decided to add a login fucntion to the webpage. There are 2 roles posible for the user, we need the Chain of Responsibility pattern.Each step in the authentication process is handled by a specific handler class, which performs a task and decides whether to pass the request to the next handler.

### 1. **Implementation of Chain of Responsibility Pattern**

Handlers: These classes performing specific checks (like verifying a username, password, or user role). 
Database: A mock database that holds user credentials
AuthService: The central command hub. It interacts with the chain of handlers and decides whether someone gets authenticated or not.
MainApp: It sets up the system and starts the login process.

1. **Main Application**
    
    It sets up the handler chain and hands it off to the AuthService to handle authentication.

    ```java
    Database database = new Database();
    Handler handler = new UserExistsHandler(database);
    handler.setNextHandler(new ValidPasswordHandler(database))
            .setNextHandler(new RoleCheckHandler());
    AuthService service = new AuthService(handler);
    ```


    Handler handler = new UserExistsHandler(database);
    This handler makes sure the username exists in the database.

    handler.setNextHandler(new ValidPasswordHandler(database))
    Adds the password validation step. If the username checks out, this handler confirms the password is correct.

    setNextHandler(new RoleCheckHandler());
    The final step in the chain. It determines what kind of user you are admin or not.

    AuthService service = new AuthService(handler);
    Packages everything up into the AuthService.



2. ** Database Class**  
   
   Simulates a database of users and passwords.

   ```java
   private final Map<String, String> users;

    public Database() {
        users = new HashMap<>();
        users.put("admin_username", "admin_password");
        users.put("user_username", "user_password");
    }
    public boolean isValidUser(String username) {
        return users.containsKey(username);
    }

    public boolean isValidPassword(String username, String password) {
        return users.get(username).equals(password);
    }
   ```
    Map<String, String> users: A HashMap that stores user credentials, where the key is the username, and the value the password.
    isValidUser(): Checks if a username exists in the users map.
    isValidPassword(): Verifies if the provided password matches the one stored in the users map for the given username.

3. **Handler Abstract Class**
    
    Defines the interface and shared logic for all handlers in the chain.

    ```java
    private Handler next;

    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }

    protected boolean handleNext(String username, String password) {
        if (next == null) {
            return true;
        }
        return next.handle(username, password);
    }

    ```
    Handler next: Stores a reference to the next handler in the chain.
    setNextHandler(): Links the current handler to the next one and returns it, that hpw the chain forms.
    handleNext(): Invockes the handle method of the next handler, if it exists.

4. **UserExistsHandler Class**
    
    Checks if the username exists in the database.
    ```java
    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidUser(username)) {
            System.out.println("This username is not registered!");
            System.out.println("Sign Up to our app now!");
            return false;
        }
        return handleNext(username, password);
    }
    ```
    handleNext(): Passes the request to the next handler if the user exists.

5. **ValidPasswordHandler Class**
    
    Verifies the user's password.

    ```java
    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidPassword(username, password)) {
            System.out.println("Wrong Password!");
            return false;
        }
        return handleNext(username, password);
    }
    ```
    handleNext(): Passes the request to the next handler if the password is valid.

6. ** RoleCheckHandler Class**
    
    Determines the user's role and provides appropriate access.

    ```java
    @Override
    public boolean handle(String username, String password) {
        if ("admin_username".equals(username)) {
            System.out.println("Loading Admin Page...");
            return true;
        }
        System.out.println("Loading Default Page...");
        return handleNext(username, password);
    }
    ```
    handleNext(): For normal users, it prints "Loading Default Page...". In this case, this is the last handler in the chain.

7. **AuthService Class**
    
    Is the central point for managing authentication.

    ```java
    public boolean logIn(String email, String password) {
    if (handler.handle(email, password)) {
        System.out.println("Authorization was successful!");
        return true;
    }
    return false;
    }
    ```
    handler.handle(email, password): Starts the chain.
    Successful Authentication: If the entire chain approves the login request (returns true).
    Failed Authentication: If any handler rejects the request (returns false), the process stops.



### Output
```
==========================================
This username is not registered!
Sign Up to our app now!
false
==========================================
Wrong Password!
false
==========================================
Loading Admin Page...
Authorization was successful!
true
==========================================
```

### Conclusion
```
In this laboratory I used the Chain of Responsibility pattern to handle an authentication process for the restaurant webpage.

The `Database` class acts like a mock database, storing usernames and passwords. It has methods to check if a username exists and whether a password matches. The handlers (`UserExistsHandler`, `ValidPasswordHandler`, and `RoleCheckHandler`) each do one specific task. For example, `UserExistsHandler` checks if the username is in the database. If it’s not, the chain stops there, printing an error. If it’s valid, the next handler runs.

This pattern is useful because it separates responsibilities. If I ever need to add a new check, like verifying a two-factor authentification, I can add in another handler without touching the rest of the code. That makes it easier to update or debug. It’s also efficient if the user fails the first check, the rest of the chain doesn’t run, saving time.

What I learned from this is how helpful modular design can be. Breaking a process into smaller, focused pieces makes it easier to read and change later, even if it's anoying to write it. I also saw how separation helps flexibility. The `AuthService` doesn’t know what checks the handlers do; it just runs the chain. That’s good because you can change how the chain works without rewriting everything.
