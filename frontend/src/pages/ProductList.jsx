import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom"; // ✅ added for navigation
import "./ProductList.css";

export default function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem("jwtToken");
    axios
      .get("http://localhost:9090/api/products", {
        headers: { Authorization: `Bearer ${token}` },
      })
      .then((res) => setProducts(res.data))
      .catch((err) => console.error("Failed to load products", err));
  }, []);

  return (
    <div className="product-list">
      <h2>All Products</h2>
      <table className="product-table">
        <thead>
          <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price (₹)</th>
            <th>Category</th>
          </tr>
        </thead>
        <tbody>
          {products.map((p) => (
            <tr key={p.id}>
              <td>
                <img
                  src={p.imageUrl || p.image_url}
                  alt={p.name}
                  className="product-thumb"
                />
              </td>
              {/* ✅ Clicking name goes to detail page */}
              <td>
                <Link to={`/product/${p.id}`} className="product-link">
                  {p.name}
                </Link>
              </td>
              <td>{p.description}</td>
              <td>{p.price}</td>
              <td>{p.category_name || p.category_id}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
