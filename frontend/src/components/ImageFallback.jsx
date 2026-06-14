// Fallback image utility for missing product images
import "./ImageFallback.css";

export default function ImageFallback({ src, alt, className = "" }) {
  const handleError = (e) => {
    // Show placeholder when image fails to load
    e.target.src = "https://via.placeholder.com/300x300?text=No+Image";
    e.target.classList.add("fallback-image");
  };

  return (
    <img
      src={src || "https://via.placeholder.com/300x300?text=No+Image"}
      alt={alt || "Product image"}
      className={`image-with-fallback ${className}`}
      onError={handleError}
    />
  );
}
