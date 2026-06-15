////package com.catalog.model.mongo;
////
////import org.springframework.data.annotation.Id;
////import org.springframework.data.mongodb.core.mapping.Document;
////import org.springframework.data.mongodb.core.index.Indexed;
////import org.springframework.context.annotation.Profile;
////
////import java.util.ArrayList;
////import java.util.List;
////
////@Profile("mongo")
////@Document(collection = "carts")
////public class Cart {
////
////    @Id
////    private String id;
////
////    // Indexed so we can quickly find a cart by user
////    @Indexed(unique = true)
////    private String userId;
////
////    // Products are embedded directly — no join table, no foreign key
////    private List<Product> products = new ArrayList<>();
////
////    public String getId() { return id; }
////    public void setId(String id) { this.id = id; }
////
////    public String getUserId() { return userId; }
////    public void setUserId(String userId) { this.userId = userId; }
////
////    public List<Product> getProducts() { return products; }
////    public void setProducts(List<Product> products) { this.products = products; }
////}
//
//
//package com.catalog.model.mongo;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Document(collection = "carts")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class MongoCart {
//
//    @Id
//    private String id;
//
//    private String userId;
//
//    // Embedded product list — no join table needed in MongoDB
//    private List<MongoProduct> products = new ArrayList<>();
//
//    public void setName(Double name) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setName'");
//    }
//
//    public void setDescription(String description) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setDescription'");
//    }
//
//    public void setStock(Integer stock) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setStock'");
//    }
//
//    public void setCategoryName(String categoryName) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setCategoryName'");
//    }
//
//	public Collection<? extends MongoProduct> getProducts() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setUserId(String userId2) {
//		// TODO Auto-generated method stub
//		
//	}
//}


//
//package com.catalog.model.mongo;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Document(collection = "carts")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class MongoCart {
//
//    @Id
//    private String id;
//
//    private String userId;
//
//    private List<MongoProduct> products = new ArrayList<>();
//}


//
//package com.catalog.model.mongo;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Document(collection = "carts")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class MongoCart {
//
//    @Id
//    private String id;
//
//    private String userId;
//
//    private List<MongoProduct> products = new ArrayList<>();
//
//	public void setUserId(String userId2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getProducts() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}





package com.catalog.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoCart {

    @Id
    private String id;

    private String userId;

    private List<MongoProduct> products = new ArrayList<>();

}

