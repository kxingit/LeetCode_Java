/*
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
// TLE: 155 / 158 test cases passed.
public class Solution {
    public int res = 0;
    public static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int[][] grid;
    public int m, n;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // 1:22 - 1:40
        this.m = m;
        this.n = n;
        List<Integer> result = new ArrayList();
        grid = new int[m][n];
        for(int ipos = 0; ipos < positions.length; ipos++) {
            int i = positions[ipos][0], j = positions[ipos][1];
            res++;
            grid[i][j] = 2;
            for(int[] dir : directions) {
                int x = i + dir[0], y = j + dir[1];
                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                if(grid[x][y] != 1) continue;
                dfs(x, y, 1, 2);
                res--;
            }
            result.add(res);
            dfs(i, j, 2 ,1);
        }
        
        return result;
    }
    
    public void dfs(int i, int j, int oldn, int newn) {
        if(grid[i][j] != oldn) return;
        grid[i][j] = newn;
        for(int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            dfs(x, y, oldn, newn);
        }
    }
}

// v2
public class Solution {
    int converttoId(int x, int y, int m){
        return x*m + y;
    }
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int n, int m){
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < m; j++) {
                    int id = converttoId(i,j,m);
                    father.put(id, id);
                }
            }
        }
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = x;
            while(fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;
                
        }
        
        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
    
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        if(positions == null) {
            return ans;
        }
        
        int []dx = {0,-1, 0, 1};
        int []dy = {1, 0, -1, 0};
        int [][]island = new int[n][m];
       
        
        UnionFind uf = new UnionFind(n, m);
        int count = 0;
        
        for(int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if(island[x][y] != 1) {
                count ++;
                island[x][y]  = 1;
                int id = converttoId(x,y , m);
                for(int j = 0 ; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1)
                    {
                        int nid = converttoId(nx, ny, m);
                        
                        int fa = uf.compressed_find(id);
                        int nfa = uf.compressed_find(nid);
                        if(fa != nfa) {
                            count--;
                            uf.union(id, nid);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}


// v3
public class Solution {
    int m, n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int convertId(int x, int y) {
        return x * n + y;
    }
    
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        
        UnionFind(int n, int m){
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < m; j++) {
                    int id = convertId(i,j);
                    father.put(id, id); 
                }
            }
        }
        
        int find(int x){
            int fa =  father.get(x);
            while(fa!=father.get(fa)) {
                father.put(x, father.get(fa)); // compress
                fa = father.get(fa);
            }
            return fa;
        }
        
        void union(int x, int y){
            if(find(x) != find(y))
                father.put(find(x), find(y)); // union fathers!!
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // 2:50 - 4:03 -- union fathers! this.m typo
        // UnionFind
        int count = 0;
        List<Integer> res = new ArrayList();
        if(positions == null) return res;
 
        this.m = m;
        this.n = n;
        int[][] grid = new int[m][n];
        UnionFind uf = new UnionFind(m, n);
        
        for(int[] pos : positions) {
            int i = pos[0], j = pos[1];
            if(grid[i][j] != 1) {
                count++;
                grid[i][j] = 1;
                for(int[] dir : directions) {
                    int x = i + dir[0], y = j + dir[1];
                    if(x < 0 || y < 0 || x >= m || y >= n) continue;
                    if(grid[x][y] != 1) continue;
                    int idij = convertId(i, j), idxy = convertId(x, y);
                    if(uf.find(idij) != uf.find(idxy)) {
                        count--;
                        uf.union(idij, idxy);
                    }
                }
            }
            res.add(count);
        }
        
        return res;
    }
}

// v4
public class Solution {
    // 4:06 - 4:17
    int m, n;
    
    public int convert(int i, int j) {
        return i * n + j;
    }
    
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap();
        
        UnionFind(int m, int n) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    int id = convert(i, j);
                    father.put(id, id);
                }
            }
        }
        
        int find(int x) {
            int fa = father.get(x);
            while(fa != father.get(fa)) {
                father.put(x, father.get(fa));
                fa = father.get(fa);
            }
            return fa;
        }
        
        void union(int x, int y) {
            father.put(find(x), find(y));
        }
    }
    
    
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList();
        if(m == 0) return res;
        this.m = m;
        this.n = n;
        UnionFind uf = new UnionFind(m, n);
        int[][] grid = new int[m][n];
        
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] pos : positions) {
            int i = pos[0], j = pos[1];
            grid[i][j] = 1;
            count++;
            for(int[] dir : directions) {
                int x = i + dir[0], y = j + dir[1];
                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                if(grid[x][y] != 1) continue;
                int id = convert(i, j), idnew = convert(x, y);
                if(uf.find(id) != uf.find(idnew)) {
                    count--;
                    uf.union(id, idnew);
                }
            }
            res.add(count);
        }
        
        return res;
    }
}
