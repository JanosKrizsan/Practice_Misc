import React from 'react'
import Parent from './ParentComponent'

function ChildComponent(props) {
    return (
        <div>
            <button onClick={() => props.greetHandler('kiddo')}>Greet Parent</button>
        </div>
    )
}

export default ChildComponent
