import { useState, useEffect } from 'react';
import axios from 'axios';
import Navbar from './Navbar';
import MediaGrid from './MediaGrid';

function Series() {
  const [series, setSeries] = useState([]);

  useEffect(() => {
    const fetchSeries = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/videos/series');
        setSeries(response.data);
      } catch (error) {
        console.error("Erreur lors de la récupération des séries:", error);
      }
    };

    fetchSeries();
  }, []);

  return (
    <div className="home">
      <Navbar />
      <MediaGrid items={series} title="Séries" />
    </div>
  );
}

export default Series; 