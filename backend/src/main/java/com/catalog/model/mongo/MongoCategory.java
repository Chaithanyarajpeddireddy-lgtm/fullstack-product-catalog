//package com.catalog.model.mongo;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.context.annotation.Profile;
//
//@Profile("mongo")
//@Document(collection = "categories")
//public class Category {
//
//    @Id
//    private String id;
//
//    @Indexed(unique = true)
//    private String name;
//
//    public Category() {}
//
//    public Category(String name) {
//        this.name = name;
//    }
//
//    public String getId() { return id; }
//    public void setId(String id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//}


package com.catalog.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Document(collection = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoCategory {

    @Id
    private String id;

    private String name;

    private String description;

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}

	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescription(Object description2) {
		// TODO Auto-generated method stub
		
	}
}
