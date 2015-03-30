import com.joshzana.Graph;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class GraphTest extends TestCase
{
    private Graph mGraph;
    private Graph.Vertex mSingleSource;
    private Graph.Vertex mSingleDest;
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        Graph.Vertex s = new Graph.Vertex("s");
        Graph.Vertex t = new Graph.Vertex("t");
        Graph.Vertex x = new Graph.Vertex("x");
        Graph.Vertex y = new Graph.Vertex("y");
        Graph.Vertex z = new Graph.Vertex("z");

        s.edges.add(new Graph.Edge(t, 10));
        s.edges.add(new Graph.Edge(y, 5));

        t.edges.add(new Graph.Edge(x, 1));
        t.edges.add(new Graph.Edge(y, 2));

        y.edges.add(new Graph.Edge(t, 3));
        y.edges.add(new Graph.Edge(z, 2));
        y.edges.add(new Graph.Edge(x, 9));

        x.edges.add(new Graph.Edge(z, 4));

        z.edges.add(new Graph.Edge(x, 6));
        z.edges.add(new Graph.Edge(s, 7));

        mGraph = new Graph();
        mGraph.addVertex(s);
        mGraph.addVertex(t);
        mGraph.addVertex(x);
        mGraph.addVertex(y);
        mGraph.addVertex(z);

        mSingleSource = s;
        mSingleDest = x;
    }

    @Test
    public void testDjikstras()
    {
        List<Graph.Vertex> path = mGraph.shortestPathsDjikstras(mSingleSource, mSingleDest);

        for(Graph.Vertex v : path)
        {
            System.out.println(v);
        }
    }
}