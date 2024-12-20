import React from 'react';

function MediaGrid({ items, title }) {
  return (
    <>
      <h2 className="home__title">{title}</h2>
      <section className="home__films">
        {items.map(item => (
          <div key={item.id} className="film__card">
            <img 
              src={`https://image.tmdb.org/t/p/w500${item.poster_path}`} 
              alt={item.title || item.name}
              className="film__poster"
            />
            <h3 className="film__title">{item.title || item.name}</h3>
          </div>
        ))}
      </section>
    </>
  );
}

export default MediaGrid; 