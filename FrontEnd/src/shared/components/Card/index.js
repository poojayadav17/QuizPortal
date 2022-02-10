import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';
import { makeStyles } from '@mui/styles';

const useStyles = makeStyles({
    media:{
        height:140,
    },
});


const NewCard=({name, description, image})=>{
    const classes = useStyles();
    debugger
    return(
            <Card sx={{ maxWidth: 345 }}>
                <CardActionArea>
                    <CardMedia classNmae={classes.media}
                    component="img"
                    height="140"
                    image = {image}
                    alt="Java img"
                    />
                    <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                        {name}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        {description}
                    </Typography>
                    </CardContent>
                </CardActionArea>
                <CardActions>
                    <Button size="small" color="primary">
                    Attempt
                    </Button>
                </CardActions>
                </Card>
    )
}

export default NewCard