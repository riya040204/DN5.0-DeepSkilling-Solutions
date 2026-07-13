import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="Riya Patel"
        School="Delhi Public School"
        Total={450}
        goal={500}
      />
    </div>
  );
}

export default App;
