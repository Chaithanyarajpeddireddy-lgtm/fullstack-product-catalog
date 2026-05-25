// import { useState } from "react";
// import { useNavigate } from "react-router-dom";
// import "./LoginPage.css";

// export default function LoginPage({ setIsAuthenticated }) {
//   const [username, setUsername] = useState("");
//   const [password, setPassword] = useState("");
//   const [error, setError] = useState(null);
//   const navigate = useNavigate();

//   const handleLogin = (e) => {
//     e.preventDefault();

//     if (!username || !password) {
//       setError("Please enter username and password.");
//       return;
//     }

//     // ✅ Hardcoded demo accounts
//     const accounts = [
//       { user: "chaithanya", pass: "demo123" },
//       { user: "guest", pass: "guest123" },
//     ];

//     const match = accounts.find(
//       (acc) => acc.user === username && acc.pass === password
//     );

//     if (match) {
//       // ✅ Mark authenticated in React state only
//       setIsAuthenticated(true);

//       // ✅ Redirect to homepage
//       navigate("/home");
//     } else {
//       setError("Invalid username or password.");
//     }
//   };

//   return (
//     <div className="login-page">
//       <h2>Login</h2>
//       <form onSubmit={handleLogin} className="login-form">
//         {error && <p className="error">{error}</p>}

//         <div className="form-group">
//           <label htmlFor="username">Username</label>
//           <input
//             id="username"
//             type="text"
//             value={username}
//             onChange={(e) => setUsername(e.target.value)}
//             placeholder="Enter username"
//           />
//         </div>

//         <div className="form-group">
//           <label htmlFor="password">Password</label>
//           <input
//             id="password"
//             type="password"
//             value={password}
//             onChange={(e) => setPassword(e.target.value)}
//             placeholder="Enter password"
//           />
//         </div>

//         <button type="submit" className="login-btn">
//           Login
//         </button>
//       </form>
//     </div>
//   );
// }


import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./LoginPage.css";

export default function LoginPage({ setIsAuthenticated }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();

    if (!username || !password) {
      setError("Please enter username and password.");
      return;
    }

    // ✅ Hardcoded demo accounts (replace later with API call)
    const accounts = [
      { user: "chaithanya", pass: "demo123" },
      { user: "guest", pass: "guest123" },
    ];

    const match = accounts.find(
      (acc) => acc.user === username && acc.pass === password
    );

    if (match) {
      setIsAuthenticated(true);
      localStorage.setItem("auth", "true");
      localStorage.setItem("user", JSON.stringify({ name: username }));
      navigate("/home");
    } else {
      setError("Invalid username or password.");
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>Login</h2>
        <form onSubmit={handleLogin} className="login-form">
          {error && <p className="error">{error}</p>}

          <div className="form-group">
            <label htmlFor="username">Username</label>
            <input
              id="username"
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              placeholder="Enter username"
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input
              id="password"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Enter password"
            />
          </div>

          <button type="submit" className="login-btn">
            Login
          </button>
        </form>
      </div>
    </div>
  );
}
