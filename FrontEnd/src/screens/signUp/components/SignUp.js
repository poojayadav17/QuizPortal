import React from 'react';
import Avatar from '@mui/material/Avatar';
import {Button} from '../../../shared';
import CssBaseline from '@mui/material/CssBaseline';
import {Input} from '../../../shared';
import {Link} from '../../../shared';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import LockIcon from '@mui/icons-material/Lock';
import Typography from '@mui/material/Typography';
import { makeStyles } from '@mui/styles';
import {RegisterImg} from '../../../assets/image';

const useStyles = makeStyles(() => ({
  root: {
    height: '100vh',
  },
  image: {
    backgroundRepeat: 'no-repeat',
    // backgroundColor:'#4c7bc2',

    backgroundSize: 'cover',
    backgroundPosition: 'center',
  },
  paper: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    marginTop:'20px',
    padding:'50px',
  },
  submit: {
    color:'green',
  },
  imgStyle:{
    height:"100%",
    width:"100%"
  },
  linkStyle:{
    marginTop:"20px",
    alignItems:"center"
  },
  btn:{
    marginTop:"20px",
  },
  avatar:{
    backgroundColor:'#4c7bc2',
  },
  heading:{
    fontWeight:"bold",
    color:"darkblue",
  }
}));

function SignUpComponent({data,handleChange,signUp}) {
  const classes = useStyles();

  return (
    <Grid container component="main" className={classes.root}>
      <CssBaseline />
      <Grid item xs={false} sm={0} md={6}>
        <img src={RegisterImg} alt="registerImg" className={classes.imgStyle}/>
      </Grid>
      <Grid item xs={12} sm={8} md={6} component={Paper} elevation={6} square>
        <div className={classes.paper} >
          <Avatar className={classes.avatar} >
            <LockIcon />
          </Avatar>
          <Typography component="h1" className={classes.heading} variant="h5">
            Sign Up
          </Typography>
            <Input name='name' type='text' label='Name' value={data.name} handleChange={(value)=> handleChange(value,'name')}/>
            <Input name='email' type='text' label='Email' value={data.email} handleChange={(value)=> handleChange(value,'email')} />
            <Input name='mobile' type='number' label='Mobile' value={data.mobile} handleChange={(value)=> handleChange(value,'mobile')}/>
            <Input name='password' type='password'  label='Password' value={data.password} handleChange={(value)=> handleChange(value,'password')}/>
            <Input name='confirmPassword' type='password' label='Confirm password' value={data.confirmPassword} handleChange={(value)=> handleChange(value,'confirmPassword')}/>
            <Grid className={classes.btn}>
            <Button name='Sign Up' handleClick={signUp}/>
              <Grid item className={classes.linkStyle}>
                <Link body="Already have an account? Sign In" link='/signin'/>
              </Grid>
            </Grid>
        </div>
      </Grid>
    </Grid>
  )
  }

export default SignUpComponent

