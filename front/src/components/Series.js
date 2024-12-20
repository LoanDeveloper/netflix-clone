import { useState, useEffect } from 'react';
import axios from 'axios';
import Navbar from './Navbar';
import MediaGrid from './MediaGrid';

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
      <Navbar />
      <MediaGrid items={series} title="Séries Populaires" />
    </div>
  );
}

export default Series; 