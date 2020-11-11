import React, { Component } from 'react'
import PureComp from './PureComponent'
import ComponentReg from './ComponentReg'
import MemoComponent from './MemoComponent'

class ParentComponentSecond extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name: 'John'
        }
    }

    componentDidMount() {
        setInterval( () => {
            this.setState({
                name: "John"
            })
        }, 2000)
    }
    
    render() {
        console.log('parent component baby')
        return (
            <div>
                Parent Component Second
                <MemoComponent name={this.state.name}/>
                {/* <ComponentReg name={this.state.name}/>
                <PureComp name={this.state.name}/> */}
            </div>
        )
    }
}

export default ParentComponentSecond
