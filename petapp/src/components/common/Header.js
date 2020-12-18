import React, { useState } from 'react';
import { NavLink } from 'react-router-dom';
import pets from '../images/cat-and-dog-home.jpg';
import Div from './HeaderStiles.jsx';

const Header = () => {
    return (
        <Div>
            <header className="navbar" style={{ backgroundColor: '#8AA69F' }}>
                <h1>Kandel's Kibbles</h1>
                <div class="navLinks">
                    <NavLink to="/">Home</NavLink>
                </div>
            </header>
        </Div>
    );
};

export default Header;
