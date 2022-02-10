import React, { Component } from 'react'
import { ProfileComponent } from '../components';

class ProfileContainer extends Component {
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
    render() {
      console.log(this.state.data)
      return (
          <ProfileComponent data={this.state.data} handleChange={this.handleChange} />
      )

  }
}
export default ProfileContainer;     




    