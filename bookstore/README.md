<h1>Bookstore Project</h1>
<h2>Framework Selection</h2>

1. Spring Boot (Required)
2. MyBatis Plus (Customized ORM framework for simplicity, jps also works)
3. H2 Database (Required)
4. Lombok (Bean method generator for simplicity)
5. Swagger (Required)
6. Spring Boot Validation (to validate input)
7. Spring test, Mockito (for test purpose)

<h2>How to Run</h2>
Since all the dependencies need to be downloaded in case you don't have all of them, 
it is highly recommended to open the project with an IDE, like IntelliJ.
After the project is fully loaded, 
1. in the base path of the project, right-click pom.xml 
2. select "Maven - Reload Project" to download dependencies with the correct version.
3. Open file "./src/main/java/com/blizzard/bookstore/BookstoreApplication.java"
4. Right-click the file or in the editor panel
5. select Run"BookStoreApplication.main()" to run the project

<h2>APIs</h2>
<h3>book-controller</h3>
`POST /book` to add a new book with parameters below

`{
"title": "string",
"author": "string",
"price": 0,
"category": "string"
}`

`POST /addToCart` to add a book into shopping cart with parameter
userid, bookId, quantity. to update to DTO

`GET /books` to get all the books

`GET /book/{id}` to get one book by id
<h3>shopping-cart-controller</h3>
`GET /cart/{userId}` to get cart by user id
`GET /cart/checkout/{userId}` to calculate the sum of items in the shopping cart

<h2>How to Run Tests</h2>
Didn't finish all the unit tests. For one single test, please follow the steps below:
1. Go to file com/blizzard/bookstore/controller/BookControllerTest.java
2. Right-click the file and select "Run 'BookControllerTest'"
