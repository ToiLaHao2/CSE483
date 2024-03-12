//Database layer

let books = [
    {
        title: "book 1",
        author: "author 1",
        genre: "horror",
        availableQuantity: 12,
    },
    {
        title: "book 2",
        author: "author 2",
        genre: "action",
        availableQuantity: 10,
    },
    {
        title: "book 3",
        author: "author 3",
        genre: "comedy",
        availableQuantity: 3,
    },
    {
        title: "book 4",
        author: "author 4",
        genre: "horror",
        availableQuantity: 14,
    },
    {
        title: "book 5",
        author: "author 5",
        genre: "horror",
        availableQuantity: 20,
    },
];
let borrowers = [
    {
        name: "John Doe",
        address: "New York",
        email: "123@.com",
        phoneNumber: "+123456789",
        listBooksBorrowed: [],
    },
    {
        name: "Jane Smith",
        address: "New York",
        email: "123@.com",
        phoneNumber: "+123456789",
        listBooksBorrowed: [],
    },
];
let records = [
    {
        borrowerName: "John Doe",
        bookTitle: "book 1",
    },
    {
        borrowerName: "Jane",
        bookTitle: "Book 2",
    },
];

//Business layer
function loadBook() {
    let str = "";
    for (let book of books) {
        str += `<tr id="item">
                    <td id="${book.title}">${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
                    <td>${book.availableQuantity}</td>
                    <td><button id="remove-book">x</button></td>
                </tr>
        `;
    }
    document.getElementById("contents").innerHTML = str;
}
function loadRecord() {
    let str = "";
    for (let record of records) {
        str += `<div>
                    <p>${record.borrowerName} borrow ${record.bookTitle} </p>
                </div>
        `;
    }
    document.getElementById("recordContents").innerHTML = str;
}
function addBook(title, author, genre, availableQuantity) {
    let newBook = { title, author, genre, availableQuantity };
    books.push(newBook);
    loadBook();
}
function removeBook(title) {
    let i = 0;
    while (i < books.length) {
        if (books[i].title == title) {
            books.splice(i, 1);
        } else {
            i++;
        }
    }
    books = books.filter((book) => book.title !== title);
    loadBook();
}
function borrowBook(nameOfBorrower, title, numberOfBook) {
    let i = 0;
    for (let index = 0; index < books.length; index++) {
        if (books[i].title == title) {
            if (books[i].availableQuantity > 0) {
                books[i].availableQuantity -= numberOfBook;
                alert(title + " has been successfully borrowed!");
                loadBook();
                records.push({
                    borrowerName: nameOfBorrower,
                    bookTitle: title,
                });
                break;
            }
        }
    }
    loadRecord();
}
