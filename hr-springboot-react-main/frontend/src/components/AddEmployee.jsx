import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const AddEmployee = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [emailId, setEmailId] = useState('');
    const navigate = useNavigate(); // برای برگشت به لیست

    const saveEmployee = (e) => {
        e.preventDefault();
        const employee = { firstName, lastName, emailId };

        axios.post('http://localhost:8080/api/v1/employees', employee)
            .then(() => {
                navigate('/employees'); // بعد از اضافه شدن کارمند به لیست برگرد
            })
            .catch(err => console.error(err));
    };

    return (
        <div>
            <h2>Add Employee</h2>
            <form>
                <div>
                    <label>First Name:</label>
                    <input type="text" value={firstName} onChange={e => setFirstName(e.target.value)} />
                </div>
                <div>
                    <label>Last Name:</label>
                    <input type="text" value={lastName} onChange={e => setLastName(e.target.value)} />
                </div>
                <div>
                    <label>Email:</label>
                    <input type="email" value={emailId} onChange={e => setEmailId(e.target.value)} />
                </div>
                <button onClick={saveEmployee}>Save</button>
            </form>
        </div>
    );
};

export default AddEmployee;
