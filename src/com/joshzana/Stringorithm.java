package com.joshzana;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joshzana on 1/29/15.
 */
public class Stringorithm
{

    /**
     * Given a pattern and a string - find if the string follows the same pattern
     * Eg: Pattern : [a b b a], String : cat dog dog cat
     */
    public static boolean followsPattern(String pattern, String example)
    {
        boolean result = true;
        String[] patternChunks = pattern.split(" ");
        String[] exampleChunks = example.split(" ");
        Map<String, String> patternMap = new HashMap<>();

        if (patternChunks.length != exampleChunks.length)
        {
            result = false;
        }
        else
        {
            for (int i=0; i<exampleChunks.length; i++)
            {
                String mapped = patternMap.get(exampleChunks[i]);
                if (mapped == null)
                {
                    patternMap.put(exampleChunks[i], patternChunks[i]);
                }
                else
                {
                    if (!patternChunks[i].equals(mapped))
                    {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;

    }
}
