import React from "react";

const BookDetails = () => {
  const books = [
    { id: 1, title: "React Guide", author: "Ankit" },
    { id: 2, title: "Mastering JSX", author: "Ravi" },
  ];

  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            {book.title} by <strong>{book.author}</strong>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookDetails;
