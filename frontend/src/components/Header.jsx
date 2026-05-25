import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { getCategories } from "../services/api";
import SearchBar from "./SearchBar";
import CategoryMenu from "./CategoryMenu";
import { useCart } from "../context/cart.jsx";
import "./Header.css";

export default function Header({
  searchText = "",
  onSearch = () => {},
  selectedCategory = "all",
  onCategorySelect = () => {},
}) {
  const [categories, setCategories] = useState([]);
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const { itemCount } = useCart();

  // ✅ user stored as JSON object
  const user = JSON.parse(localStorage.getItem("user"));

  useEffect(() => {
    async function fetchCategories() {
      try {
        const data = await getCategories();
        setCategories(data);
      } catch (err) {
        console.error("Error fetching categories:", err);
        setError("Failed to load categories");
      }
    }
    fetchCategories();
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("auth");
    localStorage.removeItem("user");
    localStorage.removeItem("jwtToken");
    navigate("/login");
  };

  return (
    <header className="header">
      <div className="header-top">
        <Link to="/" className="logo">
          KL<span>-CATALOG</span>
        </Link>

        <div className="header-search">
          <SearchBar value={searchText} onChange={onSearch} />
          {user && (
            <button
              type="button"
              className="cart-icon-btn"
              onClick={() => navigate("/cart")}
              aria-label="Open cart"
            >
              🛒
              {itemCount > 0 ? <span className="cart-badge">{itemCount}</span> : null}
            </button>
          )}
        </div>

        {user && (
          <div className="user-actions">
            <span className="username">{user.name}</span>
            <button className="logout-btn" onClick={handleLogout}>
              Logout
            </button>
          </div>
        )}
      </div>

      <div className="header-bottom">
        {error && <p className="error">{error}</p>}
        <CategoryMenu
          categories={categories}
          selected={selectedCategory}
          onSelect={onCategorySelect}
        />
      </div>
    </header>
  );
}
