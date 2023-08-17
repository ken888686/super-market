import reactLogo from "../../assets/react.svg";
import "./Welcome.scss";

export default function Welcome() {
  return (
    <h1 className="welcome">
      <img src={reactLogo} alt="React logo" />
      Welcome
    </h1>
  );
}
