import { useState, useEffect } from 'react';
import axios from 'axios';
import Navbar from './Navbar';
import MediaGrid from './MediaGrid';

function Home() {
  const [videos, setVideos] = useState([]);

  useEffect(() => {
    const fetchVideos = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/videos/all');
        setVideos(response.data);
      } catch (error) {
        console.error("Erreur lors de la récupération des vidéos:", error);
      }
    };

    fetchVideos();
  }, []);

  return (
    <div className="home">
      <Navbar />
      <MediaGrid items={videos} title="Tous les contenus" />
    </div>
  );
}

export default Home; 