import React from "react";
const ListOfPlayers=()=>{
    const players=[
     { name: 'Player 1', score: 85 },
    { name: 'Player 2', score: 40 },
    { name: 'Player 3', score: 90 },
    { name: 'Player 4', score: 35 },
    { name: 'Player 5', score: 75 },
    { name: 'Player 6', score: 60 },
    { name: 'Player 7', score: 45 },
    { name: 'Player 8', score: 95 },
    { name: 'Player 9', score: 55 },
    { name: 'Player 10', score: 80 },
    { name: 'Player 11', score: 25 },
    ];
    const lowScores=players.filter(p=>p.score<70);
    return(
        <div>
      <h2>All Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            Mr. {player.name}<span>{player.score}</span>
          </li>
        ))}
      </ul>
      <hr/>

      <h2>List of Players having scores less than 70</h2>
      <ul>
        {lowScores.map((player, index) => (
          <li key={index}>
            Mr. {player.name}<span>{player.score}</span>
          </li>
        ))}
      </ul>
      </div>
      )

}
export default ListOfPlayers;