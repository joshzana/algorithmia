package com.joshzana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Graph
{
    public static class Edge
    {
        public Vertex v;
        public int w;

        public Edge(Vertex v, int w)
        {
            this.v = v;
            this.w = w;
        }
    }

    public static class Vertex
    {
        public String name;
        public ArrayList<Edge> edges = new ArrayList<>();
        public Vertex(String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            return this.name.toString();
        }
    }

    private ArrayList<Vertex> mVertices = new ArrayList<>();

    public void addVertex(Vertex v)
    {
        mVertices.add(v);
    }

    public List<Vertex> shortestPathsDjikstras(Vertex s, Vertex t)
    {
        int V = mVertices.size();
        final HashMap<Vertex, Integer> d = new HashMap<>();
        HashMap<Vertex, Vertex> pi = new HashMap<>();
        initializeSingleSource(s, d, pi);

        PriorityQueue<Vertex> Q = new PriorityQueue<>(new Comparator<Vertex>()
        {
            @Override
            public int compare(Vertex o1, Vertex o2)
            {
                return d.get(o1).compareTo(d.get(o2));
            }

            @Override
            public boolean equals(Object obj)
            {
                return false;
            }
        });

        Q.addAll(mVertices);

        while (!Q.isEmpty())
        {
            Vertex u = Q.poll();
            for(int i=0; i<u.edges.size(); i++)
            {
                if (relax(u, u.edges.get(i), d, pi))
                {
                    // Re-add since d changed
                    Q.remove(u);
                    Q.add(u);
                }
            }
        }

        ArrayList<Vertex> result = new ArrayList<>();
        Vertex cur = t;
        while (cur != s)
        {
            result.add(cur);
            cur = pi.get(cur);
        }
        Collections.reverse(result);

        return result;
    }

    private void initializeSingleSource(Vertex s, HashMap<Vertex, Integer> d, HashMap<Vertex, Vertex>  pi)
    {
        for (Vertex v : mVertices)
        {
            d.put(v, Integer.MAX_VALUE);
            pi.put(v, null);
        }

        d.put(s, 0);
    }


    private boolean relax(Vertex u, Edge e, HashMap<Vertex, Integer> d, HashMap<Vertex, Vertex> pi)
    {
        if (d.get(e.v) > d.get(u) + e.w)
        {
            d.put(e.v, d.get(u) + e.w);
            pi.put(e.v, u);
            return true;
        }

        return false;
    }

}