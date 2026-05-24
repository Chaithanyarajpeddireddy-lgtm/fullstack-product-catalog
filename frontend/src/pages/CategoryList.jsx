import React, { useEffect, useState } from "react";
import axios from "axios";

export default function CategoryList() {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem("jwtToken");
    axios.get("http://localhost:9090/api/categories", {
      headers: { Authorization: `Bearer ${token}` }
    }).then(res => setCategories(res.data));
  }, []);

  return (
    <div>
      <h2>Categories</h2>
      <ul>
        {categories.map(c => (
          <li key={c.id}>{c.name}</li>
        ))}
      </ul>
    </div>
  );
}
