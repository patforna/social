package social.wall;

import social.posts.Post;

// this is essentially a view wrapper, but I admit it's a bit ugly =/
class WallPost {
    private final Post post;

    public WallPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", post.getUser(), post);
    }

    @Override
    public boolean equals(Object o) {
        return post != null && post.equals(o);
    }

    @Override
    public int hashCode() {
        return post != null ? post.hashCode() : 0;
    }
}
