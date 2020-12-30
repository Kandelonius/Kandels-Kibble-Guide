import styled from 'styled-components';

const Div = styled.div`
    padding: 1%;
    width:96%;
    margin:0 auto;
    header {
        display:flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        width:100%;
        h1 {
            margin-left: 5%;
            text-align: left;
        }
        .navLinks {
            margin-right: 5%;
            text-align: right;
            text-decoration: none;
            width: 50%;
            a{
                margin-left: 2%;
            }
        }
    }
    
`

export default Div;