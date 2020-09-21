import React from 'react';
import Photo from '../../assets/head.png';
import Skincare from '../../components/pages/Skincare';
import { Container,Row,Col,Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

export default function Home() {
    return (
        <div>
            <Row className = "home-top-row">
                <Col xs={7} className = "home-top-row-header">
                    <p className = "home-top-header" >Beauty is Powerful</p>
                    <Link to="/makeup" >
                        <Button variant = "outline-secondary" size="lg">shop makeup</Button>
                    </Link>
                </Col>
                <Col xs={5}>
                    <img className = "home-header-photo" src= {Photo} alt="woman"/>
                </Col>
            </Row>
            <Container fluid className = "home-second-row">
                <Row className = "skin-header-container" xs = {12}>
                <h2 className = "skin-header">Skincare</h2>
                </Row>
                <Skincare />
            </Container>
            
        </div>
    )
}
