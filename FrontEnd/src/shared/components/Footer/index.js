import React from "react";
import {
    AppBar,
    Toolbar,
    Typography,
    Grid,
    Link
} from "@material-ui/core";
import FacebookIcon from '@mui/icons-material/Facebook';


const NewFooter = () => 
    <>
        <Grid container justify="center" style={{color:"black"}}>
            <Grid container item sm={6} xs={11} justify="space-between">
        
            {/* <FacebookIcon/> */}
         
               
            </Grid> 
        </Grid>
        <AppBar position="static" elevation={0} component="footer" color="grey">
            <Toolbar style={{ justifyContent: "center" }}>
                <Typography variant="caption"> Quiz Portal Developed by Pooja Yadav OnGrid ©2022</Typography>
            </Toolbar>
        </AppBar>
    </>

export default NewFooter;