import React from "react";

const LoginToggle = ({ isLoggedIn, onLoginToggle }) => {
  return (
    <button onClick={onLoginToggle}>
      {isLoggedIn ? "Logout" : "Login"}
    </button>
  );
};

export default LoginToggle;
