import React from 'react';
import Posts from './Posts';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Blog Posts</h1>
      </header>
      <main>
        <Posts />
      </main>
    </div>
  );
}

export default App;