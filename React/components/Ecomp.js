import React, { Component } from 'react'
import Fcomp from './Fcomp'
import UserContext from './userContext'

class Ecomp extends Component {

    static contextType = UserContext
    
    render() {
        return (
            <div>
                <Fcomp />
                Component E context {this.context}
            </div>
        )
    }
}

Ecomp.contextType = UserContext
export default Ecomp
