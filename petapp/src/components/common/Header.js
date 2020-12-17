import React, { useState } from 'react';
import { NavLink } from 'react-router-dom';
import pets from '../images/cat-and-dog-home.jpg';

const Header = () => {
    return (
        <header className="navbar" style={{ backgroundColor: 'dodgerBlue' }}>
            <h1>Kandel's Kibbles</h1>
            <div class="navLinks">
                <NavLink to="/">Home</NavLink>
            </div>
        </header>
    );
};

export default Header;
