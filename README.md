+-----------------------------+
|           Book              |
+-----------------------------+
| - isbn: String              |
| - title: String             |
| - author: String            |
| - status: BookStatus        |
| - borrowCount: Integer      |
| - publicationYear: int      |
+-----------------------------+
| + getIsbn(): String         |
| + getTitle(): String        |
| + getAuthor(): String       |
| + getStatus(): BookStatus   |
| + getBorrowCount(): Integer |
| + incrementBorrowCount()    |
+-----------------------------+

            1
            |
            |
            |
          * |
+-----------------------------+
|           History           |
+-----------------------------+
| - book: Book                |
| - borrowDate: LocalDate     |
| - dueDate: LocalDate        |
| - returnDate: LocalDate     |
| - status: HistoryStatus     |
+-----------------------------+
| + isOverdue(): boolean      |
| + markReturned()            |
+-----------------------------+

            1
            |
            |
            |
          * |
+-----------------------------+
|          Patron             |
+-----------------------------+
| - id: String                |
| - name: String              |
| - email: String             |
| - patronBorrowingHistory:   |
|     List<History>           |
+-----------------------------+
| + addHistory(h: History)    |
| + borrowCount(): int        |
| + overdueCount(): int       |
+-----------------------------+

+-----------------------------+
|       BookService           |
+-----------------------------+
| - bookMap: Map<String,Book> |
+-----------------------------+
| + addBook(book: Book)       |
| + deleteBook(id: String)    |
| + returnbookById(id: String): Book |
| ...                         |
+-----------------------------+

+-----------------------------+
|      PatronService          |
+-----------------------------+
| - patronMap: Map<String,Patron> |
+-----------------------------+
| + addPatron(...)            |
| + deletePatron(...)         |
| + returnPatronById(...)     |
| ...                         |
+-----------------------------+

+-----------------------------+
|      LibraryService         |
+-----------------------------+
| - bookService: BookService  |
| - patronService: PatronService |
+-----------------------------+
| + borrowBook(...)           |
| + returnBook(...)           |
+-----------------------------+
