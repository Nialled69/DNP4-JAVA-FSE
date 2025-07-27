import React from 'react';
import '../Stylesheets/mystyle.css';

const CalculateScore = ({ Name, School, Total, goal }) => {
    const percentage = (Total / 500) * 100;

    const getGrade = (percentage) => {
        if (percentage >= 90) return 'A+';
        if (percentage >= 80) return 'A';
        if (percentage >= 70) return 'B';
        if (percentage >= 60) return 'C';
        if (percentage >= 50) return 'D';
        return 'F';
    };

    return (
        <div className="student-card">
            <div className="card-header">
                <h1>Student Details</h1>
            </div>
            <div className="card-body">
                <p><b>Name:</b> {Name}</p>
                <p><b>School:</b> {School}</p>
                <p><b>Total Marks:</b> {Total}</p>
                <p><b>Percentage:</b> {percentage.toFixed(2)}%</p>
                <p><b>Grade:</b> {getGrade(percentage)}</p>
                <p><b>Goal:</b> {goal}</p>
            </div>
        </div>
    );
};

export default CalculateScore;