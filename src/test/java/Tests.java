import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAdminTest {
    //intialize var @manager for GroupAdmin and vars @c1 @c2 @c3 to ConcreteMember
    GroupAdmin manager = new GroupAdmin("manager");

    ConcreteMember c1 = new ConcreteMember("maya", "zand");
    ConcreteMember c2 = new ConcreteMember("ravid", "krisi");
    ConcreteMember c3 = new ConcreteMember("noam", "david");


    @Test
    void register() {
        manager.register(c1);
        manager.register(c2);
        manager.register(c3);

        String s = manager.toString();
        assertEquals(manager.getClients().containsKey(c1.getName()), true);

        //check if it adds already registered client
        manager.register(c1);
        assertEquals(manager.getClients().size(), 3);
    }


    @Test
    void unregister() {
        manager.register(c1);
        manager.register(c2);
        manager.register(c3);

        manager.unregister(c2);

        manager.notifyClients();
        assertEquals(manager.getClients().containsKey(c2.getName()), false);
        assertEquals(manager.getClients().size(), 2);
        assertEquals(c2.getClient(), null);
    }

    @Test
    void insert() {
        manager.insert(0, "m");

        assertEquals(manager.getMode().toString(), "mmanager");
    }

    @Test
    void append() {
        manager.append("m");

        assertEquals(manager.getMode().toString(), "managerm");
    }

    @Test
    void delete() {
        manager.delete(0, 1);

        assertEquals(manager.getMode().toString(), "anager");
    }

    @Test
    void undo() {
        manager.append("m");
        manager.undo();

        assertEquals(manager.getMode().toString(), "manager");
    }

    @Test
    void notifyClients() {
        manager.register(c1);
        manager.register(c2);
        manager.register(c3);

        manager.notifyClients();

        for (String client : manager.getClients().keySet()) {
            assertEquals(manager.getClients().containsKey(client), true);
        }
    }
}
    class ConcreteMemberTest
    {
        //intialize var @manager for GroupAdmin and vars @c1 @c2 @c3 to ConcreteMember
        GroupAdmin manager = new GroupAdmin("manager");

        ConcreteMember c1 = new ConcreteMember("maya", "zand");
        ConcreteMember c2 = new ConcreteMember("ravid", "krisi");
        ConcreteMember c3 = new ConcreteMember("noam", "david");
        @Test
        void update()
        {
            UndoableStringBuilder s1 = new UndoableStringBuilder();
            s1.append("ravid");

            c1.update(s1);
            assertEquals(c1.toString(), "ravid");
        }
    }

    public class Tests {
        public static final Logger logger = LoggerFactory.getLogger(Tests.class);

        // stub method to check external dependencies compatibility
        @Test
        public void test() {


            GroupAdmin manager = new GroupAdmin("manager");

            ConcreteMember c1 = new ConcreteMember("maya", "zand");
            ConcreteMember c2 = new ConcreteMember("ravid", "krisi");
            ConcreteMember c3 = new ConcreteMember("noam", "david");

            manager.register(c1);
            manager.register(c2);

            System.out.println(JvmUtilities.objectTotalSize(manager));

            manager.register(c3);

            manager.notifyClients();

            logger.info(() -> JvmUtilities.objectFootprint(c1));

            logger.info(() -> JvmUtilities.objectFootprint(c1, c2));

            logger.info(() -> JvmUtilities.objectTotalSize(c1));

            logger.info(() -> JvmUtilities.jvmInfo());
        }
    }

