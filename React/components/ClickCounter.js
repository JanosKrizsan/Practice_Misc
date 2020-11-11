import React, { Component } from 'react'
import withCounter from './withCounter'

class ClickCounter extends Component {

   
    
    render() {
        const { count, increment, name, human} = this.props
        return (
            <div>
                <button onClick={increment}>A {human} {name} Clicked {count} times</button>
            </div>
        )
    }
}

export default withCounter(ClickCounter, 5)
