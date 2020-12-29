import React, { useState } from 'react';
import './App.css';
import { Route } from 'react-router-dom';
import Header from './components/common/Header';
import Home from './components/pages/Home';

import Pets from './components/pages/MyPet';

import "./App.css";

function App() {
  return (
    
    <div className="App" >
      <Header />
      <Route
        exact={true}
        path="/"
        component={Home}
      />
      <Route
        exact={true}
        path="/pet"
        component={Pets}
      />

    </div>
  );
}

export default App;
