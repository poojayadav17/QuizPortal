// import React from 'react'

// const ProfileComponent = ({ }) => {
//     return (
//             <h1 style={{ color: 'green' }}>Welcome to Profile Page</h1>
//     )
// }

// export default ProfileComponent

import React from 'react';
import {Button} from '../../../shared';
import CssBaseline from '@mui/material/CssBaseline';
import {Input} from '../../../shared';
import Paper from '@mui/material/Paper';
import {RadioButton} from '../../../shared';
import RadioGroup from '@mui/material/RadioGroup';
import Grid from '@mui/material/Grid';
import { FormControl } from '@mui/material';
import { FormControlLabel } from '@mui/material';
import AdapterDateFns from '@material-ui/lab/AdapterDateFns';
import LocalizationProvider from '@material-ui/lab/LocalizationProvider';
import { FormLabel } from '@mui/material';
import Typography from '@mui/material/Typography';
import { makeStyles } from '@mui/styles';
import {DatePicker} from '../../../shared';
import {gender} from '../../../shared/constants'

const useStyles = makeStyles(() => ({
  root: {
    height: '100vh',
  },
  paper: {
    margin: "70px",
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent:'center',
  },

}));

const ProfileComponent = ({data,handleChange}) => {
  const classes = useStyles();

  return (
    <Grid container component="main" className={classes.root} >
      <CssBaseline />
      <Grid item md={4}></Grid>
      <Grid item xs={12} sm={8} md={4} component={Paper} elevation={6} square>
        <div className={classes.paper}>
          <Typography component="h1" variant="h5">
            Profile
          </Typography>
            <Input name='name' type='text' label='Name' value={data.name} handleChange={(value)=> handleChange(value,'name')}/>
            <Input name='mobile' type='text' label='Mobile' value={data.mobile} handleChange={(value)=> handleChange(value,'mobile')}/>
            <Input name='email' type='text' label='Email' value={data.email} handleChange={(value)=> handleChange(value,'email')}/>

            <LocalizationProvider dateAdapter={AdapterDateFns}>
                <DatePicker  
                    value={data.DateOfBirth} handleChange={(value)=> handleChange(value,'DateOfBirth')}
            />
            </LocalizationProvider>

            <RadioButton options={gender} label="Gender"/>
            <Input name='password' type='password'/>
            <Button name='Update Profile'/>
        </div>
      </Grid>
    </Grid>
  )
  }

export default ProfileComponent
