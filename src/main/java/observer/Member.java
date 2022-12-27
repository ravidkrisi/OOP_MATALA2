package observer;

public interface Member
{
        public void update(UndoableStringBuilder usb);

        public String toString();

        public UndoableStringBuilder getClient();

        public String getName();
}
