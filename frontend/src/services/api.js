// import axios from "axios";

// const API = axios.create({
//   baseURL: "http://localhost:9090/api",
// });

// // Attach JWT token automatically
// API.interceptors.request.use((config) => {
//   const token = localStorage.getItem("jwtToken");
//   if (token) {
//     config.headers.Authorization = `Bearer ${token}`;
//   }
//   return config;
// });

// export { API };

// export async function getAllProducts() {
//   const res = await API.get("/products");
//   return res.data;
// }

// export async function getProductById(id) {
//   const res = await API.get(`/products/${id}`);
//   return res.data;
// }

// export async function getCategories() {
//   const res = await API.get("/categories");
//   return res.data;
// }

// export async function getProductsByCategory(categoryId) {
//   const res = await API.get(`/products/category/${categoryId}`);
//   return res.data;
// }



// import axios from "axios";

// const API_BASE = "http://localhost:9090/api";

// // ✅ Create axios instance
// const api = axios.create({
//   baseURL: API_BASE,
// });

// // ✅ Attach token if available
// api.interceptors.request.use((config) => {
//   const token = localStorage.getItem("jwtToken");
//   if (token) {
//     config.headers.Authorization = `Bearer ${token}`;
//   }
//   return config;
// });

// // ✅ Products
// export const getAllProducts = async () => {
//   const res = await api.get("/products");
//   return res.data;
// };

// export const getProductById = async (id) => {
//   const res = await api.get(`/products/${id}`);
//   return res.data;
// };

// export const getProductsByCategory = async (categoryName) => {
//   const res = await api.get(`/products/category/${categoryName}`);
//   return res.data;
// };

// // ✅ Categories
// export const getCategories = async () => {
//   const res = await api.get("/categories");
//   return res.data;
// };

// // ✅ Auth
// export const login = async (username, password) => {
//   const res = await api.post("/auth/login", { username, password });
//   return res.data;
// };

// export const register = async (user) => {
//   const res = await api.post("/auth/register", user);
//   return res.data;
// };




// services/api.js
import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:9090/api",
});

API.interceptors.request.use((config) => {
  const token = localStorage.getItem("jwtToken");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

// Export the instance
export { API };

// Export helper functions
export const getAllProducts = async () => {
  const res = await API.get("/products");
  return res.data;
};

export const getProductById = async (id) => {
  const res = await API.get(`/products/${id}`);
  return res.data;
};

export const getProductsByCategory = async (categoryName) => {
  const res = await API.get(`/products/category/${categoryName}`);
  return res.data;
};

export const getCategories = async () => {
  const res = await API.get("/categories");
  return res.data;
};
