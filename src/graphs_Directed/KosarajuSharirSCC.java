/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs_Directed;

/**
 *
 * @author Israel
 */
public class KosarajuSharirSCC {

    private boolean[] marked; // reached vertices
    private int[] id; // component identifiers
    private int count; // number of strong components

    public KosarajuSharirSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
     
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("G.reverse");
        Digraph gR= G.reverse();
        
        StdOut.println(gR);
         System.out.println("Adjacency");
         for (int i = 0; i < gR.V(); i++) {
             System.out.print("["+i+"]: ");
             for (int j :gR.adj(i)) {
                 System.out.print(j+" ");
             }
              
             System.out.println("");
             
        }
         
          System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
          DepthFirstOrder2 order = new DepthFirstOrder2(G.reverse());
          System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
          System.out.println("order.Post-> ");
        for (int v : order.post()) {
            StdOut.print(v + " ");
        }
        System.out.println("");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
