-- Insert sample products with image URLs
-- Using relevant Unsplash images for each product

INSERT INTO products (name, description, price, image_url, category_id) VALUES
-- Electronics (Category 1)
('Laptop Pro 15', 'High-performance laptop with Intel i7', 85000, 'https://source.unsplash.com/featured/300x300/?laptop', 1),
('Wireless Headphones', 'Noise-cancelling Bluetooth headphones', 8500, 'https://source.unsplash.com/featured/300x300/?headphones', 1),
('4K Webcam', 'Ultra HD webcam for streaming', 12000, 'https://source.unsplash.com/featured/300x300/?webcam', 1),
('USB-C Hub', 'Multi-port USB hub adapter', 3500, 'https://source.unsplash.com/featured/300x300/?usb-hub', 1),
('LED Monitor 27"', '4K LED display monitor', 25000, 'https://source.unsplash.com/featured/300x300/?monitor', 1),

-- Books (Category 2)
('Python Programming', 'Complete Python guide for beginners', 599, 'https://source.unsplash.com/featured/300x300/?python-book', 2),
('Database Design', 'Advanced database concepts and design patterns', 1299, 'https://source.unsplash.com/featured/300x300/?database-book', 2),
('Web Development', 'Full-stack web development guide', 899, 'https://source.unsplash.com/featured/300x300/?web-development-book', 2),
('Data Science Handbook', 'Practical data science with Python', 1199, 'https://source.unsplash.com/featured/300x300/?data-science-book', 2),

-- Clothing (Category 3)
('Cotton T-Shirt', 'Comfortable everyday cotton t-shirt', 599, 'https://source.unsplash.com/featured/300x300/?t-shirt', 3),
('Denim Jeans', 'Premium denim slim-fit jeans', 1999, 'https://source.unsplash.com/featured/300x300/?jeans', 3),
('Sports Jacket', 'Waterproof athletic jacket', 4999, 'https://source.unsplash.com/featured/300x300/?sports-jacket', 3),
('Running Shoes', 'Comfortable running sneakers', 5999, 'https://source.unsplash.com/featured/300x300/?running-shoes', 3),

-- Furniture (Category 4)
('Office Chair', 'Ergonomic office chair with lumbar support', 12999, 'https://source.unsplash.com/featured/300x300/?office-chair', 4),
('Standing Desk', 'Adjustable height standing desk', 22999, 'https://source.unsplash.com/featured/300x300/?standing-desk', 4),
('Bookshelf', 'Wooden bookshelf with 5 shelves', 8999, 'https://source.unsplash.com/featured/300x300/?bookshelf', 4),

-- Sports (Category 5)
('Yoga Mat', 'Non-slip yoga exercise mat', 999, 'https://source.unsplash.com/featured/300x300/?yoga-mat', 5),
('Dumbbells Set', '20kg adjustable dumbbells', 4999, 'https://source.unsplash.com/featured/300x300/?dumbbells', 5),
('Resistance Bands', 'Set of 5 resistance bands', 1499, 'https://source.unsplash.com/featured/300x300/?resistance-bands', 5);

-- Display the inserted products
SELECT id, name, price, image_url, category_id FROM products ORDER BY id;
