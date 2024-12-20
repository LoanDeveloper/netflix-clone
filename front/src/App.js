import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import Series from './components/Series';
import Films from './components/Films';
import './App.css';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={
          <div className="App">
            <header className="App__header"> 
              <img src="./img/Netflix_2015_logo.svg.png" className="netflixLogo" alt="logo"></img>
              <h2 className='app__title'>Qui est-ce ?</h2>
            </header>
            <section className='profil__container'>
              <Link className='profil' to="/home">
                <img className='profil__img' src="./img/profil_picture1.jpg" alt="" />
                <p className='profil__name'>Loan</p>
              </Link>
              <Link className='profil' to="/home">
                <img className='profil__img' src="./img/profil_picture2.jpg" alt="" />
                <p className='profil__name'>Nicolas</p>
              </Link>
              <Link className='profil' to="/home">
                <img className='profil__img' src="./img/kidsLogo.png" alt="" />
                <p className='profil__name'>Enfants</p>
              </Link>
            </section>
          </div>
        } />
        <Route path="/home" element={<Home />} />
        <Route path="/series" element={<Series />} />
        <Route path="/films" element={<Films />} />
      </Routes>
    </Router>
  );
}

export default App;
