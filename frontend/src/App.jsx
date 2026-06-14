
// import React, { useState } from "react";
// import { Routes, Route, Navigate } from "react-router-dom";
// import HomePage from "./pages/HomePage";
// import ProductDetailPage from "./pages/ProductDetailPage";
// import CartPage from "./pages/CartPage";
// import CategoryList from "./pages/CategoryList";
// import ProductList from "./pages/ProductList";
// import LoginPage from "./pages/LoginPage";

// function App() {
//   const [isAuthenticated, setIsAuthenticated] = useState(
//     localStorage.getItem("auth") === "true"
//   );

//   return (
//     <Routes>
//       {/* ✅ Default route always goes to LoginPage */}
//       <Route
//         path="/"
//         element={<Navigate to="/login" replace />}
//       />

//       {/* Login */}
//       <Route
//         path="/login"
//         element={<LoginPage setIsAuthenticated={setIsAuthenticated} />}
//       />

//       {/* Home */}
//       <Route
//         path="/home"
//         element={isAuthenticated ? <HomePage /> : <Navigate to="/login" replace />}
//       />

//       {/* Product details */}
//       <Route
//         path="/product/:id"
//         element={isAuthenticated ? <ProductDetailPage /> : <Navigate to="/login" replace />}
//       />

//       {/* Cart */}
//       <Route
//   path="/cart"
//   element={
//     isAuthenticated &&
//     JSON.parse(localStorage.getItem("user"))?.role === "ROLE_CUSTOMER"
//       ? <CartPage />
//       : <Navigate to="/home" replace />
//   }
// />

//       {/* Categories */}
//       <Route
//         path="/categories"
//         element={isAuthenticated ? <CategoryList /> : <Navigate to="/login" replace />}
//       />

//       {/* Products */}
//       <Route
//         path="/products"
//         element={isAuthenticated ? <ProductList /> : <Navigate to="/login" replace />}
//       />

//       {/* Fallback */}
//       <Route path="*" element={<Navigate to="/" replace />} />
//     </Routes>
//   );
// }

// export default App;



import React, { useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom";

import HomePage from "./pages/HomePage";
import ProductDetailPage from "./pages/ProductDetailPage";
import CartPage from "./pages/CartPage";
import CategoryList from "./pages/CategoryList";
import ProductList from "./pages/ProductList";
import LoginPage from "./pages/LoginPage";

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(
    localStorage.getItem("auth") === "true"
  );

  const user = JSON.parse(localStorage.getItem("user") || "null");

  return (
    <Routes>
      <Route
        path="/"
        element={<Navigate to="/login" replace />}
      />

      <Route
        path="/login"
        element={
          <LoginPage
            setIsAuthenticated={setIsAuthenticated}
          />
        }
      />

      <Route
        path="/home"
        element={
          isAuthenticated
            ? <HomePage />
            : <Navigate to="/login" replace />
        }
      />

      <Route
        path="/product/:id"
        element={
          isAuthenticated
            ? <ProductDetailPage />
            : <Navigate to="/login" replace />
        }
      />

      {/* Customer Only */}
      <Route
        path="/cart"
        element={
          isAuthenticated &&
          user?.role === "ROLE_CUSTOMER"
            ? <CartPage />
            : <Navigate to="/home" replace />
        }
      />

      <Route
        path="/categories"
        element={
          isAuthenticated
            ? <CategoryList />
            : <Navigate to="/login" replace />
        }
      />

      <Route
        path="/products"
        element={
          isAuthenticated
            ? <ProductList />
            : <Navigate to="/login" replace />
        }
      />

      <Route
        path="*"
        element={<Navigate to="/" replace />}
      />
    </Routes>
  );
}

export default App;