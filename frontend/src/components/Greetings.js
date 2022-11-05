import React from "react";
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';

const Greetings = ({handleAuthClick}) => {

 return (
                    <Box>
                      <Typography variant="h4" component="h1" gutterBottom>
                        Gmail API Integration
                      </Typography>
                      <Divider variant="middle" />
                      <Box
                            display="flex"
                            justifyContent="center"
                            alignItems="center"
                            minHeight="75vh"
                          >
                          <Button  id="authorize_button" onClick={handleAuthClick} variant="contained">Authorize</Button>
                      </Box>
                    </Box>
    )
}

export default Greetings