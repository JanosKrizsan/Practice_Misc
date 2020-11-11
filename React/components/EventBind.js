import React, { Component } from 'react'

export class EventBind extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             message: 'Hello'
        }

        // this.clickHandler = this.clickHandler.bind(this)
    }

    // clickHandler() {
    //     this.setState({
    //         message: this.state.message === 'Hello' ? 'GoodBye' : 'Hello'
    //     })
    // }

    clickHandler = () => {
        this.setState ({
            message: this.state.message === 'Hello' ? 'Bye' : 'Hello'
        })
    }
    
    render() {
        return (
            <div>
                <div>{this.state.message}</div>
                <button onClick={this.clickHandler}>Click</button>
            </div>
        )
    }
}

export default EventBind
