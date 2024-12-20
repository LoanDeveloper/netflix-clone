import { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function Series() {
  const [series, setSeries] = useState([]);

  useEffect(() => {
    const fetchSeries = async () => {
      try {
        const response = await axios.get('https://api.themoviedb.org/3/tv/popular', {
          params: {
            api_key: '8b57178a015d25ef9d928ebbd11596f5',
            language: 'fr-FR'
          }
        });
        setSeries(response.data.results);
      } catch (error) {
        console.error("Erreur lors de la récupération des séries:", error);
      }
    };

    fetchSeries();
  }, []);

  return (
    <div className="home">
      <header className="home__header">
        <img src="./img/Netflix_2015_logo.svg.png" className="home__netflixLogo" alt="logo"></img>
        <nav className="home__nav">
          <ul className="home__nav__list">
            <li className="home__nav__item"><Link to="/home" className="home__nav__link">Accueil</Link></li>
            <li className="home__nav__item"><Link to="/series" className="home__nav__link">Séries TV</Link></li>
            <li className="home__nav__item"><Link to="/films" className="home__nav__link">Films</Link></li>
            <li className="home__nav__item">Nouveautés</li>
            <li className="home__nav__item">Ma liste</li>
          </ul>
        </nav>
      </header>
      <h2 className="home__title">Séries Populaires</h2>
      <section className="home__films">
        {series.map(serie => (
          <div key={serie.id} className="film__card">
            <img 
              src={`https://image.tmdb.org/t/p/w500${serie.poster_path}`} 
              alt={serie.name}
              className="film__poster"
            />
            <h3 className="film__title">{serie.name}</h3>
          </div>
        ))}
      </section>
    </div>
  );
}

export default Series; 