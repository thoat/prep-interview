import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class GraphAL {
    class Vertex {
        String data;
        ArrayList<Vertex> children = new ArrayList<>();
        boolean visited = false;

        public Vertex(String d) {
            this.data = d;
        }

        public void addChild(Vertex v) {
            this.children.add(v);
        }

        public String toString() {
            return this.data;
        }
    }

    private ArrayList<Vertex> vertices;

    public GraphAL() {
        vertices = new ArrayList<>();
    }

    public Vertex addVertex(String d) {
        for (Vertex v : vertices) {
            if (v.data.equals(d)) {
                return v;
            }
        }
        Vertex newV = new Vertex(d);
        vertices.add(newV);
        return newV;
    }

    public void addEdge(String s, String e) {
        Vertex startV = addVertex(s);
        Vertex endV = addVertex(e);
        startV.addChild(endV);
    }

    public void deleteVertex(String d) {
        Vertex toRemove = null;
        for (Vertex v : vertices) {
            if (v.data.equals(d)) {
                toRemove = v;
                vertices.remove(v);
                break;
            }
        }
        // remove it from all the other nodes' children
        if (toRemove != null) {
            for (Vertex v : vertices) {
                v.children.remove(toRemove);
            }
        }
    }

    public void deleteEdge(String s, String e) {
        int startIndex = findIndex(s);
        int endIndex = findIndex(e);
        if (startIndex == -1 || endIndex == -1) return;
        Vertex startV = vertices.get(startIndex);
        Vertex endV = vertices.get(endIndex);
        startV.children.remove(endV);
    }

    private int findIndex(String d) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).data.equals(d)) return i;
        }
        return -1;
    }

    public ArrayList<Vertex> traverseDFS(String start) {
        if (vertices.isEmpty()) return null;
        ArrayList<Vertex> result = new ArrayList<>();
        int startIndex = findIndex(start);
        if (startIndex > -1) {
            DFS(vertices.get(startIndex), result); // where you start does matter!
            return result;
        } else throw new NoSuchElementException();

    }

    private void DFS(Vertex v, ArrayList<Vertex> aggr_result) {
        if (!v.visited) {
            aggr_result.add(v);
            v.visited = true;
            for (Vertex u : v.children) {
                DFS(u, aggr_result); // don't forget to treat the children with the !visited condition as well!!! Or else, infinite loop!
            }
        }
    }

    public ArrayList<Vertex> traverseBFS(String start) {
        if (vertices.isEmpty()) return null;
        ArrayList<Vertex> result = new ArrayList<>();
        int startIndex = findIndex(start);
        if (startIndex > -1) {
            Queue<Vertex> q = new LinkedList<>();
            Vertex visitingV = vertices.get(startIndex);
            q.add(visitingV);
            visitingV.visited = true; // mark true as soon as enqueued!
            while (!q.isEmpty()) {
                visitingV = q.poll();
                result.add(visitingV); // add to "result" as soon as polled
                for (Vertex u : visitingV.children) { // I don't use addAll or else the while clause will run unnecessary loops on visited nodes
                    if (!u.visited) {
                        q.add(u);
                        u.visited = true;
                    }
                }
            }
            return result;
        } else throw new NoSuchElementException();
    }

    public void resetVisited() {
        for (Vertex v : vertices) {
            v.visited = false;
        }
    }

    public String toString() {
        if (vertices.isEmpty()) return "\tNothing to print!";
        StringBuilder sb = new StringBuilder();
        for (Vertex v : vertices) {
            sb.append(v.data);
            sb.append(" --> ");
            for (Vertex u : v.children) {
                sb.append(u.data);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
