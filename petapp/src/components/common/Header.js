import React, { useState } from 'react';
import { NavLink } from 'react-router-dom';

const Header = () => {
    return (
        <nav className="navbar">
            <h1>Kandel's Kibbles</h1>
            <NavLink to="/">Home</NavLink>
        </nav>
    );
};

export default Header;
