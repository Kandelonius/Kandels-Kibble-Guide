import React, { useState } from 'react';
import './App.css';
import { Route } from 'react-router-dom';
import Header from './components/common/Header';

function App() {
  return (
    <Route className="App">
      <Header />
    </Route>
  );
}

export default App;
