import { ChangeEvent, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [username, setUsername] = useState("ken888686");
  const [password, setPassword] = useState("asas456789");
  const [showSuccessMessage, setShowSuccessMessage] = useState(false);
  const navigate = useNavigate();

  function usernameOnChange(event: ChangeEvent<HTMLInputElement>) {
    setUsername(event.target.value);
  }
  function passwordOnChange(event: ChangeEvent<HTMLInputElement>) {
    setPassword(event.target.value);
  }
  function handleSubmit() {
    if (username === "ken888686" && password === "asas456789") {
      setUsername("");
      setPassword("");
      setShowSuccessMessage(true);
      navigate("/welcome");
    } else {
      setShowSuccessMessage(false);
    }
  }

  return (
    <div className="login">
      {showSuccessMessage ? <div>Success</div> : <div>Fail</div>}
      <div className="login-form">
        <div>
          <label htmlFor="username">User Name:</label>
          <input
            type="text"
            name="username"
            id="username"
            value={username}
            onChange={usernameOnChange}
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            name="password"
            id="password"
            value={password}
            onChange={passwordOnChange}
          />
        </div>
        <div>
          <button type="button" onClick={handleSubmit}>
            Submit
          </button>
        </div>
      </div>
    </div>
  );
}
