import React, { useState } from "react";

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState("");
  const [euro, setEuro] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const converted = parseFloat(rupees) / 90;
    setEuro(converted.toFixed(2));
  };

  return (
    <div style={{ marginTop: "30px" }}>
      <h2>Currency Converter (INR ➝ EUR)</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Enter amount in ₹:
          <input
            type="number"
            value={rupees}
            onChange={(e) => setRupees(e.target.value)}
            required
          />
        </label>
        <button type="submit" style={{ marginLeft: "10px" }}>
          Convert
        </button>
      </form>
      {euro && <p>Converted Amount: €{euro}</p>}
    </div>
  );
};

export default CurrencyConvertor;
