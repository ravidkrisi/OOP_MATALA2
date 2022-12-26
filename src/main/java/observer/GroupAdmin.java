package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender
{
    private ArrayList <Member> clients = new ArrayList<Member>();
    private UndoableStringBuilder mode = new UndoableStringBuilder();

    @Override
    // add a new client to the clients list
    public void register(Member obj)
    {
    this.clients.add(obj);
    }

    @Override
    // gets a client and removes it from the clients list
    public void unregister(Member obj)
    {
    this.clients.remove(obj);
    }

    @Override
    //Inserts the string into this character sequence.
    public void insert(int offset, String obj)
    {
    this.mode.insert(offset, obj);

    }

    @Override
    public void append(String obj)
    {
    this.mode.append(obj);
    }

    @Override
    public void delete(int start, int end)
    {
    this.mode.delete(start, end);
    }

    @Override
    public void undo()
    {
    this.mode.undo();
    }

    public void notifyClients()
    {
        for(Member client : this.clients)
        {
            client.update(this.mode);
        }
    }
}
