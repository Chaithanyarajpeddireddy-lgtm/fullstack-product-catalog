import { useEffect, useReducer, useState } from "react";
import Header from "../components/Header";
import Banner from "../components/Banner";
import ProductCard from "../components/ProductCard";
import Loader from "../components/Loader";
import Footer from "../components/Footer";
import { getAllProducts, getProductsByCategory, getCategories } from "../services/api";
import "./HomePage.css";

const initialState = {
  products: [],
  loading: true,
  error: null,
  searchText: "",
  selectedCategory: "all",
};

function reducer(state, action) {
  switch (action.type) {
    case "SET_LOADING":
      return { ...state, loading: action.payload };
    case "SET_PRODUCTS":
      return { ...state, products: action.payload };
    case "SET_ERROR":
      return { ...state, error: action.payload };
    case "SET_SEARCH":
      return { ...state, searchText: action.payload };
    case "SET_CATEGORY":
      return { ...state, selectedCategory: action.payload };
    default:
      return state;
  }
}

export default function HomePage() {
  const [state, dispatch] = useReducer(reducer, initialState);
  const [categories, setCategories] = useState([]);
  const { products, loading, error, searchText, selectedCategory } = state;

  useEffect(() => {
    async function fetchCategories() {
      try {
        const data = await getCategories();
        setCategories(Array.isArray(data) ? data : []);
      } catch {
        console.error("Failed to load categories");
      }
    }
    fetchCategories();
  }, []);

  useEffect(() => {
    async function fetchProducts() {
      dispatch({ type: "SET_LOADING", payload: true });
      try {
        const data =
          selectedCategory === "all"
            ? await getAllProducts()
            : await getProductsByCategory(selectedCategory);
        dispatch({ type: "SET_PRODUCTS", payload: Array.isArray(data) ? data : [] });
      } catch {
        dispatch({ type: "SET_ERROR", payload: "Failed to load products." });
      } finally {
        dispatch({ type: "SET_LOADING", payload: false });
      }
    }
    fetchProducts();
  }, [selectedCategory]);

  const filteredProducts = products.filter((p) =>
    (p.name || p.title).toLowerCase().includes(searchText.toLowerCase())
  );

  return (
    <>
      <Header
        searchText={searchText}
        onSearch={(text) => dispatch({ type: "SET_SEARCH", payload: text })}
        selectedCategory={selectedCategory}
        onCategorySelect={(cat) => dispatch({ type: "SET_CATEGORY", payload: cat })}
      />

      <Banner />

      <div className="category-filter">
        <button
          className={`filter-btn ${selectedCategory === "all" ? "active" : ""}`}
          onClick={() => dispatch({ type: "SET_CATEGORY", payload: "all" })}
        >
          All
        </button>
        {categories.map((cat) => (
          <button
            key={cat.id}
            className={`filter-btn ${selectedCategory === cat.name ? "active" : ""}`}
            onClick={() => dispatch({ type: "SET_CATEGORY", payload: cat.name })}
          >
            {cat.name}
          </button>
        ))}
      </div>

      {loading && <Loader />}
      {error && <div className="error-message">{error}</div>}

      {!loading && !error && (
        <div className="product-grid">
          {filteredProducts.length ? (
            filteredProducts.map((product) => (
              <ProductCard key={product.id} product={product} />
            ))
          ) : (
            <p>No products found</p>
          )}
        </div>
      )}

      <Footer />
    </>
  );
}
