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
                <p>
                    Lorem ipsum odor amet, consectetuer adipiscing elit. Amet aptent tincidunt nisl ultrices tortor himenaeos placerat. Nulla odio enim, nam at phasellus quam. Ornare netus parturient in nostra lacinia. Orci morbi mollis lobortis elementum at sed. Dictum donec at ante morbi sodales. Placerat vel tristique diam venenatis placerat dapibus penatibus eleifend. Feugiat ut convallis volutpat dolor hac laoreet sem nibh dapibus. Auctor pellentesque viverra est pharetra nulla magnis orci sed mus.
                </p>
            </div>
        </Div>
    )
}
