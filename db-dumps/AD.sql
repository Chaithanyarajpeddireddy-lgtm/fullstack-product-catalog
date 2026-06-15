-- Show all usernames
SELECT username FROM users;

-- Show usernames and passwords
SELECT username, password FROM users;

-- Show usernames with their roles
SELECT username, role FROM users;



-- Show all products
SELECT id, name, description, price FROM products;

-- Show products with their category names
SELECT p.name AS product_name, p.price, c.name AS category_name
FROM products p
JOIN categories c ON p.category_id = c.id;

-- Show products more expensive than 500
SELECT name, price FROM products WHERE price > 500;

-- Count how many products per category
SELECT c.name AS category_name, COUNT(p.id) AS product_count
FROM products p
JOIN categories c ON p.category_id = c.id
GROUP BY c.name;



-- Show all categories
SELECT id, name FROM categories;

-- Show categories with at least 2 products
SELECT c.name, COUNT(p.id) AS product_count
FROM categories c
JOIN products p ON c.id = p.category_id
GROUP BY c.name
HAVING COUNT(p.id) >= 2;
