package observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest
{
    GroupAdmin manger = new GroupAdmin();

    ConcreteMember c1 = new ConcreteMember();
    ConcreteMember c2 = new ConcreteMember();
    ConcreteMember c3 = new ConcreteMember();

    UndoableStringBuilder s1 = new UndoableStringBuilder();
    UndoableStringBuilder s2 = new UndoableStringBuilder();
    UndoableStringBuilder s3 = new UndoableStringBuilder();




    @Test
    void register()
    {

    s1.append("ravid");
    s2.append("maya");
    s3.append("naomi");

    c1.update(s1);
    c2.update(s2);
    c3.update(s3);

    manger.register(c1);
    manger.register(c2);
    manger.register(c3);

    String output = manger.toString();

    assertEquals("ravid maya naomi",output);
    }

    @Test
    void unregister()
    {
    s1.append("ravid");
    s2.append("maya");
    s3.append("naomi");

    c1.update(s1);
    c2.update(s2);
    c3.update(s3);

    manger.register(c1);
    manger.register(c2);
    manger.register(c3);

    manger.unregister(c1);

    String output = manger.toString();

    assertEquals("maya naomi",output);
    }

    @Test
    void insert()
    {

    }

    @Test
    void append()
    {
    }

    @Test
    void delete()
    {
    }

    @Test
    void undo()
    {
    }

    @Test
    void notifyClients()
    {
    }
}