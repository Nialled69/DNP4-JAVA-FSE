import React from "react";
import officeImage from "./Resources/officeImg.jpg";
function App() {
  const heading = <h1>Office Space Rental App</h1>;


  const office = {
    name: "Prime Workspace",
    rent: 55000,
    address: "123 Business Avenue, Bengaluru"
  };

  const officeList = [
    {
      name: "Cyber Hub",
      rent: 75000,
      address: "Sector 15, Gurgaon"
    },
    {
      name: "Green Office",
      rent: 45000,
      address: "Lake Road, Pune"
    },
    {
      name: "Sky Towers",
      rent: 61000,
      address: "IT Park, Hyderabad"
    }
  ];
  const getRentStyle = (rent) => ({
    color: rent < 60000 ? "red" : "green",
    fontWeight: "bold"
  });

  return (
    <div style={{ fontFamily: "Arial", padding: "20px" }}>
    
      {heading}

      <img
        src={officeImage}
        alt="Office Space"
        style={{ width: "400px", height: "200px", marginBottom: "20px" }}
      />
      <h2>{office.name}</h2>
      <p>Address: {office.address}</p>
      <p style={getRentStyle(office.rent)}>Rent: ₹{office.rent}</p>

      <hr />

      <h2>Other Office Spaces</h2>
      <ul>
        {officeList.map((item, index) => (
          <li key={index}>
            <h3>{item.name}</h3>
            <p>Address: {item.address}</p>
            <p style={getRentStyle(item.rent)}>Rent: ₹{item.rent}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
