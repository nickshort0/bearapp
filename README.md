# TEKsystems Java Developer - Case Study
This is an application about bears.

## Technologies Used

* Spring MVC
* Spring Data JPA with Hibernate
* Spring Security
* Java Bean Validation and Hibernate Validator
* JUnit
* Thymeleaf
* MariaDB
* H2 for testing
* Bootstrap
* HTML
* CSS

## Pages

* Home page
  - User can learn what bears are and navigate to other pages

* Bear
  - Displays paginated sortable table containing all bears in the database. User can click on the bear to show bootstrap modal that has bear image and description. If user is logged in the 'add bear' column is displayed and user can add bear to profile.

* Login
  - User can login to account. Link to create account is also shown. If no account exists, error message is displayed.

* Register
  - Allows creation of account using username, email, and password

* User
  - Show links to user action pages - my bears, create bear, battle, as well as logout button

## ERD

![erd](https://user-images.githubusercontent.com/103460832/177068921-bd3c42b1-1060-4184-b2b6-1f4549af28b1.png)
