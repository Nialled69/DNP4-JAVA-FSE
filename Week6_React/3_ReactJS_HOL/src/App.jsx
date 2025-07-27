import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore 
        Name="Stephen" 
        School="Zion Matriculation School" 
        Total={455} 
        goal="Become a Full Stack Developer" 
      />
    </div>
  );
}

export default App;