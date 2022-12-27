
# OOP ASSIGMANT 1

created by: Maya Zand and Ravid Krisi

# about this project

in this project we implement the observer design pattern
on The first assigmant we created- UndoAbleStringBuilder

# Observer
The observer design pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods. It is mainly used to implement distributed event handling systems.

# GroupAdmin
in the Observer architecture GroupAdmin is the object that handles the observers.
it holds an HashMap which supposed to conatain the observers list and UndoAbleStringBuilder that will contain the string we want to notify to all the observers

# ConcreteMember
in the Observer architecture the ConcreteMember is an object that will be added to the observers list of the GroupAdmin.
it holds a Name to identify it in the HashMap and UndoAbleStringBuilder that will contain the string

# Tests
test were made to test all func created in GroupAdmin, ConcreteMember and a test to check the efficeny of our memory usage.
