import React, { useState } from 'react';
import { NavLink } from 'react-router-dom';
import Div from '../componentStyles/HeaderStyles.jsx';

/*
this is the static nav bar at the top of every
*/

const Header = () => {
    return (
        <Div>
            <header className="navbar" style={{ backgroundColor: '#8AA69F' }}>
                <h1>Kandel's Kibbles</h1>
                <div class="navLinks">
                    <NavLink to="/">Home</NavLink>
                    <NavLink to="/pet">My Pet</NavLink>
                    <NavLink to="/login">Login</NavLink>
                </div>
            </header>
        </Div>
    );
};

export default Header;
