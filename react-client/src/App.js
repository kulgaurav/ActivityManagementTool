import React from "react";
import "./App.css";
import Dashboard from "./components/Dashboard";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddActivity from "./components/Activity/AddActivity";

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Dashboard></Dashboard>
        <Route path="/addActivity" component={AddActivity} />
      </div>
    </Router>
  );
}

export default App;
