import React, { useState } from 'react';
import { NavLink } from 'react-router-dom';
import pets from '../images/cat-and-dog-home.jpg';

const Header = () => {
    return (
        <header className="navbar" style={{ backgroundImage: `url(${pets})` }}>
            <h1>Kandel's Kibbles</h1>
            <NavLink to="/">Home</NavLink>
        </header>
    );
};

export default Header;
