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
public class Topological {
     private Iterable<Integer> order; // topological order
 public Topological(Digraph G)
 {
 DirectedCycle cyclefinder = new DirectedCycle(G);
 if (!cyclefinder.hasCycle())
 {
 DepthFirstOrder dfs = new DepthFirstOrder(G);
 order = dfs.reversePost();
 }
 }
 public Iterable<Integer> order()
 { return order; }
 public boolean isDAG()
 { return order != null; }

}
