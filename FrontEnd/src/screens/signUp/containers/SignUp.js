import React, { Component } from 'react'
import { SignUpComponent } from '../components';

class SignUpContainer extends Component {
    constructor(props) {
        super(props)
        this.state = {
          data:{}
       }

      }
    handleChange=(value,key)=>{
        this.setState({
            data : {...this.state.data, [key] : value }
        });
    } 

    signUp=()=>{
        const url = "https://localhost:8082/users";
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

    }

    render() {
      console.log(this.state.data)
      return (
          <SignUpComponent data={this.state.data} handleChange={this.handleChange} signUp={this.signUp} />
      )

  }
}

export default SignUpContainer