public class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        parent = new int [n];
        size = new int [n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        // TODO: 实现路径压缩的查找
        int root = p;
        while(root != parent[root]){
            root = parent[root];
        }
       while(p != root){
           //路径上所有的父都归进root里面
           int next = parent[p];
           parent[p] = root;
           p = next;
       }
       return root;
    }

    public void union(int p, int q) {
        // TODO: 实现加权合并
        if (size[p] < size[q]) {
            parent[p] = q;
            size[q] += size[p];
        } else {
            parent[q] = p;
            size[p] += size[q];
        }

    }

    public boolean connected(int p, int q) {
        // TODO
        return find(p) == find(q);
    }
}

