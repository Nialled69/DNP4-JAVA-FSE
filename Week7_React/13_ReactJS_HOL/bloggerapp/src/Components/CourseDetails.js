import React from "react";

const CourseDetails = () => {
  const courses = [
    { id: 1, name: "React Basics", duration: "4 weeks" },
    { id: 2, name: "React Advanced", duration: "8 weeks" },
  ];

  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            {course.name} - {course.duration}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CourseDetails;
