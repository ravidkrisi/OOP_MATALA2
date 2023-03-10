package observer;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAdmin implements Sender
{
    /**
    initialize HashMap for clients set key to member name and value to member
    and initialize UndoableStringBuilder for GroupAdmin
     */
    private HashMap <String, Member> clients = new HashMap<String, Member>();
    private UndoableStringBuilder mode=new UndoableStringBuilder();

    /**
    constructor for groupAdmin - this method gets string and appends it to the UndoableStringBuilder
     * @param mode the string to append to the manager's UndoAbleStringBuilder
     */
    public GroupAdmin(String mode)
    {
    this.mode.append(mode);
    }

    @Override
    /**
     *This method gets a Member obj and put it in the HashMap by his name
     * @param obj the client to add to the clients HashMap
     */
    public void register(Member obj)
    {
    this.clients.put(obj.getName(), obj);
    }

    @Override
    /**
     *This method gets a client and removes it from the Hashmap by its name
     * @param obj the client to remove from the clients HashMap
     */
    public void unregister(Member obj)
    {
    UndoableStringBuilder r = new UndoableStringBuilder();
    r.append(this.mode.toString());
    this.clients.get(obj.getName()).update(r);
    this.clients.remove(obj.getName());
    }

    @Override
    /**
     *This method gets an offset value and String obj and insert it to the offset in UndoableStringBuilder
     * @param offest the index to start to insert the new String
     * @param obj the String to insert to the manager's UndoAbleStringBuilder
     */
    public void insert(int offset, String obj)
    {
    this.mode.insert(offset, obj);

    }

    @Override
    /**
     *This method gets a String and append it to the end of the UndoableStringBuilder
     * @param obj the String to append to the manager's UndoAbleStringBuilder
     */
    public void append(String obj)
    {
    this.mode.append(obj);
    }

    @Override
    /**
     *This method gets start index and end index to delete characters in UndoableStringBuilder
     * @param start the index to start deleting chars from the string of the manager's UndoAbleStringBuilder
     * @param end the index to end deleting chars from the string of the manager's UndoAbleStringBuilder
     */
    public void delete(int start, int end)
    {
    this.mode.delete(start, end);
    }

    @Override
    /**
     * This function undo the last func applied on UndoableStringBuilder
     */
    public void undo()
    {
    this.mode.undo();
    }

    /**
     * loop over all the HashMap and update the UndoableStringBuilder in each to the groupadmin UndoableStringBuilder
     */
    public void notifyClients()
    {
        for(Member client : this.clients.values())
        {
            client.update(this.mode);
        }
    }

    /**
     *This method returns the Hashmap
     */
    public HashMap<String, Member> getClients()
    {
        return this.clients;
    }

    @Override
    /**
     *This method prints all the members and their UndoableStringBuilder values
     */
    public String toString()
    {
    String all="";
    for(String client: this.clients.keySet())
    {
        all+=client+": "+this.clients.get(client).toString()+" ";
    }
    return all.strip();
    }

    /**
     *This method returns the UndoableStringBuilder
     */
    public UndoableStringBuilder getMode()
    {
        return mode;
    }
}
