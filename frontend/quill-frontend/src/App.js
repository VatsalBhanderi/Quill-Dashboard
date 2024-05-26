import './App.css';
import Dashboard from './components/Dashboard.tsx';
import { BrowserRouter as Router, Route, Routes, useParams } from 'react-router-dom';

function DashboardWithParams() {
  const { name } = useParams();
  return(<Dashboard
    name={name}
    containerStyle={{ padding: '20px' }}
    onClickDashboardItem={(chart) => console.log('Chart clicked:', chart)}
  />);
}

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/dashboard/:name" element={<DashboardWithParams/>} />
          <Route path="/" element={<h1>Welcome to the Dashboard App</h1>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
