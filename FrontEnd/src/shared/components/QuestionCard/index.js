import * as React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
// import {RadioOption} from '../../../shared';

const card = (
  <React.Fragment>
    <CardContent>
      <Typography variant="body2">
        well meaning and kindly.
        <br />
      </Typography>
    </CardContent>
    <CardActions>
      {/* <RadioOption/> */}
    </CardActions>
  </React.Fragment>
);

export default function QuestionCard() {
  return (
    <Box sx={{ minWidth: 275 }}>
      <Card variant="outlined">{card}</Card>
    </Box>
  );
}