import React from 'react' 
import Link from '@mui/material/Link';

const Newlink=({link, body}) => {
    return(
        <Link href={link} variant="body2">{body}</Link>
    )
}

export default Newlink
