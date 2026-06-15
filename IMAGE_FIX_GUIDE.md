# Image Fix and Database Population Guide

## Problem Summary
The webpage images were not visible because:
1. **Database was empty** - The products table had no data
2. **Missing image URLs** - Products without image_url values couldn't display images
3. **No fallback handling** - The frontend had no error handling for missing images

## Solution Implemented

### 1. Created Product Data with Image URLs
Created two SQL scripts to populate the database:

#### Script 1: `insert_all_data.sql` (Recommended)
This is the main script that:
- Inserts all 10 categories (Electronics, Books, Clothing, Furniture, Sports, Beauty, Groceries, Toys, Automotive, Stationery)
- Inserts 40+ sample products with image URLs
- Uses placeholder images from `via.placeholder.com`

#### Script 2: `populate_products.sql` (Alternative)
A simpler script with basic product data.

### 2. Added Image Fallback Component
Created `ImageFallback.jsx` component that:
- Automatically shows a placeholder image if the image URL fails to load
- Handles missing or broken image links gracefully
- Provides visual feedback with a fallback image

### 3. Updated Components
Updated these components to use ImageFallback:
- `ProductCard.jsx` - Shows product thumbnail images
- `ProductDetailPage.jsx` - Shows large product images
- `Banner.jsx` - Shows ad banner images

## How to Apply the Fix

### Step 1: Execute the SQL Script to Populate Database

#### Using pgAdmin or SQL Client:
1. Open pgAdmin or your PostgreSQL client
2. Connect to the `product_catalog_db` database
3. Open the SQL editor
4. Copy and paste the contents of `db-dumps/insert_all_data.sql`
5. Execute the script

#### Using Command Line (psql):
```bash
cd backend
psql -U postgres -d product_catalog_db -f ../db-dumps/insert_all_data.sql
```

### Step 2: Verify the Data was Inserted
```sql
SELECT COUNT(*) as total_products FROM products;
SELECT COUNT(*) as total_categories FROM categories;
```

### Step 3: Restart the Backend
```bash
# If backend is running, stop it (Ctrl+C) and restart
mvn spring-boot:run
```

### Step 4: Check the Frontend
1. Go to `http://localhost:5173` (or your frontend URL)
2. Images should now be visible with the placeholder images
3. If you update the product image URLs with real images, those will display instead

## Using Real Images

To use real product images instead of placeholder images:

1. **Option A: Update via Database**
   ```sql
   UPDATE products 
   SET image_url = 'https://your-real-image-url.com/image.jpg'
   WHERE id = 1;
   ```

2. **Option B: Update via Product CRUD API**
   Use the `/api/products/{id}` PUT endpoint to update product with real image URLs

## Testing the Image System

1. **Test with Placeholder Images** (already configured)
   - Images will display using placeholder.com images

2. **Test Fallback Functionality**
   - Try changing an image URL to an invalid URL
   - The ImageFallback component will automatically show a placeholder

3. **Test with Real Images**
   - Update some products with real image URLs
   - Images will display if URLs are valid

## Database Schema Reference

### Products Table
```
id (BIGINT) - Primary Key
name (VARCHAR) - Product name
description (VARCHAR) - Product description  
price (DOUBLE) - Product price in ₹
image_url (VARCHAR) - URL to product image
category_id (BIGINT) - Foreign key to categories table
```

### Categories Table
```
id (BIGINT) - Primary Key
name (VARCHAR) - Category name
```

## Files Modified
- `frontend/src/components/ImageFallback.jsx` - New component
- `frontend/src/components/ImageFallback.css` - New stylesheet
- `frontend/src/components/ProductCard.jsx` - Updated to use ImageFallback
- `frontend/src/components/Banner.jsx` - Updated to use ImageFallback
- `frontend/src/pages/ProductDetailPage.jsx` - Updated to use ImageFallback
- `db-dumps/insert_all_data.sql` - New database script
- `db-dumps/populate_products.sql` - Alternative database script

## Troubleshooting

### Images Still Not Showing?
1. Check browser console (F12) for errors
2. Verify database query: `SELECT COUNT(*) FROM products;`
3. Ensure backend is running on port 9090
4. Clear browser cache (Ctrl+Shift+Delete)
5. Restart both frontend and backend

### Placeholder Images Not Loading?
- `via.placeholder.com` requires internet connection
- If offline, images will show as broken
- You can replace placeholder URLs with your own images

### Database Script Errors?
- Ensure PostgreSQL is running
- Check database connection in `application.properties`
- Verify table structure matches the schema above
- Run `SELECT * FROM information_schema.tables WHERE table_name = 'products';` to verify table exists
