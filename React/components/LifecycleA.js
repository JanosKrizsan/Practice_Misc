import React, { Component } from 'react'
import CycleB from './LifeCycleB'

class LifecycleA extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name: 'Joe'
        }
        console.log('LifeCycleA const')
    }
    
    static getDerivedStateFromProps(props, state) {
        console.log('lifecycleA getderivedstate')
        return null
    }

    shouldComponentUpdate() {
        console.log('lifecycleA shouldupdate')
        return null
    }
    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('getsnapshot')
        return null
    }

    componentDidUpdate() {
        console.log('didupdate')
    }

    componentDidMount() {
        console.log('lifecycleA didmount')
    }

    changeState = () => {
        this.setState({
            name: 'Jankaral'
        })
    }
    render() {
        return (
            <div>
                <button onClick={this.changeState}>Change state</button>
                <div>
                    LifecycleA
                </div>
                <CycleB/>
            </div>

        )
    }
}

export default LifecycleA
