import React, { useState } from 'react';
import './App.css';
import { Route } from 'react-router-dom';
import Header from './components/common/Header';
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
            path="/about"
            component={About}
          />
          <Route path="/contact"
            component={Contact}
          />
        </Wrapper>
    </div>
  );
}

export default App;
