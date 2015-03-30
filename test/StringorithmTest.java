import com.joshzana.Stringorithm;
import junit.framework.TestCase;
import org.junit.Test;

public class StringorithmTest extends TestCase
{


    @Test
    public void testMatches()
    {
        assertTrue(Stringorithm.followsPattern("a b b a", "cat dog dog cat"));
        assertTrue(Stringorithm.followsPattern("b a a b", "cat dog dog cat"));
        assertTrue(Stringorithm.followsPattern("b a", "cat dog"));
        assertTrue(Stringorithm.followsPattern("bigbigbig", "cat"));
    }

    @Test
    public void testNotMatches()
    {
        assertFalse(Stringorithm.followsPattern("a b a b", "cat dog dog cat"));
        assertFalse(Stringorithm.followsPattern("b a b a", "cat dog dog cat"));
        assertFalse(Stringorithm.followsPattern("b a", "cat dog cat"));
        assertFalse(Stringorithm.followsPattern("bigbigbig", "cat dog"));
    }
}