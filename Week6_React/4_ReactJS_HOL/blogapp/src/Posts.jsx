import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null,
        };
    }

    async loadPosts() {
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');
            if (!response.ok) {
                throw new Error('Failed to fetch posts');
            }
            const data = await response.json();
            const posts = data.map(postData => new Post(postData.id, postData.title, postData.body));
            this.setState({ posts: posts });
        } catch (error) {
            this.setState({ error: error });
        }
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        console.error("Caught an error:", error, info);
        this.setState({ error: error });
    }
    
    render() {
        if (this.state.error) {
             return <h1>Something went wrong.</h1>;
        }

        return (
            <div>
                {this.state.posts.map(post => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;