import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useUser } from '../context/UserContext';

function Navbar() {
  const navigate = useNavigate();
  const { activeUser, setActiveUser } = useUser();
  const [showProfiles, setShowProfiles] = useState(false);

  const profiles = [
    { name: 'Loan', image: './img/profil_picture1.jpg' },
    { name: 'Nicolas', image: './img/profil_picture2.jpg' },
    { name: 'Enfants', image: './img/kidsLogo.png' }
  ];

  const handleLogout = () => {
    navigate('/');
  };

  const handleProfileChange = (profile) => {
    setActiveUser(profile);
    setShowProfiles(false);
  };

  return (
    <header className="home__header">
      <div className="home__header__left">
        <img src="./img/Netflix_2015_logo.svg.png" className="home__netflixLogo" alt="logo" />
        <nav className="home__nav">
          <ul className="home__nav__list">
            <li className="home__nav__item"><Link to="/home" className="home__nav__link">Accueil</Link></li>
            <li className="home__nav__item"><Link to="/series" className="home__nav__link">Séries TV</Link></li>
            <li className="home__nav__item"><Link to="/films" className="home__nav__link">Films</Link></li>
            <li className="home__nav__item">Nouveautés</li>
            <li className="home__nav__item">Ma liste</li>
          </ul>
        </nav>
      </div>
      <div className="home__header__right">
        <div className="home__profile">
          <img src={activeUser.image} className="home__profile__img" alt={activeUser.name} />
          <div className="home__profile__menu">
            <button className="home__profile__button" onClick={handleLogout}>Se déconnecter</button>
            <button 
              className="home__profile__button" 
              onClick={() => setShowProfiles(!showProfiles)}
            >
              Changer de profil
            </button>
            {showProfiles && (
              <div className="home__profile__submenu">
                {profiles.map(profile => (
                  <div 
                    key={profile.name}
                    className="home__profile__option"
                    onClick={() => handleProfileChange(profile)}
                  >
                    <img 
                      src={profile.image} 
                      alt={profile.name} 
                      className="home__profile__option__img"
                    />
                    <span>{profile.name}</span>
                  </div>
                ))}
              </div>
            )}
          </div>
        </div>
      </div>
    </header>
  );
}

export default Navbar; 