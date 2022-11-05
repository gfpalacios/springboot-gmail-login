import { useState, useEffect } from "react";
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import './App.css';
import Welcome from './components/Welcome'


function App() {

   const [user, setUser] = useState()
   const [isAuthenticated, setIsAuthenticated] = useState(false)
   const [contacts, setContacts] = useState([])
   const [isContactSaved, setContactsSaved] = useState(false)

useEffect(() => {
if(isAuthenticated && !isContactSaved && contacts.length > 0){
const user = {"username": "test","sampleContactCollection": contacts}

fetch('http://localhost:8080/user/add', {
            method: 'POST',
            headers:{
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user),
        }).then((response) => response.json())
          .then((data) => {
            setUser(data)
            setContactsSaved(true)
          });

}

 }, [isAuthenticated, contacts]);


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
             return;
           }

           const output = connections.map(item => ({"contact":item.names[0].displayName}) )
           setContacts(output)
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
          {isAuthenticated && (<Welcome user={user} />)}
        </Container>
    </div>
  );
}

export default App;
