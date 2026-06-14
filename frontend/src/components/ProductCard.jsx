
// import { useState } from "react";
// import { useNavigate } from "react-router-dom";
// import "./ProductCard.css";

// export default function ProductCard({ product }) {
//   const [quantity, setQuantity] = useState(1);
//   const navigate = useNavigate();

//   const handleAddToCart = () => {
//     console.log(`Added ${quantity} of ${product.name} to cart`);
//     alert(`Added ${quantity} of ${product.name} to cart`);
//   };

//   return (
//     <div className="product-card">
//       {/* ✅ Clicking image or name navigates to product detail */}
//       <div
//         className="product-clickable"
//         onClick={() => navigate(`/product/${product.id}`)}
//       >
//         <img
//           src={product.imageUrl || product.image_url}
//           alt={product.name}
//           className="product-image"
//         />
//         <h3>{product.name}</h3>
//       </div>

//       <p className="price">₹{product.price}</p>
//       <p className="category">{product.category?.name}</p>
//       <p className="description">
//         {product.description?.slice(0, 40)}...
//       </p>

//       <div className="quantity-controls">
//         <button onClick={() => setQuantity(Math.max(1, quantity - 1))}>-</button>
//         <span>{quantity}</span>
//         <button onClick={() => setQuantity(quantity + 1)}>+</button>
//       </div>

//       <button onClick={handleAddToCart}>Add to Cart</button>
//     </div>
//   );
// }



import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./ProductCard.css";

export default function ProductCard({ product }) {
  const [quantity, setQuantity] = useState(1);
  const navigate = useNavigate();

  // ✅ RBAC
  const user = JSON.parse(localStorage.getItem("user"));

  const handleAddToCart = () => {
    console.log(`Added ${quantity} of ${product.name} to cart`);
    alert(`Added ${quantity} of ${product.name} to cart`);
  };

  return (
    <div className="product-card">
      {/* Clicking image or name navigates to detail page */}
      <div
        className="product-clickable"
        onClick={() => navigate(`/product/${product.id}`)}
      >
        <img
          src={product.imageUrl || product.image_url}
          alt={product.name}
          className="product-image"
        />

        <h3>{product.name}</h3>
      </div>

      <p className="price">₹{product.price}</p>

      <p className="category">
        {product.category?.name}
      </p>

      <p className="description">
        {product.description?.slice(0, 40)}...
      </p>

      {/* ✅ Only customers see quantity controls */}
      {user?.role === "ROLE_CUSTOMER" && (
        <>
          <div className="quantity-controls">
            <button
              onClick={() =>
                setQuantity(Math.max(1, quantity - 1))
              }
            >
              -
            </button>

            <span>{quantity}</span>

            <button
              onClick={() => setQuantity(quantity + 1)}
            >
              +
            </button>
          </div>

          <button onClick={handleAddToCart}>
            Add to Cart
          </button>
        </>
      )}
    </div>
  );
}