import React from "react"

import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';

const RadioOption=({ handleChange,value})=>{
  const marginTop = { marginTop: 5 }
    return(
  
      <RadioGroup aria-label="RadioButton" name="RadioButton" style={{ display: 'initial' }}
      value={value}
      onChange = {(e)=>handleChange(e.target.value)}
      >
          <FormControlLabel value="true" control={<Radio />} label="true" />
          <FormControlLabel value="false" control={<Radio />} label="false" />
         
      </RadioGroup>

    )
    }
export default RadioOption
    