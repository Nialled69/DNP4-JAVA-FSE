import React from "react";

const IndianPlayers=()=>{
    const T20players = ['Dhoni', 'Virat', 'Rohit', 'Pant', 'Surya'];
    const RanjiTrophy = ['Iyer', 'Jadeja', 'Ashwin', 'Pujara', 'Rahane'];

    const allPlayers=[...T20players,...RanjiTrophy]

    const oddTeam=[]
    const evenTeam=[]

    function getOrdinal(i){
        const st=['st','nd','rd','th']
        if (i % 100 >= 11 && i % 100 <= 13)return st[3];
        else if(i%10==1)return st[0];
        else if(i%10==2)return st[1];
        else if(i%10==3)return st[2];
        else return st[3];
    }

    allPlayers.forEach((player,i)=>{
        if(i%2==0)evenTeam.push(player)
        else oddTeam.push(player)
    })
return(

    <div>
        <h1>Odd Players</h1>
        <ul>
            {oddTeam.map((p,i)=>(
                <li key={i}>{i+1}{getOrdinal(i+1)} Player: {p}</li>
))}
        </ul>
            <hr/>
            <h1>Even Players</h1>
        <ul>
            {evenTeam.map((p,i)=>(
                <li key={i}>{i+1}{getOrdinal(i+1)} Player: {p}</li>
            ))}
        </ul>
            <hr/>
        <h1>List Of Merger Players</h1>
        <ul>
            {allPlayers.map((p,i)=>(
                <li key={i}>{i+1}{getOrdinal(i+1)} Player: {p}</li>
            ))}
        </ul>

    </div>
)
}

export default IndianPlayers;