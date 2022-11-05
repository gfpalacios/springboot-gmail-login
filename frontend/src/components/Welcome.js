import React, { useState } from "react";
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
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


 <Box>
                       <Typography variant="h4" component="h1" gutterBottom>
                          Welcome!
                       </Typography>
                       <Divider variant="middle" />

                       <Box minHeight="75vh">
                             <Box sx={{ my: 6, mx: 2 }}>
                              <Button onClick={handleOnClick} variant="contained">Get Contacts Now!</Button>

                             </Box>
                             <Divider variant="middle" />
                             <Box sx={{ m: 1 }}>

                             {contacts && contacts.length > 0 && (
                                      <Box sx={{ m: 5 }}>
                                                <TableContainer component={Paper}>
                                                  <Table sx={{ maxHeight: 200 }} aria-label="simple table">
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
                                                )}

                             </Box>
                           </Box>
                     </Box>
    )
}

export default Welcome