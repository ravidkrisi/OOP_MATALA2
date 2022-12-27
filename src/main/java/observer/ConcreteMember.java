package observer;

public class ConcreteMember implements Member
{
    //intialize the UndoableStringBuilder and set var for name
    private UndoableStringBuilder client=new UndoableStringBuilder();
    private String name;

    //counstructor for ConcreteMember gets String for name and String to append the UndoableStringBuilder
    public ConcreteMember(String name, String s)
    {
    this.client.append(s);
    this.name = name;
    }

    @Override
    //method gets UndoableStringBuilder and update the UndoableStringBuilder
    public void update(UndoableStringBuilder usb)
    {
    this.client=usb;
    }

    @Override
    //toString method for ConcreteMember
    public String toString()
    {
    return this.client.toString();
    }

    //getter for ConcreteMember
    public UndoableStringBuilder getClient()
    {
    return this.client;
    }

    //getter for name
    public String getName()
    {
    return this.name;
    }
}
