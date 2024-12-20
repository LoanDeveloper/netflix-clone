import { useState, useEffect } from 'react';
import axios from 'axios';
import Navbar from './Navbar';
import MediaGrid from './MediaGrid';

function Home() {
  const [films, setFilms] = useState([]);

  useEffect(() => {
    const fetchFilms = async () => {
      try {
        const response = await axios.get('https://api.themoviedb.org/3/trending/all/day', {
          params: {
            api_key: '8b57178a015d25ef9d928ebbd11596f5',
            language: 'fr-FR'
          }
        });
        setFilms(response.data.results);
      } catch (error) {
        console.error("Erreur lors de la récupération des films:", error);
      }
    };

    fetchFilms();
  }, []);

  return (
    <div className="home">
      <Navbar />
      <MediaGrid items={films} title="Tendances" />
    </div>
  );
}

export default Home; 