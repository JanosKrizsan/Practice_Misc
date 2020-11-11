import React, { Component } from 'react'

export class RefsDemo extends Component {

    constructor(props) {
        super(props)
    
        this.inputRef = React.createRef()
        this.cbRef = null
        this.setCbRef = (element) => {
            this.cbRef = element
        }
    }
    
    componentDidMount(){
        console.log(this.inputRef)
    }

    clickHandler = () => {
        if (this.cbRef) {
            this.cbRef.focus()
        }
        alert(this.inputRef.current.value)
    }

    render() {
        return (
            <div>
                <input type='text' ref={this.inputRef}></input>
                <input type='text' ref={this.cbRef}></input>
                <button onClick={this.clickHandler}>Click me</button>
            </div>
        )
    }
}

export default RefsDemo
