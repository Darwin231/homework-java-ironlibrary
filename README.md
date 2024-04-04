![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# HW | Java IronLibrary (Unit 3 homework)

## Introduction

For this homework, you will be building a Library Management System, that will help managing and acquiring data about the books that are being used by students.

## Instructions

Let's walk through the details of the homework:

### Classes

Four main classes are necessary to complete this homework.

These classes will be called **Author**, **Book**, **Student** and **Issue**.

<br>

**Book class**

This class will have:

- Variable called `isbn` of data type `string`, representing the **International Standard Book Number** and acting as the unique identifier for the table book (Private member)
- Variable called `title` of data type `string` (Private member)
- Variable called `category` of data type `string` (Private member)
- Variable called `quantity` of data type `integer` (Private member)
- A parameterized constructor that takes `isbn`, `title`, `category` and a `quantity`
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- Optional attributes are accepted if needed based on the code structure

<br>

**Author class**

This class will have:

- Variable called `authorId` of data type `integer`, auto-incremented (Private member)
- Variable called `name` of data type `string` (Private member)
- Variable called `email` of data type `string` (Private member)
- Variable called `authorBook` of data type `Book`, representing a One-to-One relationship with `Book` (Private member)
- A parameterized constructor that takes `name`, `email` and `authorBook`
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- Optional attributes are accepted if needed based on the code structure

<br>

**Issue class**

This class will have:

- Variable called `issueId` of data type `integer`, auto-incremented (Private member)
- Variable called `issueDate` of data type `string` (Private member)
- Variable called `returnDate` of data type `string` (Private member)
- Variable called `issueStudent` of data type `Student`, representing a One-to-One relationship with `Student`(Private member)
- Variable called `issueBook` of data type `Book`, representing a One-to-One relationship with `Book` (Private member)
- A parameterized constructor that takes `issueDate`, `returnDate`, `issueStudent` and `issueBook`
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- Optional attributes are accepted if needed based on the code structure

<br>

**Student class**

This class will have:

- Variable called `usn` of data type `string`, representing the **Universal Student Number** and acting as the unique identifier for the table student (Private member)
- Variable called `name` of data type `string` (Private member)
- A parameterized constructor that takes `usn` and `name`
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- Optional attributes are accepted if needed based on the code structure

## How the application works

After starting this application, a list of options will pop up for the user. The user will be asked to input a number based on the list of options displayed, such as adding a book, searching for a book, issuing a book for a student, etc.
After a certain action is executed, the menu is re-displayed for the user automatically.

The menu should have the following options:

1. Add a book
2. Search book by title
3. Search book by category
4. Search book by Author
5. List all books along with author
6. Issue book to student
7. List books by usn
8. Exit

## Actions

1. **Add a book**: This action is responsible of adding a book and its author in the system. The user will be prompted to enter the details of both the book and the author in the following format:

```
Enter your choice: 1
Enter isbn : 978-3-16-148410-0
Enter title : The Notebook
Enter category : Romance
Enter Author name : Nicholas Sparks
Enter Author mail : nicholassparks@gmail.com
Enter number of books : 4
```

2. **Search book by title**: This action is responsible for searching a book by title.

```
Enter your choice: 2
Enter title : The Notebook

Book ISBN               Book Title          Category    No of Books
978-3-16-148410-0       The Notebook        Romance     4
```

3. **Search book by category**: This action is responsible for searching a book by category.

```
Enter your choice: 3
Enter category : Romance

Book ISBN               Book Title          Category    No of Books
978-3-16-148410-0       The Notebook        Romance     4
```

4. **Search book by author**: This action is responsible for searching a book by author name.

```
Enter your choice: 4
Enter name : Nicholas Sparks

Book ISBN               Book Title          Category    No of Books
978-3-16-148410-0       The Notebook        Romance     4
```

5. **List all books along with author**: This action is responsible for listing all the books available and there corresponding authors.

```
Enter your choice: 5

Book ISBN               Book Title          Category    No of Books     Author name         Author mail
978-3-16-148410-0       The Notebook        Romance     4               Nicholas Sparks     nicholassparks@gmail.com
978-3-17-148410-0       Da Vinci Code       Mystery     5               Dan Brown           danbrown@gmail.com
```

6. **Issue book to student**: This action is responsible for creating a student and issuing him/her the specified book. The date issued represent the current date and the return date should be after 7 days.

```
Enter your choice: 6
Enter usn : 09003688800
Enter name : John Doe
Enter book ISBN : 978-3-17-148410-0

Book issued. Return date : Mon Aug 01 19:45:40 EEST 2022
```

7. **List books by usn**: This action is responsible for listing all books rented by the specified student.

```
Enter your choice: 7
Enter usn : 09003688800

Book Title          Student Name    Return date
Da Vinci Code       John Doe        2022-08-01 16:45:40.636000
```

## Requirements

For this project, you must accomplish all of the following:

1.  Navigate through a text-based menu using Standard Input and Output.
2.  Create unit tests for every method other than basic getters, setters and constructors (getters and setters with logic do require unit tests).
3.  Handle all exceptions gracefully (incorrect input should not crash the program).
4.  All data should be stored in a normalized SQL database.

### Bonus

1. Add more options that can help display more information such as **List books to be returned today**, etc.

## Important Notes

- Everyone in the squad should contribute equally to the project in time and lines of code written.
- All code must be reviewed before it is merged into the `master` branch.
- All squad members must participate in code review.
- Every com.example.library.demo.repository should have a README file with clear instructions, demo files, or any documentation needed so other teams don't have problems with the review.
- This is intended to be a challenging assignment. You will have to rely heavily on your teammates and independent research. Learning independently is a hallmark of a good developer and our job is to turn you into good developers. This process may be frustrating but you will learn a ton!
