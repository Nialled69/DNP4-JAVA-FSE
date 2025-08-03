
import React, { useState } from "react";
import Counter from "./Components/Counter";
import WelcomeButton from "./Components/WelcomeButton";
import EventButton from "./Components/EventBtn";
import CurrencyConvertor from "./Components/CurrencyConverter";

function App() {
  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>Currency Converter</h1>
      <Counter />
      <WelcomeButton />
     <EventButton/>
      <CurrencyConvertor />
    </div>
  );
}

export default App;
