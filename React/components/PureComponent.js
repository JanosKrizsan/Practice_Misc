import React, { PureComponent } from 'react'

class PureComp extends PureComponent {
    render() {
        console.log("purecomponent render baby")
        return (
            <div>
                Pure Component Business {this.props.name}
            </div>
        )
    }
}

export default PureComp
