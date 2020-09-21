import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useParams } from 'react-router-dom'
import '../../App.css'
import { Container, Col, Button, Spinner } from 'react-bootstrap';

export default function ProductInfo() {
    let { prodName, category } = useParams();
    const [data, setData] = useState([]);
    const [cartData, setCartData] = useState(0)

    const getProductData = async () => {
        const res = await axios.get("http://localhost:8081/" + category + "/" + prodName)
        setData(res.data);
        return res;
        
    }
    useEffect(() => {
        getProductData()
    });
    
    const cartItem = {
        prodName : prodName,
        price : data.price,
        quantity : cartData.quantity,
        image : data.image
    }

    function handleChange(e) {
        const { value, id } = e.target;
        setCartData({ ...cartData, [id]: value })
        console.log(cartData)
      }
    
    function handleSubmit(e) {
        e.preventDefault();
        axios.post('http://localhost:8081/cart', cartItem)
        .then(function(result) {
            console.log('Logging result ' + result);
        }, (e) => {
            console.log(e)
        })
        // console.log(input);
    }

        const prod = data ? (
            <Container className="product" >
                    <Col xs = {12} md = {6} className = "product-left">
                        <img className = "single-image" src={data.image} alt="product" />
                    </Col>
                    <Col className = "product-right">
                        <h4 className = "prodName"> {data.prodName}</h4>
                        
                        <p> Price: ${data.price}</p>
                        
                        <form onChange = {handleChange} >
                            <label>Quantity:</label>
                            <input type="number" id="quantity" name="quantity" min="1" max="5" />
                        
                        
                        <Button onClick = {handleSubmit} variant="primary" size="lg" block>
                            Add To Cart
                        </Button>
                        </form>
                        <h4 className = "product-description-header">Description</h4>
                        <h6>{data.prodInfo}</h6>
                    </Col>
            </Container>
        ) : (
            // <div className="center">Loading...</div>
            <Spinner animation="grow" />
        )
        return(
           
            <Container className="container">
            <div className = "back-button">
                <Link to="/">back</Link>
            </div>
                <h4>{ prod }</h4>
            </Container>
        )
    }
