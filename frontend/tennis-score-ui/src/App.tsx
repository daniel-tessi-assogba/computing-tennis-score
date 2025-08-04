import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [sequence, setSequence] = useState('');
  const [response, setResponse] = useState<any>(null);
  const [error, setError] = useState<string | null>(null);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const res = await axios.post('http://localhost:8080/api/tennis/score', { sequence });
      setResponse(res.data);
      setError(null);
    } catch (err: any) {
      setError(err.message || 'Une erreur s\'est produite');
      setResponse(null);
    }
  };

  return (
      <div className="App">
        <h1>Tennis Score Simulator 🎾</h1>
        <form onSubmit={handleSubmit}>
          <input
              value={sequence}
              onChange={(e) => setSequence(e.target.value)}
              placeholder="Entrez une sequence e.g. ABABABB"
              style={{ width: '300px', padding: '8px', fontSize: '16px' }}
          />
          <button type="submit" style={{ height: '30px', margin: '5px', fontSize: '16px' }}>Jouer aux Scores</button>
        </form>

        {error && <p style={{ color: 'red' }}>{error}</p>}

        {response && (
            <div>
              <h2>Resultats</h2>
              <p><strong>Gagnant:</strong> {response.winner || 'Aucun gagnant en ce moment'}</p>
              <p><strong>En ballotage:</strong> {response.deuce ? 'Oui' : 'Non'}</p>
              {response.advantagePlayer && <p><strong>En avantage:</strong> {response.advantagePlayer}</p>}
              <h3>Historique des points:</h3>
              <ul>
                {response.scoreHistory.map((line: string, idx: number) => (
                    <li key={idx}>{line}</li>
                ))}
              </ul>
            </div>
        )}
      </div>
  );
}

export default App;
