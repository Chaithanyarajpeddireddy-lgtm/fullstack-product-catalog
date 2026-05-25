// import { useNavigate } from "react-router-dom";
// import { useCart } from "../context/cart.jsx";
// import "./ProductCard.css";

// export default function ProductCard({ product }) {
//   const navigate = useNavigate();
//   const { add, has } = useCart();

//   return (
//     <div
//       className="product-card"
//       role="button"
//       tabIndex={0}
//       onClick={() => navigate(`/product/${product.id}`)}
//       onKeyPress={(e) => e.key === "Enter" && navigate(`/product/${product.id}`)}
//     >
//       <img
//         src={product.image_url || product.image}
//         alt={product.title || product.name}
//         className="product-image"
//       />
//       <h4 className="product-title">{product.title || product.name}</h4>
//       <p className="product-price">₹ {product.price}</p>

//       <button
//         className={`add-to-cart-btn ${has(product.id) ? "in-cart" : ""}`}
//         onClick={(e) => {
//           e.stopPropagation(); // prevent navigation
//           add(product);
//         }}
//       >
//         {has(product.id) ? "Added to Cart" : "Add to Cart"}
//       </button>
//     </div>
//   );
// }





// import { useState } from "react";
// import { useNavigate } from "react-router-dom";
// import "./ProductCard.css";

// export default function ProductCard({ product }) {
//   const [quantity, setQuantity] = useState(1);
//   const navigate = useNavigate();

//   const handleAddToCart = () => {
//     // Here you can integrate with your Cart context
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
//           src={product.image_url}
//           alt={product.name}
//           className="product-image"
//         />
//         <h3>{product.name}</h3>
//       </div>

//       <p>₹{product.price}</p>

//       {/* ✅ Quantity controls */}
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

  const handleAddToCart = () => {
    console.log(`Added ${quantity} of ${product.name} to cart`);
    alert(`Added ${quantity} of ${product.name} to cart`);
  };

  return (
    <div className="product-card">
      {/* ✅ Clicking image or name navigates to product detail */}
      <div
        className="product-clickable"
        onClick={() => navigate(`/product/${product.id}`)}
      >
        <img
          src={product.imageUrl}
          alt={product.name}
          className="product-image"
        />
        <h3>{product.name}</h3>
      </div>

      <p className="price">₹{product.price}</p>
      <p className="category">{product.category?.name}</p>
      <p className="description">
        {product.description?.slice(0, 40)}...
      </p>

      <div className="quantity-controls">
        <button onClick={() => setQuantity(Math.max(1, quantity - 1))}>-</button>
        <span>{quantity}</span>
        <button onClick={() => setQuantity(quantity + 1)}>+</button>
      </div>

      <button onClick={handleAddToCart}>Add to Cart</button>
    </div>
  );
}
