-- Categories
INSERT INTO categories (name, description) VALUES ('Fiction', 'Fictional literature and novels');
INSERT INTO categories (name, description) VALUES ('Science', 'Science and technology books');
INSERT INTO categories (name, description) VALUES ('History', 'Historical books and biographies');

-- Authors
INSERT INTO authors (first_name, last_name, biography) VALUES ('George', 'Orwell', 'English novelist and essayist');
INSERT INTO authors (first_name, last_name, biography) VALUES ('J.K.', 'Rowling', 'British author of Harry Potter series');
INSERT INTO authors (first_name, last_name, biography) VALUES ('Stephen', 'Hawking', 'Theoretical physicist and cosmologist');
INSERT INTO authors (first_name, last_name, biography) VALUES ('Yuval Noah', 'Harari', 'Israeli historian and author');

-- Books
INSERT INTO books (title, isbn, published_year, available_copies, category_id) VALUES ('1984', '978-0-452-28423-4', 1949, 3, 1);
INSERT INTO books (title, isbn, published_year, available_copies, category_id) VALUES ('Animal Farm', '978-0-452-28424-1', 1945, 2, 1);
INSERT INTO books (title, isbn, published_year, available_copies, category_id) VALUES ('A Brief History of Time', '978-0-553-38016-3', 1988, 2, 2);
INSERT INTO books (title, isbn, published_year, available_copies, category_id) VALUES ('Sapiens', '978-0-062-31609-7', 2011, 4, 3);
INSERT INTO books (title, isbn, published_year, available_copies, category_id) VALUES ('Harry Potter and the Philosopher''s Stone', '978-0-590-35340-3', 1997, 5, 1);

-- Book Authors
INSERT INTO book_authors (book_id, author_id) VALUES (1, 1);
INSERT INTO book_authors (book_id, author_id) VALUES (2, 1);
INSERT INTO book_authors (book_id, author_id) VALUES (3, 3);
INSERT INTO book_authors (book_id, author_id) VALUES (4, 4);
INSERT INTO book_authors (book_id, author_id) VALUES (5, 2);

-- Members
INSERT INTO members (first_name, last_name, email, phone, membership_date) VALUES ('Alice', 'Smith', 'alice.smith@example.com', '555-0101', '2024-01-15');
INSERT INTO members (first_name, last_name, email, phone, membership_date) VALUES ('Bob', 'Johnson', 'bob.johnson@example.com', '555-0102', '2024-02-20');
INSERT INTO members (first_name, last_name, email, phone, membership_date) VALUES ('Carol', 'Williams', 'carol.williams@example.com', '555-0103', '2024-03-10');
