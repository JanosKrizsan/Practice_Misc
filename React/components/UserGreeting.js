import React, { Component } from 'react'

 class UserGreeting extends Component {

     constructor(props) {
         super(props)
     
         this.state = {
              isLoggedIn: true
         }
     }
     
    render() {

        return this.state.isLoggedIn && <div>Welcome John</div>
        // let person
        // if (this.state.isLoggedIn){
        //     person = 'John'
        // }
        // else {
        //     person = 'Guest'
        // }

        // return (
        //         this.state.isLoggedIn ?
        //         <div>Welcome John</div> :
        //         <div>Welcome Guest</div>
        // )
    }
}

export default UserGreeting
