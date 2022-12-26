package observer;

public class ConcreteMember implements Member
{
    public UndoableStringBuilder client;
    @Override
    public void update(UndoableStringBuilder usb)
    {
    this.client=usb;
    }

    @Override
    public String toString()
    {
        return this.client.toString();
    }
}
