package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest
{

    GroupAdmin manger = new GroupAdmin();

    ConcreteMember r = new ConcreteMember();
    ConcreteMember c2 = new ConcreteMember();
    ConcreteMember c3 = new ConcreteMember();

    UndoableStringBuilder s1 = new UndoableStringBuilder();
    UndoableStringBuilder s2 = new UndoableStringBuilder();
    UndoableStringBuilder s3 = new UndoableStringBuilder();


    @Test
    void update()
    {

    }
}