import React, { useEffect, useState } from 'react';
import '../../App.css';
import axios from 'axios';
import { Link } from 'react-router-dom'
import { Row } from 'react-bootstrap';


function Skincare() {
    
    const [skincare, setSkincare] = useState ([]);

    useEffect(() => {
        getSkincareData()
    }, [])

    const getSkincareData = async () => {
        const res = await axios.get("http://localhost:8081/skincare");
        setSkincare(res.data);
        return res;
    }

    const products = skincare.map((products, i) => {
        return (
        <div className = "product-card" key={i}>
            <li className="products"  >
            <Link to= {`/product/${products.category}/${products.prodName}`}>
                <img className = "product-image" src={products.image} alt="product" /> 
                </Link>
                <h6 className = "product-name">{products.prodName}</h6>
                <h6>${products.price}</h6>                               
            </li>
        </div>
        )
    })

    return (
    
    <Row className="container">
            {products}
    </Row>
    )
}

export default Skincare

