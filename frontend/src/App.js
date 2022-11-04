import { useState, useEffect } from "react";
import logo from './logo.svg';
import './App.css';

function App() {

useEffect(() => {

fetch('http://localhost:8080/user/get', {
            method: 'GET',
            headers:{
                'Content-Type': 'application/json',
            }
        }).then((response) => response.json())
          .then((data) => {
            console.log(data)
          });
 }, []);



  return (
    <div className="App">
      <header className="App-header">
        <p>
          Greetings!
        </p>

      </header>
    </div>
  );
}

export default App;
