import React from 'react'
import { Navbar } from 'react-bootstrap'
import '../App.css'

export default function Footer() {
    return (
        <Navbar sticky = "bottom" className="page-footer">

            <div className="footer-copyright">
            <h6>© 2020: <a href="https://github.com/PowerACH"></a> Rachel Powe</h6>
            </div>

            </Navbar>
        )
    }
