package observer;

public class main {
    public static void main(String[] args)
    {
        GroupAdmin manger = new GroupAdmin();

        ConcreteMember c1 = new ConcreteMember();
        ConcreteMember c2 = new ConcreteMember();
        ConcreteMember c3 = new ConcreteMember();

        UndoableStringBuilder s1 = new UndoableStringBuilder();
        UndoableStringBuilder s2 = new UndoableStringBuilder();
        UndoableStringBuilder s3 = new UndoableStringBuilder();

        s1.append("maya");
        s2.append("ravid");
        s3.append("matala");

        c1.update(s1);
        c2.update(s2);
        c3.update(s3);

        manger.register(c1);
        manger.register(c2);
        manger.register(c3);

        System.out.println(c1.client.toString());
        System.out.println(c2.client.toString());
        System.out.println(c3.client.toString());

        manger.append("its working");
        manger.notifyClients();

        System.out.println(c1.client.toString());
        System.out.println(c2.client.toString());
        System.out.println(c3.client.toString());
    }
}
