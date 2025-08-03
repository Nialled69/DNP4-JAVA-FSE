import React from "react";

const WelcomeButton = () => {
  const sayWelcome = (message) => {
    alert(message);
  };

  return (
    <div style={{ marginTop: "20px" }}>
      <button onClick={() => sayWelcome("Welcome to React Events!")}>
        Say Welcome
      </button>
    </div>
  );
};

export default WelcomeButton;
