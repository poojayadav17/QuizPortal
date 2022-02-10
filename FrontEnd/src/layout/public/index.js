import React from 'react'
import { Footer } from '../../shared'
import {
    Route,
    BrowserRouter,
    Routes
} from 'react-router-dom'
import { publicRoutes } from '../../navigation/routes';


const PublicLayout = ({ }) => {
    return (
        <div>
                <BrowserRouter>
                    <Routes>
                        {publicRoutes && publicRoutes.map((item, index) => <Route key={index} exact path={item.path} element={item.component} />)}
                    </Routes>
                </BrowserRouter>
            
            <Footer />
        </div>
    )
}

export default PublicLayout