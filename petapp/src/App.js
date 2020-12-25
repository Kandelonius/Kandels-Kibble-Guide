import React, { useState } from 'react';
import './App.css';
import { Route } from 'react-router-dom';
import Header from './components/common/Header';
import Home from './components/pages/Home';
import MyPet from './components/pages/MyPet';
import "./App.css";

function App() {
  return (
    
    <div className="App" >
      <Header />
      <Wrapper>
          <Route
            exact={true}
            path="/"
            component={Home}
          />
          <Route
            path="/myPet"
            component={MyPet}
          />
          <Route path="/contact"
            component={Contact}
          />
        </Wrapper>
    </div>
  );
}

export default App;
