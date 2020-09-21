import React from 'react'
import '../App.css'

export default function Banner(props) {
    return (
        <div className = "banner-container">
            <p className = "banner">{props.header}</p>
        </div>
    )
}
