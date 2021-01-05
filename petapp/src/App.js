import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import PrivateRoute from "./components//common/PrivateRoute";
import Header from './components/common/Header';
import Home from './components/pages/Home';

import Pets from './components/pages/MyPet';

import "./App.css";

function App() {
  return (

    <div className="App" >
      <Header />
      <ul>
        <li>
          <Link to="/login">Login</Link>
        </li>
        <li>
          <Link to="/pet">Protected Page</Link>
        </li>
        <li>
          <Link to="/FriendForm">Form Page</Link>
        </li>
      </ul>
      <Switch>
        <Route
          exact={true}
          path="/"
          component={Home}
        />
        <PrivateRoute 
          exact={true}
          path="/pet"
          component={Pets}
        />
      </Switch>
    </div>
  );
}

export default App;
