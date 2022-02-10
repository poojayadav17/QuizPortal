import React from 'react'
import { Header, Footer } from '../../shared'
import {
    Route,
    BrowserRouter,
    Routes,
} from 'react-router-dom'
import { privateRoutes } from '../../navigation/routes';

const PrivateLayout = () => {
    return (
        <div>
            <Header />
                <BrowserRouter>
                    <Routes>
                        {privateRoutes && privateRoutes.map((item, index) => <Route key={index} exact path={item.path} element={item.component} />)}
                    </Routes>
                </BrowserRouter>
            <Footer />
            </div>
    )
}

export default PrivateLayout