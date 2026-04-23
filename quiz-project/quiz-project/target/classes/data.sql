INSERT INTO authors (id, name) VALUES (1, 'George Orwell');
INSERT INTO authors (id, name) VALUES (2, 'J.K. Rowling');

INSERT INTO books (id, title, author_id) VALUES (1, '1984', 1);
INSERT INTO books (id, title, author_id) VALUES (2, 'Animal Farm', 1);
INSERT INTO books (id, title, author_id) VALUES (3, 'Harry Potter', 2);

INSERT INTO departments (id, department_name) VALUES (1, 'Engineering');
INSERT INTO departments (id, department_name) VALUES (2, 'Marketing');

INSERT INTO employees (id, first_name, last_name, email, phone, salary, job_title, department_id)
VALUES (1, 'John', 'Smith', 'john@company.com', '555-0001', 75000, 'Developer', 1);

INSERT INTO employees (id, first_name, last_name, email, phone, salary, job_title, department_id)
VALUES (2, 'Jane', 'Doe', 'jane@company.com', '555-0002', 80000, 'Senior Developer', 1);

INSERT INTO employees (id, first_name, last_name, email, phone, salary, job_title, department_id)
VALUES (3, 'Bob', 'Johnson', 'bob@company.com', '555-0003', 65000, 'Marketing Manager', 2);

INSERT INTO orders (id, customer_name, status, created_at)
VALUES (1, 'John Doe', 'PENDING', '2024-01-15 10:00:00');

INSERT INTO orders (id, customer_name, status, created_at)
VALUES (2, 'JOHN SMITH', 'PENDING', '2024-02-20 11:00:00');

INSERT INTO orders (id, customer_name, status, created_at)
VALUES (3, 'Alice Brown', 'SHIPPED', '2024-03-10 09:00:00');

INSERT INTO orders (id, customer_name, status, created_at)
VALUES (4, 'johnny cash', 'PENDING', '2024-04-01 14:00:00');

INSERT INTO products (id, name, price, category)
VALUES (1, 'Laptop', 1200.00, 'Electronics');

INSERT INTO products (id, name, price, category)
VALUES (2, 'Phone', 800.00, 'Electronics');

INSERT INTO products (id, name, price, category)
VALUES (3, 'Desk', 350.00, 'Furniture');

INSERT INTO products (id, name, price, category)
VALUES (4, 'Chair', 150.00, 'Furniture');

INSERT INTO products (id, name, price, category)
VALUES (5, 'Headphones', 200.00, 'Electronics');