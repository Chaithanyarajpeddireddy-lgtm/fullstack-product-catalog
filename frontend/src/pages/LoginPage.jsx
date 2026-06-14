
// import { useState } from "react";
// import { useNavigate } from "react-router-dom";
// import "./LoginPage.css";
// import { API } from "../services/api";

// export default function LoginPage({ setIsAuthenticated }) {
//   const [username, setUsername] = useState("");
//   const [password, setPassword] = useState("");
//   const [error, setError] = useState(null);
//   const navigate = useNavigate();

//  const handleLogin = async (e) => {
//   e.preventDefault();

//   if (!username || !password) {
//     setError("Please enter username and password.");
//     return;
//   }

//   try {
//     const response = await API.post("/auth/login", {
//       username,
//       password,
//     });

//     const data = response.data;

//     localStorage.setItem("auth", "true");
//     localStorage.setItem("jwtToken", data.token);

//     localStorage.setItem(
//       "user",
//       JSON.stringify({
//         id: data.id,
//         name: data.username,
//         role: data.role,
//       })
//     );

//     setIsAuthenticated(true);
//     navigate("/home");
//   } catch (err) {
//     setError(
//       err.response?.data?.error ||
//       "Invalid username or password."
//     );
//   }
// };

//   return (
//     <div className="login-container">
//       <div className="login-box">
//         <h2>Login</h2>
//         <form onSubmit={handleLogin} className="login-form">
//           {error && <p className="error">{error}</p>}

//           <div className="form-group">
//             <label htmlFor="username">Username</label>
//             <input
//               id="username"
//               type="text"
//               value={username}
//               onChange={(e) => setUsername(e.target.value)}
//               placeholder="Enter username"
//             />
//           </div>

//           <div className="form-group">
//             <label htmlFor="password">Password</label>
//             <input
//               id="password"
//               type="password"
//               value={password}
//               onChange={(e) => setPassword(e.target.value)}
//               placeholder="Enter password"
//             />
//           </div>

//           <button type="submit" className="login-btn">
//             Login
//           </button>
//         </form>
//       </div>
//     </div>
//   );
// }



import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { API } from "../services/api";
import "./LoginPage.css";

export default function LoginPage({ setIsAuthenticated }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);

  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    setError(null);

    if (!username || !password) {
      setError("Please enter username and password.");
      return;
    }

    try {
      const response = await API.post("/auth/login", {
        username,
        password,
      });

      const data = response.data;

      localStorage.setItem("auth", "true");
      localStorage.setItem("jwtToken", data.token);

      localStorage.setItem(
        "user",
        JSON.stringify({
          id: data.id,
          name: data.username,
          role: data.role,
        })
      );

      setIsAuthenticated(true);

      navigate("/home");
    } catch (err) {
      setError(
        err.response?.data?.error ||
        "Invalid username or password."
      );
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