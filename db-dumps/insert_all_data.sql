-- First, insert all categories
INSERT INTO categories (name) VALUES
('Electronics'),
('Books'),
('Clothing'),
('Furniture'),
('Sports'),
('Beauty'),
('Groceries'),
('Toys'),
('Automotive'),
('Stationery')
ON CONFLICT DO NOTHING;

-- Then, insert all products with image URLs
INSERT INTO products (name, description, price, image_url, category_id) VALUES
-- Electronics
('Laptop Pro 15', 'High-performance laptop with Intel i7 and 16GB RAM', 85000, 'https://source.unsplash.com/featured/300x300/?laptop', (SELECT id FROM categories WHERE name='Electronics' LIMIT 1)),
('Wireless Headphones', 'Noise-cancelling Bluetooth headphones with 30hr battery', 8500, 'https://source.unsplash.com/featured/300x300/?headphones', (SELECT id FROM categories WHERE name='Electronics' LIMIT 1)),
('4K Webcam', 'Ultra HD webcam for streaming and video calls', 12000, 'https://source.unsplash.com/featured/300x300/?webcam', (SELECT id FROM categories WHERE name='Electronics' LIMIT 1)),
('USB-C Hub', 'Multi-port USB hub adapter with HDMI and charging', 3500, 'https://source.unsplash.com/featured/300x300/?usb-hub', (SELECT id FROM categories WHERE name='Electronics' LIMIT 1)),
('LED Monitor 27"', '4K LED display monitor with USB-C', 25000, 'https://source.unsplash.com/featured/300x300/?monitor', (SELECT id FROM categories WHERE name='Electronics' LIMIT 1)),
('Smartphone X', 'Latest flagship smartphone with 5G', 65000, 'https://source.unsplash.com/featured/300x300/?smartphone', (SELECT id FROM categories WHERE name='Electronics' LIMIT 1)),

-- Books  
('Python Programming', 'Complete Python guide for beginners and experts', 599, 'https://source.unsplash.com/featured/300x300/?python-book', (SELECT id FROM categories WHERE name='Books' LIMIT 1)),
('Database Design', 'Advanced database concepts and design patterns', 1299, 'https://source.unsplash.com/featured/300x300/?database-book', (SELECT id FROM categories WHERE name='Books' LIMIT 1)),
('Web Development', 'Full-stack web development with modern frameworks', 899, 'https://source.unsplash.com/featured/300x300/?web-development-book', (SELECT id FROM categories WHERE name='Books' LIMIT 1)),
('Data Science Handbook', 'Practical data science with Python and ML', 1199, 'https://source.unsplash.com/featured/300x300/?data-science-book', (SELECT id FROM categories WHERE name='Books' LIMIT 1)),
('Clean Code', 'Write better code with clean coding principles', 899, 'https://source.unsplash.com/featured/300x300/?programming-book', (SELECT id FROM categories WHERE name='Books' LIMIT 1)),

-- Clothing
('Cotton T-Shirt', 'Comfortable everyday 100% cotton t-shirt', 599, 'https://source.unsplash.com/featured/300x300/?t-shirt', (SELECT id FROM categories WHERE name='Clothing' LIMIT 1)),
('Denim Jeans', 'Premium denim slim-fit jeans with stretch', 1999, 'https://source.unsplash.com/featured/300x300/?jeans', (SELECT id FROM categories WHERE name='Clothing' LIMIT 1)),
('Sports Jacket', 'Waterproof athletic jacket for all seasons', 4999, 'https://source.unsplash.com/featured/300x300/?sports-jacket', (SELECT id FROM categories WHERE name='Clothing' LIMIT 1)),
('Running Shoes', 'Professional running sneakers with cushioning', 5999, 'https://source.unsplash.com/featured/300x300/?running-shoes', (SELECT id FROM categories WHERE name='Clothing' LIMIT 1)),
('Formal Shirt', 'Elegant formal shirt for office and events', 1299, 'https://source.unsplash.com/featured/300x300/?formal-shirt', (SELECT id FROM categories WHERE name='Clothing' LIMIT 1)),

-- Furniture
('Office Chair', 'Ergonomic office chair with lumbar support', 12999, 'https://source.unsplash.com/featured/300x300/?office-chair', (SELECT id FROM categories WHERE name='Furniture' LIMIT 1)),
('Standing Desk', 'Adjustable height electric standing desk', 22999, 'https://source.unsplash.com/featured/300x300/?standing-desk', (SELECT id FROM categories WHERE name='Furniture' LIMIT 1)),
('Bookshelf', 'Wooden bookshelf with 5 open shelves', 8999, 'https://source.unsplash.com/featured/300x300/?bookshelf', (SELECT id FROM categories WHERE name='Furniture' LIMIT 1)),
('Coffee Table', 'Modern glass and wood coffee table', 5999, 'https://source.unsplash.com/featured/300x300/?coffee-table', (SELECT id FROM categories WHERE name='Furniture' LIMIT 1)),

-- Sports
('Yoga Mat', 'Non-slip yoga exercise mat with carrying strap', 999, 'https://source.unsplash.com/featured/300x300/?yoga-mat', (SELECT id FROM categories WHERE name='Sports' LIMIT 1)),
('Dumbbells Set', '20kg adjustable dumbbells with stand', 4999, 'https://source.unsplash.com/featured/300x300/?dumbbells', (SELECT id FROM categories WHERE name='Sports' LIMIT 1)),
('Resistance Bands', 'Set of 5 resistance bands for workouts', 1499, 'https://source.unsplash.com/featured/300x300/?resistance-bands', (SELECT id FROM categories WHERE name='Sports' LIMIT 1)),
('Gym Bag', 'Large gym bag with compartments', 2499, 'https://source.unsplash.com/featured/300x300/?gym-bag', (SELECT id FROM categories WHERE name='Sports' LIMIT 1)),

-- Beauty
('Face Moisturizer', 'Hydrating face moisturizer for all skin types', 799, 'https://source.unsplash.com/featured/300x300/?face-moisturizer', (SELECT id FROM categories WHERE name='Beauty' LIMIT 1)),
('Shampoo Set', 'Professional hair care shampoo and conditioner', 599, 'https://source.unsplash.com/featured/300x300/?shampoo', (SELECT id FROM categories WHERE name='Beauty' LIMIT 1)),
('Makeup Kit', 'Complete makeup kit with 12 essential products', 1999, 'https://source.unsplash.com/featured/300x300/?makeup-kit', (SELECT id FROM categories WHERE name='Beauty' LIMIT 1)),

-- Groceries
('Organic Coffee', '500g premium organic coffee beans', 499, 'https://source.unsplash.com/featured/300x300/?coffee-beans', (SELECT id FROM categories WHERE name='Groceries' LIMIT 1)),
('Olive Oil', '500ml extra virgin olive oil', 1299, 'https://source.unsplash.com/featured/300x300/?olive-oil', (SELECT id FROM categories WHERE name='Groceries' LIMIT 1)),
('Almonds', '250g raw almonds pack', 399, 'https://source.unsplash.com/featured/300x300/?almonds', (SELECT id FROM categories WHERE name='Groceries' LIMIT 1)),

-- Toys
('Building Blocks Set', 'Colorful building blocks for kids', 899, 'https://source.unsplash.com/featured/300x300/?building-blocks', (SELECT id FROM categories WHERE name='Toys' LIMIT 1)),
('Action Figures', 'Set of 6 superhero action figures', 1299, 'https://source.unsplash.com/featured/300x300/?action-figures', (SELECT id FROM categories WHERE name='Toys' LIMIT 1)),
('Board Game', 'Fun family board game for all ages', 699, 'https://source.unsplash.com/featured/300x300/?board-game', (SELECT id FROM categories WHERE name='Toys' LIMIT 1)),

-- Automotive
('Car Phone Mount', 'Dashboard car phone mount holder', 499, 'https://source.unsplash.com/featured/300x300/?car-phone-mount', (SELECT id FROM categories WHERE name='Automotive' LIMIT 1)),
('Car Cleaner', 'Professional car cleaning kit', 1299, 'https://source.unsplash.com/featured/300x300/?car-cleaner', (SELECT id FROM categories WHERE name='Automotive' LIMIT 1)),
('Car Air Freshener', 'Aromatic car air freshener', 299, 'https://source.unsplash.com/featured/300x300/?car-air-freshener', (SELECT id FROM categories WHERE name='Automotive' LIMIT 1)),

-- Stationery
('Notebook Set', 'Set of 3 premium notebooks', 599, 'https://source.unsplash.com/featured/300x300/?notebook', (SELECT id FROM categories WHERE name='Stationery' LIMIT 1)),
('Pen Set', 'Set of 10 premium ball pens', 399, 'https://source.unsplash.com/featured/300x300/?pen-set', (SELECT id FROM categories WHERE name='Stationery' LIMIT 1)),
('Desk Organizer', 'Multi-compartment desk organizer', 899, 'https://source.unsplash.com/featured/300x300/?desk-organizer', (SELECT id FROM categories WHERE name='Stationery' LIMIT 1));

-- CLEANUP / RESET INSTRUCTIONS
-- If you want to clear existing data before importing this file, run one of the following commands first.
-- Option 1: Remove all rows and reset identity values
-- TRUNCATE TABLE products, categories RESTART IDENTITY CASCADE;

-- Option 2: If you need to preserve table definitions but delete all rows
-- DELETE FROM products;
-- DELETE FROM categories;
-- ALTER SEQUENCE products_id_seq RESTART WITH 1;
-- ALTER SEQUENCE categories_id_seq RESTART WITH 1;

-- Run these commands from psql after connecting to `product_catalog_db`:
--   psql -U postgres -d product_catalog_db
--   TRUNCATE TABLE products, categories RESTART IDENTITY CASCADE;

-- Then import this file cleanly:
--   psql -U postgres -d product_catalog_db -f db-dumps/insert_all_data.sql

