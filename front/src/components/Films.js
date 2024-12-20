import { useState, useEffect } from 'react';
import axios from 'axios';
import Navbar from './Navbar';
import MediaGrid from './MediaGrid';

function Films() {
  const [films, setFilms] = useState([]);

  useEffect(() => {
    const fetchFilms = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/videos/movies');
        setFilms(response.data);
      } catch (error) {
        console.error("Erreur lors de la récupération des films:", error);
      }
    };

    fetchFilms();
  }, []);

  return (
    <div className="home">
      <Navbar />
      <MediaGrid items={films} title="Films" />
    </div>
  );
}

export default Films; 