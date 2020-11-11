import React, { Component } from 'react'

class ComponentReg extends Component {
    render() {
        console.log("reg component baby")
        return (
            <div>
                Regular component {this.props.name}
            </div>
        )
    }
}

export default ComponentReg
