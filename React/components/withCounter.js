import React from 'react'

const UpdatedComponent = (WrappedComponent, incrementBy) => {
    class withCounter extends React.Component {

        constructor(props) {
            super(props)
        
            this.state = {
                 count: 0
            }
        }
    
        increment = () => {
            this.setState( prevState => {
                return { count: prevState.count + incrementBy}
            })
        }

        render() {
            return <WrappedComponent name='John' count={this.state.count} increment={this.increment} {...this.props}/>
        }
    }
    return withCounter
}

export default UpdatedComponent