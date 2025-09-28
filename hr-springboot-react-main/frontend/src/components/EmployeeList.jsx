import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom'; // برای ناوبری
import axios from 'axios';

const EmployeeList = () => {
    const [employees, setEmployees] = useState([]);
    const navigate = useNavigate(); // hook برای تغییر مسیر

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/employees')
            .then(res => setEmployees(res.data))
            .catch(err => console.error(err));
    }, []);

    return (
        <div>
            <h2>Employee List</h2>
            {/* دکمه افزودن کارمند */}
            <button onClick={() => navigate('/add-employee')} style={{marginBottom: "10px"}}>
                Add Employee
            </button>

            <ul>
                {employees.map(emp => (
                    <li key={emp.id}>{emp.firstName} {emp.lastName} - {emp.emailId}</li>
                ))}
            </ul>
        </div>
    );
};

export default EmployeeList;
