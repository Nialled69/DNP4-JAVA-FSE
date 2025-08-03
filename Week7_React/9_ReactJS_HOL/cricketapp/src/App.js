import IndianPlayers from "./Components/IndianPlayers";
import ListOfPlayers from "./Components/ListOfPlayers";


function App() {
  const flag=false
  return (
    <div>
      {flag?<ListOfPlayers/>:<IndianPlayers/>}
    </div>
  );
}

export default App;
