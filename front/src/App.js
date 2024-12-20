import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { UserProvider } from './context/UserContext';
import { useUser } from './context/UserContext';
import Home from './components/Home';
import Series from './components/Series';
import Films from './components/Films';
import './App.css';
import { useNavigate } from 'react-router-dom';

const profiles = [
  { name: 'Loan', image: './img/profil_picture1.jpg' },
  { name: 'Nicolas', image: './img/profil_picture2.jpg' },
  { name: 'Enfants', image: './img/kidsLogo.png' }
];

function ProfileSelection() {
  const { setActiveUser } = useUser();
  const navigate = useNavigate();

  const handleProfileSelect = (profile) => {
    setActiveUser(profile);
    navigate('/home');
  };

  return (
    <div className="App">
      <header className="App__header"> 
        <img src="./img/Netflix_2015_logo.svg.png" className="netflixLogo" alt="logo" />
        <h2 className='app__title'>Qui est-ce ?</h2>
      </header>
      <section className='profil__container'>
        {profiles.map((profile) => (
          <div 
            key={profile.name} 
            className='profil' 
            onClick={() => handleProfileSelect(profile)}
            style={{ cursor: 'pointer' }}
          >
            <img className='profil__img' src={profile.image} alt={profile.name} />
            <p className='profil__name'>{profile.name}</p>
          </div>
        ))}
      </section>
    </div>
  );
}

function App() {
  return (
    <UserProvider>
      <Router>
        <Routes>
          <Route path="/" element={<ProfileSelection />} />
          <Route path="/home" element={<Home />} />
          <Route path="/series" element={<Series />} />
          <Route path="/films" element={<Films />} />
        </Routes>
      </Router>
    </UserProvider>
  );
}

export default App;
