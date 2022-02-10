import * as React from "react";
import { Card } from "../../../shared";
import "./style.css";
import { javaImg, gkImg } from "../../../assets/image";
import Box  from '@mui/material/Box';
import Grid from '@mui/material/Grid';


const quizCard = [
  {
    image : gkImg,
    name : 'Java Quiz',
    description : "Easy level java quiz for quick brushup." 
  },
  {
    image : javaImg,
    name : 'Java Quiz',
    description : "Easy level java quiz for quick brushup." 
  },
  {
    image : javaImg,
    name : 'Java Quiz',
    description : "Easy level java quiz for quick brushup." 
  },
  {
    image : javaImg,
    name : 'Java Quiz',
    description : "Easy level java quiz for quick brushup." 
  },
  {
    image : javaImg,
    name : 'Java Quiz',
    description : "Easy level java quiz for quick brushup." 
  },
];

const HomeComponent = ({}) => {
  return (
     <Box p={5}>
      <Grid container spacing={5}>
        {quizCard.map((quizCard,i) => {
          return (
            <Grid key={i} item>
              <Card {...quizCard}/>
            </Grid>
          );
        })}
      </Grid>
    </Box>
  );
}

export default HomeComponent;
