package observer;

/**
 * @author Maya Zand (318964699) && Ravid Krisi (209373331)
 * @version 1.0
 */

public class ConcreteMember implements Member
{
    /**
    intialize the UndoableStringBuilder and set var for name
     */
    private UndoableStringBuilder client=new UndoableStringBuilder();
    private String name;

    /**
    //Counstructor for ConcreteMember gets String for name and String to append the UndoableStringBuilder
    */
     public ConcreteMember(String name, String s)
    {
    this.client.append(s);
    this.name = name;
    }

    @Override
    /**
     * This method gets UndoableStringBuilder and update it
     */
    public void update(UndoableStringBuilder usb)
    {
    this.client=usb;
    }

    @Override
    /**
    This method turns the ConcreteMember object into String
     */
    public String toString()
    {
    return this.client.toString();
    }

    /**
     * getter for ConcreteMember
     */
    public UndoableStringBuilder getClient()
    {
    return this.client;
    }

    /**
     * getter for name
     */
    public String getName()
    {
    return this.name;
    }
}
