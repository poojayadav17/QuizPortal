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
import {Login} from '../../../assets/image';

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
    marginTop:'50px',
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
    marginTop:"10px",
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

const SignInComponent = ({data,handleChange,signIn}) => {
  const classes = useStyles();

  return (
    <Grid container component="main" className={classes.root}>
      <CssBaseline />
      <Grid item xs={false} sm={0} md={6}>
        <img src={Login} alt="loginImg" className={classes.imgStyle}/>
      </Grid>
      <Grid item xs={12} sm={8} md={6} component={Paper} elevation={6} square>
        <div className={classes.paper} >
          <Avatar className={classes.avatar} >
            <LockIcon />
          </Avatar>
          <Typography className={classes.heading} component="h1" variant="h5">
            Sign in
          </Typography>
            <Input name='email' type='text' label='Email' value={data.email} handleChange={(value)=> handleChange(value,'email')}/>
            <Input name='password' type='password' label='Password' value={data.password} handleChange={(value)=> handleChange(value,'password')}/>
            <Grid className={classes.btn}>
            <Button name='Sign In' handleClick={signIn}/>
              <Grid item className={classes.linkStyle}>
                <Link body="Don't have an account? Sign Up" link='/signup'/>
              </Grid>
            </Grid>
          {/* </form> */}
        </div>
      </Grid>
    </Grid>
  )
  }

export default SignInComponent
