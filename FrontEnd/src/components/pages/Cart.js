import React, { useState, useEffect} from 'react';
import axios from 'axios'
import { Button, Col,Row, Container } from 'react-bootstrap'
import '../../App.css'


export default function Cart() {
    
    const [data, setData] = useState ([]);
    const [total, setTotal] = useState (0)

    useEffect(() => {
        getData()
        getTotal()
    }, [])

    const getData = async () => {
        const res = await axios.get("http://localhost:8081/cart");
        setData(res.data);
        return res;
    }

    const getTotal = async () => {
        const res = await axios.get("http://localhost:8081/cart/total");
        setTotal(res.data);
        return res;
    }

    const deleteData = async (i) => {
        console.log(i)
        await axios.delete("http://localhost:8081/cart/" + i);
        getData();
        window.location.reload()
        
    }


    const products = data.map((products, i) => {
        return (
        <div key={i}>
            <Row className="products"  >
                <Col>
                    <img className = "cart-product-image" src={products.image} alt="product" />
                </Col> 
                <Col>
                    <h6 className = "product-name">{products.prodName}</h6>
                </Col>
                <Col>
                    <h6>${products.price}</h6>
                    <Button onClick = {deleteData.bind(i, products.id)} variant="danger">Delete</Button> 
                </Col>                         
            </Row>
        </div>
        )
    })

    return (
    <Container fluid className="cart-container">
        <Row xs = {12} className = "cart-header-content">     
            <h3 className = "cart-header">Cart</h3>
        </Row>
        <Row className = "cart-content">
        <Col md = {8} className = "cart-left">
            {products}
        </Col>
        <Col className = "cart-right">
            <h5>Total Items: {data.length} </h5>
            <h5>Total Price: ${total} </h5>
        </Col>
        </Row>
    </Container>
    )
}

