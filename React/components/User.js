import React, { Component } from 'react'

class User extends Component {
    render() {
        const { render} = this.props
        return (
            <div>
                {render(true)}
            </div>
        )
    }
}

export default User
