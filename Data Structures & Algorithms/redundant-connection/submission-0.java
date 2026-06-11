class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i = 1; i <=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if(! union(u, v, parent, rank)) return edge;
        }
        return new int[0];
    }

    public int find(int x, int[] parent) {
        if(x != parent[x]) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    public boolean union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if(rootX == rootY) return false;

        if(rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else if(rank[rootY] > rank[rootX]) parent[rootX] = rootY;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;

    }
}
