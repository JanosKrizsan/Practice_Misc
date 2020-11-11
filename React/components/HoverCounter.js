import React, { Component } from 'react'
import withCounter from './withCounter'

export class HoverCounter extends Component {

    render() {
        const { count, increment, name } = this.props
        return (
            <div>
                <h2 onMouseOver={increment}>{name} Howevered {count} times</h2>
            </div>
        )
    }
}

export default withCounter(HoverCounter, 10)
