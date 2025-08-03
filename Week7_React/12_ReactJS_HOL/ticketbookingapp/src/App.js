import React, { useState } from "react";
import GuestPage from "./Components/GuestPage";
import UserPage from "./Components/UserPage";
import LoginToggle from "./Components/Login";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginToggle = () => {
    setIsLoggedIn(prev => !prev);
  };

  let content;
  if (isLoggedIn) {
    content = <UserPage />;
  } else {
    content = <GuestPage />;
  }

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>Ticket Booking App</h1>
      <LoginToggle isLoggedIn={isLoggedIn} onLoginToggle={handleLoginToggle} />
      <hr />
      {content}
    </div>
  );
}

export default App;
