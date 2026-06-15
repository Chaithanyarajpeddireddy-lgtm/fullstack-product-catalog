//package com.catalog.model.mongo;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.context.annotation.Profile;
//
//@Profile("mongo")
//@Document(collection = "products")
//public class Product {
//
//    @Id
//    private String id;
//
//    private String name;
//    private String description;
//    private Double price;
//    private String imageUrl;
//
//    // Category is embedded as a name string — no join needed in MongoDB
//    @Indexed
//    private String categoryName;
//
//    public Product() {}
//
//    public Product(String name, String description, Double price, String imageUrl, String categoryName) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.imageUrl = imageUrl;
//        this.categoryName = categoryName;
//    }
//
//    public String getId() { return id; }
//    public void setId(String id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getDescription() { return description; }
//    public void setDescription(String description) { this.description = description; }
//
//    public Double getPrice() { return price; }
//    public void setPrice(Double price) { this.price = price; }
//
//    public String getImageUrl() { return imageUrl; }
//    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
//
//    public String getCategoryName() { return categoryName; }
//    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
//}

//package com.catalog.model.mongo;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//
//@Document(collection = "products")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class MongoProduct {
//
//    @Id
//    private String id;
//
//    private String name;
//
//    private String description;
//
//    private Double price;
//
//    private Integer stock;
//
//    // Embedded category name — no joins needed in MongoDB
//    private String categoryName;
//
//	public Object getId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Object getName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setName(Object name2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getDescription() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setDescription(Object description2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setPrice(Object name2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getStock() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setStock(Object stock2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getCategoryName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setCategoryName(Object categoryName2) {
//		// TODO Auto-generated method stub
//		
//	}
//}


package com.catalog.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;  // ✅ missing import

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoProduct {

    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String categoryName;
    private String imageUrl;  // ✅ added so frontend can display images
}
