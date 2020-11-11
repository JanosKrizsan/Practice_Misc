import React from 'react'

function MemoComponent({name}) {
    console.log('rendering memocomponent')
    return (
        <div>
            Memo component {name}
        </div>
    )
}

export default React.memo(MemoComponent)
