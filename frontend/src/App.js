import { useState, useEffect } from "react";
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Link from '@mui/material/Link';
import logo from './logo.svg';
import './App.css';


function App() {

   const [isAuthenticated, setIsAuthenticated] = useState(false)

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


 const handleAuthClick = () => {
          window.gclient.callback = async (resp) => {
           if (resp.error !== undefined) {
             throw (resp);
           }

          setIsAuthenticated(true)
           await listConnectionNames();
         };

         if (window.gapi.client.getToken() === null) {
           // Prompt the user to select a Google Account and ask for consent to share their data
           // when establishing a new session.
            window.gclient.requestAccessToken({prompt: 'consent'});
         } else {
           // Skip display of account chooser and consent dialog for an existing session.
            window.gclient.requestAccessToken({prompt: ''});
         }
 }

       /**
              * Print the display name if available for 10 connections.
              */
             async function listConnectionNames() {
               let response;
               try {
                 // Fetch first 10 files
                 response = await window.gapi.client.people.people.connections.list({
                   'resourceName': 'people/me',
                   'pageSize': 10,
                   'personFields': 'names,emailAddresses',
                 });
               } catch (err) {
               console.log(err)
                 return;
               }
               const connections = response.result.connections;
               if (!connections || connections.length == 0) {
                 document.getElementById('content').innerText = 'No connections found.';
                 return;
               }
               // Flatten to string to display
               const output = connections.reduce(
                   (str, person) => {
                     if (!person.names || person.names.length === 0) {
                       return `${str}Missing display name\n`;
                     }
                     return `${str}${person.names[0].displayName}\n`;
                   },
                   'Connections:\n');

                    console.log(output)
             }



  return (
    <div className="App">

    <Container maxWidth="sm">
          {!isAuthenticated && (<Box sx={{
                       width: 600,
                       height: 200,
                       backgroundColor: 'primary.dark',
                     }}>
            <Typography variant="h4" component="h1" gutterBottom>
              Gmail API Integration
            </Typography>
            <Button  id="authorize_button" onClick={handleAuthClick} variant="contained">Authorize</Button>
          </Box>)}
          {isAuthenticated && (<Box sx={{
                       width: 600,
                       height: 200,
                       backgroundColor: 'secondary.dark',
                     }}>
            <Typography variant="h4" component="h1" gutterBottom>
              Welcome!
            </Typography>

          </Box>)}
        </Container>
    </div>
  );
}

export default App;
