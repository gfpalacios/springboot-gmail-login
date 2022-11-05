import React, { useState } from "react";
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

const Welcome = ({user}) => {
 const [contacts, setContacts] = useState([])

const handleOnClick = () => {
fetch('http://localhost:8080/user/get/' + user.userId, {
            method: 'GET',
            headers:{
                'Content-Type': 'application/json',
            }
        }).then((response) => response.json())
          .then((data) => {
            setContacts(data.sampleContactCollection)
          });

}

 return (
          <Box sx={{
                       width: 600,
                       height: 200,
                       backgroundColor: 'secondary.dark',
                     }}>
            <Typography variant="h4" component="h1" gutterBottom>
              Welcome!
            </Typography>

            <Button  id="authorize_button" onClick={handleOnClick} variant="contained">Get Contacts Now!</Button>


            <TableContainer component={Paper}>
              <Table sx={{ minWidth: 100 }} aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell align="center">Contact ID</TableCell>
                    <TableCell align="center">Contact</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {contacts.map((contact) => (
                    <TableRow
                      key={contact.contactId}
                      sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                    >
                      <TableCell align="center">{contact.contactId}</TableCell>
                       <TableCell align="left">{contact.contact}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
          </Box>
    )
}

export default Welcome