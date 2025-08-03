import React, { useState } from "react";

const Counter = () => {
  const [count, setCount] = useState(0);

  const sayHello = () => {
    console.log("Hello! Count increased.");
    alert("Hello! Count increased.");
  };

  const incrementCount = () => {
    setCount((prev) => prev + 1);
    sayHello();
  };

  const decrementCount = () => {
    setCount((prev) => prev - 1);
  };

  return (
    <div>
      <h2>Counter: {count}</h2>
      <button onClick={incrementCount}>Increment</button>
      <button onClick={decrementCount}>Decrement</button>
    </div>
  );
};

export default Counter;
