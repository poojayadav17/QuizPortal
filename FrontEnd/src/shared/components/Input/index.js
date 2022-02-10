import { TextField } from "@mui/material";

const NewField=({ type,handleChange,value,label})=>{
    return(
        <TextField
                variant="outlined"
                margin="normal"
                required
                fullWidth
                // name="password"
                label={label}
                type={type}
                value={value}
                onChange = {(e)=>handleChange(e.target.value)}
                //autoComplete="current-password"
            />
    )
}
export default NewField