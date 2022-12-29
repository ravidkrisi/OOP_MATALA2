import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAdminTest {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
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

        logger.info(() -> JvmUtilities.objectFootprint(c1, c2, c3, manager));
        logger.info(() -> JvmUtilities.objectTotalSize(manager));

        String s = manager.toString();
        assertEquals(manager.getClients().containsKey(c1.getName()), true);

        //check if it adds already registered client
        manager.register(c1);
        assertEquals(manager.getClients().size(), 3);

        logger.info(() -> JvmUtilities.objectFootprint(c1, c2, c3, manager));
        logger.info(() -> JvmUtilities.objectTotalSize(manager));
        logger.info(() -> JvmUtilities.jvmInfo());
    }


    @Test
    void unregister() {
        manager.register(c1);
        manager.register(c2);
        manager.register(c3);

        logger.info(() -> JvmUtilities.objectFootprint(c1, c2, c3, manager));
        logger.info(() -> JvmUtilities.objectTotalSize(manager));

        manager.unregister(c2);

        logger.info(() -> JvmUtilities.objectFootprint(c1, c2, c3, manager));
        logger.info(() -> JvmUtilities.objectTotalSize(manager));

        manager.notifyClients();

        assertEquals(manager.getClients().containsKey(c2.getName()), false);
        assertEquals(manager.getClients().size(), 2);
        assertEquals(c2.getClient().toString(), "manager");

        manager.append("m");
        manager.notifyClients();

        assertEquals(c2.toString(), "manager");

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void insert() {
        logger.info(() -> JvmUtilities.objectTotalSize(manager));
        manager.insert(0, "m");
        logger.info(() -> JvmUtilities.objectTotalSize(manager));

        assertEquals(manager.getMode().toString(), "mmanager");

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void append() {
        logger.info(() -> JvmUtilities.objectTotalSize(manager));
        manager.append("m");
        logger.info(() -> JvmUtilities.objectTotalSize(manager));

        assertEquals(manager.getMode().toString(), "managerm");
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void delete() {
        logger.info(() -> JvmUtilities.objectTotalSize(manager));
        manager.delete(0, 1);
        logger.info(() -> JvmUtilities.objectTotalSize(manager));

        assertEquals(manager.getMode().toString(), "anager");
        logger.info(() -> JvmUtilities.jvmInfo());

    }

    @Test
    void undo() {
        logger.info(() -> JvmUtilities.objectTotalSize(manager));
        manager.append("m");
        logger.info(() -> JvmUtilities.objectTotalSize(manager));
        manager.undo();
        logger.info(() -> JvmUtilities.objectTotalSize(manager));

        assertEquals(manager.getMode().toString(), "manager");
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void notifyClients() {
        logger.info(() -> JvmUtilities.objectTotalSize(manager));
        manager.register(c1);
        manager.register(c2);
        manager.register(c3);
        logger.info(() -> JvmUtilities.objectTotalSize(manager));
        manager.notifyClients();

        for (String client : manager.getClients().keySet()) {
            assertEquals(manager.getClients().containsKey(client), true);
        }
        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
    class ConcreteMemberTest
    {
        public static final Logger logger = LoggerFactory.getLogger(Tests.class);
        //intialize var @manager for GroupAdmin and vars @c1 @c2 @c3 to ConcreteMember
        GroupAdmin manager = new GroupAdmin("manager");

        ConcreteMember c1 = new ConcreteMember("maya", "zand");
        ConcreteMember c2 = new ConcreteMember("ravid", "krisi");
        ConcreteMember c3 = new ConcreteMember("noam", "david");
        @Test
        void update()
        {
            logger.info(() -> JvmUtilities.objectTotalSize(c1));

            UndoableStringBuilder s1 = new UndoableStringBuilder();
            s1.append("ravid");

            c1.update(s1);
            logger.info(() -> JvmUtilities.objectTotalSize(c1));
            assertEquals(c1.toString(), "ravid");
            logger.info(() -> JvmUtilities.jvmInfo());
        }
    }

    public class Tests {
        public static final Logger logger = LoggerFactory.getLogger(Tests.class);

        // stub method to check external dependencies compatibility
//        @Test
//        public void test() {
//
//
//            GroupAdmin manager = new GroupAdmin("manager");
//
//            ConcreteMember c1 = new ConcreteMember("maya", "zand");
//            ConcreteMember c2 = new ConcreteMember("ravid", "krisi");
//            ConcreteMember c3 = new ConcreteMember("noam", "david");
//
//            manager.register(c1);
//            manager.register(c2);
//
//            System.out.println(JvmUtilities.objectTotalSize(manager));
//
//            manager.register(c3);
//
//            manager.notifyClients();
//
//            logger.info(() -> JvmUtilities.objectFootprint(c1));
//
//            logger.info(() -> JvmUtilities.objectFootprint(c1, c2));
//
//            logger.info(() -> JvmUtilities.objectTotalSize(c1));
//
//            logger.info(() -> JvmUtilities.jvmInfo());
//        }
    }

