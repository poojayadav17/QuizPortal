import {Button} from '@mui/material'

const NewButton=({name, handleClick})=>{
    return(
        <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className="pooja"
              onClick={handleClick}
            >
                {name}
            </Button>       
    )
}
export default NewButton