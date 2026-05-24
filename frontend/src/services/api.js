import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:9090/api",
});

// Attach JWT token automatically
API.interceptors.request.use((config) => {
  const token = localStorage.getItem("jwtToken");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

// ✅ Export both API and helper functions
export { API };

export async function getAllProducts() {
  const res = await API.get("/products");
  return res.data;
}

export async function getProductById(id) {
  const res = await API.get(`/products/${id}`);
  return res.data;
}

export async function getCategories() {
  const res = await API.get("/categories");
  return res.data;
}

export async function getProductsByCategory(category) {
  const res = await API.get(`/products/category/${category}`);
  return res.data;
}
