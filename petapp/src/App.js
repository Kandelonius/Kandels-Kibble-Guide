import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import PrivateRoute from "./components//common/PrivateRoute";
import Header from './components/common/Header';
import Home from './components/pages/Home';
import Pets from './components/pages/MyPet';
import Login from './components/common/Login';

import "./App.css";

function App() {
  return (

    <div className="App" >
      <Header />
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
        <Route
          exact={true}
          path="/login"
          component={Login}
        />
      </Switch>
    </div>
  );
}

export default App;
