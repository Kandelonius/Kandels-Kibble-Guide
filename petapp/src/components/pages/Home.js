import React from 'react';
import Div from '../componentStyles/HomeStyles';
import petPic from '../images/cat-and-dog-home.jpg';

/*
this is the home page where a user initially lands by default
*/

export default function Home() {
    return (
        <Div>
            <img src={petPic} alt="a cat and dog" />
            <div>
                
            </div>
        </Div>
    )
}
