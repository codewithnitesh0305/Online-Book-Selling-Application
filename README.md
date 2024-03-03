# Online-Book-Selling-Application
The online book selling application provides a platform for users to buy and sell books. It consists of two main modules: the Admin Module and the User Module. The Admin Module allows administrators to manage the book inventory, while the User Module enables regular users to browse and purchase books, as well as list their own books for sale.
Admin Module:
Admin Login Page (adminLogin.jsp):

This page will have a form where the admin can input their username and password.
Upon submission, the credentials will be sent to a servlet for authentication.
If authentication is successful, the admin will be redirected to the Admin Dashboard; otherwise, an error message will be displayed.
Admin Dashboard (adminDashboard.jsp):

The dashboard will display various options for managing books, such as adding a new book, updating existing ones, deleting books, and viewing the list of available books.
It will also provide links for the admin to log out from the session.
Add Book Form (addBook.jsp):

This form allows the admin to input details about a new book, such as title, author, description, price, etc.
Upon submission, the data will be sent to a servlet for processing and insertion into the database.
Delete Book Servlet (DeleteBookServlet.java):

This servlet handles the deletion of books from the database.
It receives a request containing the book ID to be deleted and executes the SQL query to remove the corresponding entry from the database.
Update Book Servlet (UpdateBookServlet.java):

Responsible for updating the information of existing books in the database.
It receives a request containing the updated book details and executes the SQL query to update the corresponding entry in the database.
Read Books Servlet (ReadBooksServlet.java):

Retrieves books from the database and sends them to the Admin Dashboard for display.
It executes a SQL query to fetch all books and their details from the database.

User Module:
User Registration Page (userRegistration.jsp):

This page contains a form for user registration, where users can provide details such as username, password, email, etc.
Upon submission, the data will be sent to a servlet for validation and insertion into the database.
User Login Page (userLogin.jsp):

Similar to the admin login page, this page allows users to log in using their credentials.
After successful authentication, users will be redirected to the User Dashboard.
User Dashboard (userDashboard.jsp):

Displays options for users to manage their books, view purchased books, and search for books to purchase.
Provides links to log out from the session.
Add Book for Sale Form (addBookForSale.jsp):

Allows users to add their own books for sale, including details such as title, author, price, condition, etc.
Upon submission, the data will be sent to a servlet for processing and insertion into the database.
Manage Books Servlet (ManageBooksServlet.java):

Handles addition, deletion, and updating of user's books in the database.
It receives requests containing book details and executes appropriate SQL queries to perform CRUD operations.
Search Book Servlet (SearchBookServlet.java):

Enables users to search for books available for sale based on various criteria such as title, author, genre, etc.
It receives search parameters from the user and executes SQL queries to fetch relevant books from the database.
Purchase Book Servlet (PurchaseBookServlet.java):

Manages the purchase process when a user decides to buy a book.
It receives requests containing book details and executes SQL queries to update the database with the purchase information.

Technologies Used:
Servlets: Handle HTTP requests and responses, enabling server-side processing.

JSP (JavaServer Pages): Generates dynamic web pages to interact with users.

JDBC (Java Database Connectivity): Facilitates interaction with the MySQL database.

JSTL (JavaServer Pages Standard Tag Library): Provides tags to simplify the presentation of data in JSP pages.

MySQL: A relational database management system used to store application data.

Home Page:-
![localhost_8080_E-Books_ (1)](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/13b2159a-0757-473c-820f-d361f3f798c6)

User Basboard:-
![Screenshot 2024-03-03 132906](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/d2ce9e17-921c-47cc-8465-ab6adcce211e)

Add to cart:-
![Screenshot 2024-03-03 132839](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/3ee45d76-fb5a-463f-9037-4aa28d34c411)

User Order Books:-
![Screenshot 2024-03-03 132926](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/935c2c20-c1ea-4df7-9923-d92033271812)

User Inventroy Dashboard:-
![Screenshot 2024-03-03 132953](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/551501b7-a2f6-4740-b0cf-8e8a7afd677c)

Admin DashBoard:-
![Screenshot 2024-03-03 133039](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/4a9e2c60-6077-4127-ba3a-9382748cf06f)

Add Books to Inventroy:-
![Screenshot 2024-03-03 133057](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/44cbd36d-6b62-4975-a2ed-23dd23386928)

All Books:-
![Screenshot 2024-03-03 133147](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/ee440aee-27a2-488b-8062-2af0345519a9)

Order Books:-
![Screenshot 2024-03-03 133217](https://github.com/codewithnitesh0305/Online-Book-Selling-Application/assets/133355700/313ae8ae-1c95-4869-baf6-a7692b284837)
