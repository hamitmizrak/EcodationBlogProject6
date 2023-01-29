import './App.css';
import {BrowserRouter as Router,Route,Switch } from 'react-router-dom';

import Header from './component/Header';
import Footer from './component/Footer';

import RegisterList from './component/register/RegisterList';
import RegisterCreate from './component/register/RegisterCreate';
import RegisterView from './component/register/RegisterView';

function App() {
  return (
    <>
      <Router> 
        <Header logo="LOGO ALANI" logo_icon="fa-solid fa-bus"/>
        <div className="container">
          <Switch>
            <Route path="/" exact component={RegisterList}></Route>
            <Route path="/register_list"  component={RegisterList}></Route>
            <Route path="/register_add/:id"  component={RegisterCreate}></Route>
            <Route path="/register_view/:id"  component={RegisterView}></Route>
          </Switch>
        </div>
        <Footer allright="Bütün hakler saklıdır" />
      </Router>
    </>
  );
}

export default App;

