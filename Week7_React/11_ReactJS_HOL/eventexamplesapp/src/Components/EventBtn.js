import React from "react";

const EventButton = () => {
  const handleClick = (e) => {
    e.preventDefault();
    alert("I was clicked");
  };

  return (
    <div style={{ marginTop: "20px" }}>
      <button onClick={handleClick}> Event (OnPress)</button>
    </div>
  );
};

export default EventButton;
