import * as React from 'react';
import TextField from '@mui/material/TextField';


const BasicDateTimePicker=({ handleChange,value})=> {

  return (
    <TextField  fullWidth
    id="date"
    label="DateOfBirth"
    type="date"
    // defaultValue="2017-05-24"
    sx={{ width: 220 }}
    InputLabelProps={{
      shrink: true,
    }}
    value={value}
    onChange = {(e)=>handleChange(e.target.value)}
  />
  );
}
export default BasicDateTimePicker