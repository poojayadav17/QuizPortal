import React, { Component } from 'react'
import { SignInComponent } from '../components';
import axios from 'axios';

class SignInContainer extends Component {
    constructor(props) {
        super(props)
        this.state = {
          data:{}
       }

}

  componentDidMount(){
    
  }

    handleChange=(value,key)=>{
        this.setState({
            data : {...this.state.data, [key] : value }
        });
    } 
    

    signIn=()=>{
        const url = "https://localhost:8082/users/login";
        fetch(url, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          mode: "cors",
          body: this.state.data
        })
          .then((response) => response.text())
          .then((response) => {
            if (response !== 0) {
              this.setState({
                loggedIn: true,
              });
              //authenticationService.registerSuccessfulLogin()
              sessionStorage.setItem("authenticatedUser", response);
            } else {
              alert("Wrong Credentials Provided");
            }
          })
          .catch(() =>
            console.log("Can’t access " + url + " response. Blocked by browser")
          );
    
        console.log(this.state.data)

    // axios.post("https://localhost:8082/users/login", this.state.data)
    // .then(response => response.data)
    // .then((data) => {
    //   this.setState.data;
    // }); 

    }

    render() {
      console.log(this.state.data)
      return (
          <SignInComponent data={this.state.data} handleChange={this.handleChange} signIn={this.signIn} />
      )

  }
}

export default SignInContainer