Bridge Pattern E-Book Example 📖
This project provides a simple and clear demonstration of the Bridge Design Pattern using an E-Book Reader as a real-world analogy. It shows how to decouple an abstraction from its implementation so that the two can vary independently.

Project Overview
In this e-book reader system, we have two distinct concepts:

The type of book (e.g., Novel, Textbook, Comic).

The file format it's rendered in (e.g., PDF, EPUB, MOBI).

The Bridge Pattern allows us to separate these two hierarchies. This means we can add a new book type without worrying about the existing formats, and we can add a new file format without changing any of the book type classes.

This avoids a combinatorial explosion of classes. Instead of creating specific classes like PDFNovel, EPUBTextbook, or MOBIComic, we "bridge" the two hierarchies together at runtime.

Abstraction: The EBook class hierarchy (Novel, Textbook, Comic).

Implementation: The Format interface hierarchy (PDFFormat, EPUBFormat, MOBIFormat).

Folder Structure
The project is structured without a src folder for simplicity:
```
Structural-pattern/
bridge-ebook/
├── com/example/ebook/
│   ├── ReaderApp.java (main file)
│   ├── EBook.java
│   ├── Novel.java
│   ├── Textbook.java
│   ├── Comic.java
│   ├── Format.java
│   ├── PDFFormat.java
│   ├── EPUBFormat.java
│   ├── MOBIFormat.java
│   └── InMemoryLogger.java  
└── README.md
```
How to Compile & Run
Follow these simple steps from the project's root directory (bridge-ebook/).
```
cd Structural-pattern/bridge-ebook
```


Step 1: Navigate to the Project Root
Open your terminal or command prompt and navigate into the bridge-ebook directory.

Step 2: Compile the Java Files
Compile all the .java files using the following command:


```
javac com/example/ebook/*.java
```
Step 3: Run the Application
Execute the main application class:

```

java com.example.ebook.ReaderApp
```
Example Run
When you run the application, you'll be prompted to choose a book type and format. Here is an example of what you'll see:
```
[INFO] 2025-10-01 20:03:16 - E-Book Reader started.
=== E-Book Reader (Bridge Pattern Demo) ===

Choose book type: 1) Novel  2) Textbook  3) Comic  4) Exit
1
Enter book title: The Little boy
Choose format: 1) PDF  2) EPUB  3) MOBI
1
[INFO] 2025-10-01 20:03:31 - Reading book: The Little boy as PDFFormat
Reading novel... Opening PDF book: The Little boy

Choose book type: 1) Novel  2) Textbook  3) Comic  4) Exit
2
Enter book title: OS 
Choose format: 1) PDF  2) EPUB  3) MOBI
2
[INFO] 2025-10-01 20:03:43 - Reading book: OS as EPUBFormat
Studying textbook... Opening EPUB book: OS

Choose book type: 1) Novel  2) Textbook  3) Comic  4) Exit
3
Enter book title: The superman
Choose format: 1) PDF  2) EPUB  3) MOBI
3
[INFO] 2025-10-01 20:03:57 - Reading book: The superman as MOBIFormat
Enjoying comic... Opening MOBI book: The superman

Choose book type: 1) Novel  2) Textbook  3) Comic  4) Exit
4
[INFO] 2025-10-01 20:04:00 - User requested exit.
[INFO] 2025-10-01 20:04:00 - E-Book Reader terminated.
Goodbye!

=== Log History ===
[INFO] 2025-10-01 20:03:16 - E-Book Reader started.
[INFO] 2025-10-01 20:03:31 - Reading book: The Little boy as PDFFormat
[INFO] 2025-10-01 20:03:43 - Reading book: OS as EPUBFormat
[INFO] 2025-10-01 20:03:57 - Reading book: The superman as MOBIFormat
[INFO] 2025-10-01 20:04:00 - User requested exit.
[INFO] 2025-10-01 20:04:00 - E-Book Reader terminated.
```
How the Bridge Pattern is Applied
The pattern is applied by creating a compositional link between the EBook abstraction and the Format implementation.

The abstract EBook class holds a reference to a Format object.

Concrete book types like Novel, Textbook, and Comic extend EBook.

The Format interface is implemented by concrete formats like PDFFormat, EPUBFormat, and MOBIFormat.

UML-like Structure
This relationship can be visualized as a bridge between the two hierarchies:
```
EBook (Abstraction) ----------------------> Format (Implementation)
   ↑                                           ↑
   |                                           |
+---------------------+           +--------------------------+
| Novel, Textbook, Comic |          | PDFFormat, EPUBFormat, MOBIFormat |
+---------------------+           +--------------------------+
```
Key Benefits ✨
This design provides significant advantages:

Flexibility: You can add new book types without touching the format code.

Scalability: You can add new file formats without altering the book type code.

Decoupling: It breaks the strong inheritance link between the book's interface (EBook) and its platform-specific implementation (Format), promoting cleaner, more maintainable code.