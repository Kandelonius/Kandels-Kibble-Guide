import React, { Component } from 'react'
import { axiosWithAuth } from "./AxiosWithAuth";

export default class Login extends Component {
    state = {
        credentials: {
            username: "",
            password: ""
        }
    };

    handleChange = e => {
        this.setState({
            credentials: {
                ...this.state.credentials,
                [e.target.name]: e.target.value
            }
        });
    };

    login = e => {
        e.preventDefault();
        axiosWithAuth()
            .post("http://localhost:1982/api/login", this.state.credentials)
            .then(res => {
                localStorage.setItem("token", res.data.payload);
                this.props.history.push("/Home");
            })
            .catch(err => console.log(err));
    };
    
    render() {
        return (
            <div>
                <form onSubmit={this.login}>
                    <input
                        type="text"
                        name="username"
                        value={this.state.credentials.username}
                        onChange={this.handleChange}
                    />
                    <input
                        type="password"
                        name="password"
                        value={this.state.credentials.password}
                        onChange={this.handleChange}
                    />
                    <button>Log in</button>
                </form>
            </div>
        );
    }
}