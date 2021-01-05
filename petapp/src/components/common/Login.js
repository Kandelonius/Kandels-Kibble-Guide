import React, { Component } from 'react'
import { axiosWithAuth } from "../utils/axiosWithAuth";

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
      .post("http://localhost:5000/api/login", this.state.credentials)
      .then(res => {
        // res.data.payload
        localStorage.setItem("token", res.data.payload);
        this.props.history.push("/Friends");
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