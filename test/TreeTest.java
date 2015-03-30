import com.joshzana.Tree;
import junit.framework.TestCase;
import org.junit.Test;

public class TreeTest extends TestCase
{
    private Tree mTree;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        Tree.Node root = new Tree.Node(-1);
        for (int i = 0; i < 10; i++)
        {
            Tree.Node child = new Tree.Node(i*10);
            for (int j=1; j<10; j++)
            {
                child.addChild(new Tree.Node(i*10+j));
            }
            root.addChild(child);
        }

        mTree = new Tree(root);
    }

    @Test
    public void testBreadthFirstSearch()
    {
        mTree.breadthFirstTraverse(n -> System.out.println(n));
    }

    @Test
    public void testDepthFirstSearch()
    {
        mTree.depthFirstTraversal(n -> System.out.println(n));
    }

    @Test
    public void testDepthFirstSearchRecursive()
    {
        mTree.depthFirstTraversalRecursive(n -> System.out.println(n));
    }
}