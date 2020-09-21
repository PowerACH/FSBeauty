import React from 'react';
import './App.css';
import NavBar from './components/NavBar';
import LogIn from './components/LogIn';
import Register from './components/Register';
import Home from './components/pages/Home';
import Makeup from "./components/pages/Makeup";
import Skincare from "./components/pages/Skincare";
import Cart from "./components/pages/Cart";
import ProductInfo from './components/pages/ProductInfo';
import Footer from './components/Footer'
import { BrowserRouter, Switch, Route, } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <NavBar />
        <Switch>
              <Route exact path="/" component = {Home} />
              <Route path="/logIn" component = {LogIn} />
              <Route path="/register" component = {Register} />
              <Route path="/makeup" component = {Makeup} />
              <Route path="/skincare" component = {Skincare} />
              <Route path="/Cart" component = {Cart} />
              <Route path= "/product/:category/:prodName" component={ProductInfo} />
            </Switch>
      <Footer />
      </BrowserRouter>
  </div>
  )
}

export default App;
