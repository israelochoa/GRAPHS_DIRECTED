/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs_Directed;

import java.util.Iterator;

/**
 *
 * @author Israel
 */
public class Main {
    public static void main(String[] args) {
        In in = new In("digraph1.txt");
        Digraph G = new Digraph(in);
        System.out.println("-------------------------------");
        StdOut.println(G);
       
        System.out.println("-------------------------------");
          System.out.println("-------------------------------");
          System.out.println("G reverse");
        StdOut.println(G.reverse());
       
        System.out.println("-------------------------------");
        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No directed cycle");
        }
        StdOut.println();
        System.out.println("-------------------------------");
        System.out.print("Sources: ");
        Bag<Integer> sources = new Bag<Integer>();
        System.out.println("args.length"+G.V());
        for (int i = 1; i < G.V(); i++) {
            
            sources.add(i);
        }
        
        Iterator<Integer> printSources = sources.iterator();
        while(printSources.hasNext()){
            System.out.print(printSources.next()+", ");
        }
        System.out.println("");
       System.out.println("-------------------------------");
        DirectedDFS reachable = new DirectedDFS(G, sources);
        for (int v = 0; v < G.V(); v++) {
            if (reachable.marked(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();
         DepthFirstOrder dfs = new DepthFirstOrder(G);
        StdOut.println("   v  pre post");
        StdOut.println("--------------");
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
        }

        StdOut.print("Preorder:  ");
        for (int v : dfs.pre()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Postorder: ");
        for (int v : dfs.post()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Reverse postorder: ");
        for (int v : dfs.reversePost()) {
            StdOut.print(v + " ");
        }
        StdOut.println();
        System.out.println("------------------------------");
        StdOut.print("Reverse postorder2: ");
         DepthFirstOrder2 dfs2 = new DepthFirstOrder2(G);
        for (int v : dfs2.reversePost()) {
            StdOut.print(v + " ");
        }
        System.out.println("");
        System.out.println("------------------------------");
        StdOut.print("G reVERSE->Reverse postorder2: ");
         dfs2 = new DepthFirstOrder2(G.reverse());
        for (int v : dfs2.reversePost()) {
            StdOut.print(v + " ");
        }
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("KosarajuSharirSCC");
       
        KosarajuSharirSCC ksscc=new KosarajuSharirSCC(G);
        System.out.println("ksscc.count: "+ksscc.count());
       System.out.println("------------------------------");
       
        
    }

    
}
