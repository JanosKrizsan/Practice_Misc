import React, { Component } from 'react'

class CycleB extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name: 'Joe'
        }
        console.log('CycleB const')
    }
    
    static getDerivedStateFromProps(props, state) {
        console.log('CycleB getderivedstate')
        return null
    }

    shouldComponentUpdate() {
        console.log('lifecycleB shouldupdate')
    }

    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('getsnapshot')
        return null
    }

    componentDidUpdate() {
        console.log('didupdate')
    }

    componentDidMount() {
        console.log('lifecycleB didmount')
    }

    render() {
        return (
            <div>
                CycleB
            </div>
        )
    }
}

export default CycleB
