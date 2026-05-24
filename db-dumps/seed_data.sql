-- -- Drop old tables if they exist
-- DROP TABLE IF EXISTS product;
-- DROP TABLE IF EXISTS category;

-- -- Create tables with image URL support
-- CREATE TABLE category (
--     id SERIAL PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     image_url TEXT
-- );

-- CREATE TABLE product (
--     id SERIAL PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     description TEXT,
--     price NUMERIC(10,2),
--     image_url TEXT,
--     category_id INT REFERENCES category(id) ON DELETE CASCADE
-- );

-- -- Insert categories with image URLs
-- INSERT INTO category (id, name, image_url) VALUES
-- (1, 'Electronics', 'https://upload.wikimedia.org/wikipedia/commons/3/3a/Electronics_icon.png'),
-- (2, 'Books', 'https://upload.wikimedia.org/wikipedia/commons/1/14/Books_icon.png'),
-- (3, 'Clothing', 'https://upload.wikimedia.org/wikipedia/commons/7/7e/Clothing_icon.png'),
-- (4, 'Furniture', 'https://upload.wikimedia.org/wikipedia/commons/6/6d/Furniture_icon.png'),
-- (5, 'Sports', 'https://upload.wikimedia.org/wikipedia/commons/4/4f/Sports_icon.png'),
-- (6, 'Beauty', 'https://upload.wikimedia.org/wikipedia/commons/2/2f/Beauty_icon.png'),
-- (7, 'Groceries', 'https://upload.wikimedia.org/wikipedia/commons/9/9e/Groceries_icon.png'),
-- (8, 'Toys', 'https://upload.wikimedia.org/wikipedia/commons/5/5a/Toys_icon.png'),
-- (9, 'Automotive', 'https://upload.wikimedia.org/wikipedia/commons/8/8f/Automotive_icon.png'),
-- (10, 'Stationery', 'https://upload.wikimedia.org/wikipedia/commons/2/2c/Stationery_icon.png');

-- -- Insert products with official image URLs
-- INSERT INTO product (name, description, price, image_url, category_id) VALUES
-- ('Laptop', 'ASUS Zenbook 14-inch', 75000, 'https://dlcdnwebimgs.asus.com/files/media/zenbook14.jpg', 1),
-- ('Smartphone', 'Samsung Galaxy S24', 65000, 'https://images.samsung.com/is/image/samsung/p6pim/in/galaxy-s24.jpg', 1),
-- ('Headphones', 'Sony WH-1000XM5', 25000, 'https://www.sony.com/image/wh1000xm5.jpg', 1),
-- ('Smartwatch', 'Apple Watch Series 9', 40000, 'https://store.storeimages.cdn-apple.com/apple-watch-series9.jpg', 1),
-- ('Bluetooth Speaker', 'JBL Flip 6', 12000, 'https://www.jbl.com/flip6.jpg', 1),

-- ('Novel', 'Fiction bestseller', 500, 'https://images-na.ssl-images-amazon.com/fiction-novel.jpg', 2),
-- ('Textbook', 'Database Systems Engineering', 1200, 'https://images-na.ssl-images-amazon.com/database-textbook.jpg', 2),
-- ('Comics', 'Marvel Avengers Collection', 800, 'https://www.marvel.com/comics/avengers.jpg', 2),
-- ('Biography', 'Life of A.P.J Abdul Kalam', 600, 'https://images-na.ssl-images-amazon.com/apj-biography.jpg', 2),
-- ('Cookbook', 'Indian Recipes', 700, 'https://images-na.ssl-images-amazon.com/indian-cookbook.jpg', 2),

-- ('T-Shirt', 'Cotton casual wear', 800, 'https://static.nike.com/tshirt.jpg', 3),
-- ('Jeans', 'Denim slim fit', 2000, 'https://levi.com/denim-jeans.jpg', 3),
-- ('Jacket', 'Leather biker jacket', 5000, 'https://zara.com/leather-jacket.jpg', 3),
-- ('Sneakers', 'Nike Air Max', 6000, 'https://static.nike.com/airmax.jpg', 3),
-- ('Formal Shirt', 'Raymond slim fit', 1500, 'https://raymond.in/formal-shirt.jpg', 3);

-- -- (Continue for categories 4–10 with official brand images)
