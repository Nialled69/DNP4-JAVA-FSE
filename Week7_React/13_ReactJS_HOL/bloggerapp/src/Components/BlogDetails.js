import React from "react";

const BlogDetails = () => {
  const blogs = [
    { id: 1, title: "What is React?", date: "2025-02-08" },
    { id: 2, title: "Why JSX is Awesome", date: "202-02-09" },
  ];

  return (
    <div>
      <h2>Blog Details</h2>
      <ul>
        {blogs.map((blog) => (
          <li key={blog.id}>
            {blog.title} - <em>{blog.date}</em>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BlogDetails;
