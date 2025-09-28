import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import EmployeeList from './components/EmployeeList';
import AddEmployee from './components/AddEmployee';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/employees" element={<EmployeeList />} />
                <Route path="/add-employee" element={<AddEmployee />} />
            </Routes>
        </Router>
    );
}

export default App;
