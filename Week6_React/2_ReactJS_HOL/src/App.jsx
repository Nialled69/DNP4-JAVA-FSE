import React from 'react';
import './App.css';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Home />
        <About />
        <Contact />
      </header>
    </div>
  );
}

export default App;