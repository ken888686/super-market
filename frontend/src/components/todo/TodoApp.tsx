import { BrowserRouter, Route, Routes } from "react-router-dom";
import Welcome from "../welcome/Welcome";
import Login from "../login/Login";
import "./TodoApp.scss";

export default function TodoApp() {
  return (
    <div className="todo-app">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />}></Route>
          <Route path="/welcome" element={<Welcome />}></Route>
          <Route path="/login" element={<Login />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}
