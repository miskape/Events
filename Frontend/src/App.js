import "./App.css";
import Events from "./components/events";
import { ToastContainer } from "react-toastify";

function App() {
  return (
    <div className="App">
      <ToastContainer />
      <h1>Events</h1>
      <Events />
    </div>
  );
}

export default App;
