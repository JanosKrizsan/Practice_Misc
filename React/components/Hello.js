import React from 'react'

const hello = () => {
    // return (
        // <div className="dummyClass">
        //     <h1>Hi bro</h1>
        // </div>
    // )

    return React.createElement('div', {id : 'hello', className : 'dummyClass'}, React.createElement('h1', null, 'hi bro'));
}

export default hello;