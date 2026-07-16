import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {

  // Step 5: Initialize state with empty posts list
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
    console.log("Constructor called!");
  }

  // Step 6: loadPosts() - fetches posts from API
  loadPosts() {
    console.log("loadPosts() called!");
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then(response => response.json())
      .then(data => {
        const postList = data.map(
          item => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts: postList });
        console.log("Posts loaded: " + postList.length);
      })
      .catch(error => {
        console.error("Error loading posts: " + error);
      });
  }

  // Step 7: componentDidMount() - called after component renders
  componentDidMount() {
    console.log("componentDidMount() called!");
    this.loadPosts();
  }

  // Step 9: componentDidCatch() - catches errors in child components
  componentDidCatch(error, info) {
    console.log("componentDidCatch() called!");
    alert("An error occurred: " + error);
  }

  // Step 8: render() - displays posts
  render() {
    console.log("render() called!");
    return (
      <div style={styles.container}>
        <h1 style={styles.heading}>Blog Posts</h1>
        <p style={styles.count}>
          Total Posts: {this.state.posts.length}
        </p>
        {this.state.posts.length === 0 ? (
          <p style={styles.loading}>Loading posts...</p>
        ) : (
          this.state.posts.map(post => (
            <div key={post.id} style={styles.card}>
              <h3 style={styles.title}>
                {post.id}. {post.title}
              </h3>
              <p style={styles.body}>{post.body}</p>
            </div>
          ))
        )}
      </div>
    );
  }
}

const styles = {
  container: {
    maxWidth: "800px",
    margin: "0 auto",
    padding: "20px",
    fontFamily: "Arial, sans-serif"
  },
  heading: {
    textAlign: "center",
    color: "#2c3e50",
    fontSize: "32px",
    marginBottom: "10px"
  },
  count: {
    textAlign: "center",
    color: "#666",
    marginBottom: "20px"
  },
  loading: {
    textAlign: "center",
    color: "#999",
    fontSize: "18px"
  },
  card: {
    backgroundColor: "#fff",
    border: "1px solid #ddd",
    borderRadius: "8px",
    padding: "15px",
    marginBottom: "15px",
    boxShadow: "0 2px 4px rgba(0,0,0,0.1)"
  },
  title: {
    color: "#2980b9",
    fontSize: "16px",
    marginBottom: "8px",
    textTransform: "capitalize"
  },
  body: {
    color: "#555",
    fontSize: "14px",
    lineHeight: "1.6"
  }
};

export default Posts;
