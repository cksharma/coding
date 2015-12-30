package com.geeks.graph;

import java.util.*;

/**
 * Created by cksharma on 12/28/15.
 */
public class CycleInUndirectedGraph {

    static class Graph {
        List<Vertex> vertices;
        Graph(List<Vertex> vertices) {
            this.vertices = vertices;
        }
    }

    static class Vertex<T> {
        T data;
        List<Edges> edges;
        Vertex(T data) {
            this.data = data;
            this.edges = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex<?> vertex = (Vertex<?>) o;

            return data != null ? data.equals(vertex.data) : vertex.data == null;

        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }
    }

    static class Edges {
        Vertex vertex1;
        Vertex vertex2;
        Edges(Vertex vertex1, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edges edges = (Edges) o;

            if (vertex1 != null ? !vertex1.equals(edges.vertex1) : edges.vertex1 != null) return false;
            return vertex2 != null ? vertex2.equals(edges.vertex2) : edges.vertex2 == null;

        }

        @Override
        public int hashCode() {
            int result = vertex1 != null ? vertex1.hashCode() : 0;
            result = 31 * result + (vertex2 != null ? vertex2.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        CycleInUndirectedGraph cycle = new CycleInUndirectedGraph();
        Vertex<Character> a = new Vertex<>('A');
        Vertex<Character> b = new Vertex<>('B');
        Vertex<Character> c = new Vertex<>('C');
        Vertex<Character> d = new Vertex<>('D');
        Vertex<Character> e = new Vertex<>('E');
        Vertex<Character> f = new Vertex<>('F');

        Edges ab = new Edges(a, b);
        Edges af = new Edges(a, f);
        Edges bc = new Edges(b, c);
        Edges be = new Edges(b, e);
        Edges cd = new Edges(c, d);
        Edges de = new Edges(d, e);

        List<Edges> aEdges = new ArrayList<>(Arrays.asList(ab, af));
        List<Edges> bEdges = new ArrayList<>(Arrays.asList(ab, be, bc));
        List<Edges> cEdges = new ArrayList<>(Arrays.asList(bc, cd));
        List<Edges> dEdges = new ArrayList<>(Arrays.asList(cd, de));
        List<Edges> eEdges = new ArrayList<>(Arrays.asList(be, de));
        List<Edges> fEdges = new ArrayList<>(Arrays.asList(af));

        /*
        List<Edges> aEdges = new ArrayList<>(Arrays.asList(ab, af));
        List<Edges> bEdges = new ArrayList<>(Arrays.asList(ab, bc));
        List<Edges> cEdges = new ArrayList<>(Arrays.asList(bc, cd));
        List<Edges> dEdges = new ArrayList<>(Arrays.asList(cd, de));
        List<Edges> eEdges = new ArrayList<>(Arrays.asList(de));
        List<Edges> fEdges = new ArrayList<>(Arrays.asList(af));
        */

        a.edges = aEdges;   b.edges = bEdges;   c.edges = cEdges;
        d.edges = dEdges;   e.edges = eEdges;   f.edges = fEdges;
        Graph graph = new Graph(new ArrayList<>(Arrays.asList(a, b, c, d, e, f)));

        boolean isCyclePresent = isCyclePresent(graph);
        System.out.println("Cycle present: " + isCyclePresent);
    }

    private static boolean isCyclePresent(Graph graph) {
        return dfs(graph.vertices.get(0), new HashSet<>(), null);
    }

    private static boolean dfs(Vertex<Character> root, Set<Edges> visited, Vertex parent) {
        boolean hasCycle = false;
        for (Edges e : root.edges) {
            Vertex<Character> v = e.vertex1.equals(root) ? e.vertex2 : e.vertex1;
            if (v.equals(parent)) continue;
            if (visited.contains(e) || hasCycle) return true;
            visited.add(e);
            hasCycle = hasCycle || dfs(v, visited, root);
        }
        return hasCycle;
    }
}
