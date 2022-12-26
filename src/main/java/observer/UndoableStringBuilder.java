package observer;


import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Maya Zand(318964699) && Ravid Krisi(209373331)
 * @version 1.0
 */
public class UndoableStringBuilder
{
    private StringBuilder stb;
    private Stack<String> stk;

    /**
     * this is the constructor of the class.
     */
    public UndoableStringBuilder()
    {
        stb = new StringBuilder();
        stk = new Stack<>();
    }

    /**
     * This function appends the specified string to this character sequence.
     * @param str is the string that will append to the character sequence.
     * @return the value of the character sequence after the appending.
     */
    public UndoableStringBuilder append(String str)
    {
        stk.push(stb.toString());
        stb.append(str);
        return this;
    }

    /**
     * This function removes the characters in a substring of this sequence.
     * @param start is the first index in the character sequence
     * @param end is the last index in the character sequence
     * @return the value of the character sequence after the deletion.
     */
    public UndoableStringBuilder delete(int start, int end)
    {
        try
        {
            stk.push(stb.toString());
            stb.delete(start, end);
        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.err.println("ERROR: delete index out of bound exception");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("ERROR: delete index out of bound exception");
        }
        return this;
    }

    /**
     * This function Inserts the string into this character sequence.
     * @param offset is the index where we want to insert the string
     * @param str is the String that will insert into the character sequence.
     * @return the value of the character sequence after the insertion.
     */
    public UndoableStringBuilder insert(int offset, String str)
    {
        try
        {
            stk.push(stb.toString());
            stb.insert(offset, str);
        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.err.println("index out of bound");
        }

        return this;
    }

    /**
     * This function replaces the characters in a substring of this sequence with characters in
     * the specified String. The substring begins at the specified start and
     * extends to the character at index end - 1, or to the end of the sequence if
     * no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be
     * lengthened to accommodate the specified String if necessary)
     * @param start - the index we want to start to replace our characters with the string
     * @param end - the index we want to end to replace our characters with the string
     * @param str - the string we want to replace with the characters sequence
     * @return the value of the character sequence after the replacement.
     */
    public UndoableStringBuilder replace(int start,int end, String str)
    {
        if(str!=null)
        {
            try {
                stk.push(stb.toString());
                stb.replace(start, end, str);
            } catch (StringIndexOutOfBoundsException e) {
                System.err.println("index out of bound");
            }
        }
        return this;
    }

    /**
     * This function causes this character sequence to be replaced by the reverse of the
     * sequence.
     * @return the reverse of the sequence.
     */
    public UndoableStringBuilder reverse()
    {
        stk.push(stb.toString());
        stb.reverse();
        return this;
    }

    public void undo ()
    {
        try
        {
            stb= new StringBuilder(stk.pop());
        }
        catch (EmptyStackException e)
        {
            System.err.println("Empty stack - can't undo");
        }

    }

    /**
     * This function returns the string of the last object in the stack.
     */
    public String toString ()
    {
        return stb.toString();
    }

}

