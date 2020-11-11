import React from 'react'
import Person from './Person'

function RenderMultiple() {
    const names = ['Bruce', 'Clarck', 'Diana', 'Bruce']
    const people = [
        {
            id: 1,
            name: 'Bruce',
            age: 30,
            skill: 'Human Hunting'
        },
        {
            id: 2,
            name: 'Clark',
            age: 26,
            skill: 'Good Guy'
        },
        {
            id: 3,
            name: 'Diana',
            age: 29,
            skill: 'Badass Babe'
        }
    ]

    const nameList = names.map((name, index) => <h2 key={index}>{index} {name}</h2>)

    return (
        <div>
            {nameList}
        </div>
    )
}

export default RenderMultiple
