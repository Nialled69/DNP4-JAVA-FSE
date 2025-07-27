import React from 'react';
import CohortDetails from './CohortDetails.jsx';

function Cohorts() {
  const cohortData = [
    {
      id: 1,
      name: 'INTADMDF10 - .NET FSD',
      startedOn: '22-Feb-2022',
      status: 'Scheduled',
      coach: 'Aathma',
      trainer: 'Jojo Jose',
    },
    {
      id: 2,
      name: 'ADM21JF014 - Java FSD',
      startedOn: '10-Sep-2021',
      status: 'Ongoing',
      coach: 'Apoorv',
      trainer: 'Elisa Smith',
    },
    {
      id: 3,
      name: 'CDBJF21025 - Java FSD',
      startedOn: '24-Dec-2021',
      status: 'Ongoing',
      coach: 'Aathma',
      trainer: 'John Doe',
    },
  ];

  return (
    <div>
      {cohortData.map((cohort) => (
        <CohortDetails key={cohort.id} cohort={cohort} />
      ))}
    </div>
  );
}

export default Cohorts;