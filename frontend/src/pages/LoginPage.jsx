import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./LoginPage.css";

export default function LoginPage({ setIsAuthenticated }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    if (!username || !password) {
      setError("Please enter username and password.");
      return;
    }

    // ✅ Hardcoded demo accounts
    if (username === "chaithanya" && password === "demo123") {
      localStorage.setItem("auth", "true");
      setIsAuthenticated(true);
      navigate("/home");
    } else if (username === "guest" && password === "guest123") {
      localStorage.setItem("auth", "true");
      setIsAuthenticated(true);
      navigate("/home");
    } else {
      setError("Invalid credentials");
    }
  };

  return (
    <div className="login-container">
      <form className="login-box" onSubmit={handleLogin}>
        <h2>SSC LOGIN 🛒</h2>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={e => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
        />
        {error && <p className="error">{error}</p>}
        <button type="submit">Login</button>
        <p>
          © 2026 Koneru Lakshmaiah Education Foundation (KL University).  
          This content is used for educational purposes only.
        </p>
      </form>
    </div>
  );
}
