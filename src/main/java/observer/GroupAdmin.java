package observer;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAdmin implements Sender
{
    //initialize HashMap for clients set key to member name and value to member
    //and initialize UndoableStringBuilder for GroupAdmin
    private HashMap <String, Member> clients = new HashMap<String, Member>();
    private UndoableStringBuilder mode=new UndoableStringBuilder();

    //constructor for groupAdmin get string to append to the UndoableStringBuilder
    public GroupAdmin(String mode)
    {
    this.mode.append(mode);
    }

    @Override
    // gets a Member obj and put it in the HashMap by his name
    public void register(Member obj)
    {
    this.clients.put(obj.getName(), obj);
    }

    @Override
    // gets a client and removes it from the Hashmap by its name
    public void unregister(Member obj)
    {
    this.clients.remove(obj.getName());
    }

    @Override
    //get an offset value and String obj and insert it to the offest in UndoableStringBuilder
    public void insert(int offset, String obj)
    {
    this.mode.insert(offset, obj);

    }

    @Override
    //gets a String and append it to the end of the UndoableStringBuilder
    public void append(String obj)
    {
    this.mode.append(obj);
    }

    @Override
    //get index start and index end to delete characters in UndoableStringBuilder
    public void delete(int start, int end)
    {
    this.mode.delete(start, end);
    }

    @Override
    //undo the last func applied on UndoableStringBuilder
    public void undo()
    {
    this.mode.undo();
    }

    // loop over all the HashMap and update the UndoableStringBuilder in each to the groupadmin UndoableStringBuilder
    public void notifyClients()
    {
        for(Member client : this.clients.values())
        {
            client.update(this.mode);
        }
    }

    //return the Hashmap
    public HashMap<String, Member> getClients()
    {
        return this.clients;
    }

    @Override
    //prints all the members and their UndoableStringBuilder values
    public String toString()
    {
    String all="";
    for(String client: this.clients.keySet())
    {
        all+=client+": "+this.clients.get(client).toString()+" ";
    }
    return all.strip();
    }

    //return the UndoableStringBuilder
    public UndoableStringBuilder getMode()
    {
        return mode;
    }
}
