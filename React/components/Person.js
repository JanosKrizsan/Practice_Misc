import React from 'react'

function Person({person}) {
    return (
        <div>
            <div>I am {person.name}, {person.age}, {person.skill}</div>
        </div>
    )
}

export default Person
