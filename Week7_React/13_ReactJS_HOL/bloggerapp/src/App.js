import React, { useState } from "react";
import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {
  const [section, setSection] = useState("");

  return (
    <div>
      <h1>Blogger App</h1>

      <select onChange={(e) => setSection(e.target.value)}>
        <option value="">--Select--</option>
        <option value="book">Book</option>
        <option value="blog">Blog</option>
        <option value="course">Course</option>
      </select>

      {section === "book" && <BookDetails />}
      {section === "blog" && <BlogDetails />}
      {section === "course" && <CourseDetails />}
    </div>
  );
}

export default App;
