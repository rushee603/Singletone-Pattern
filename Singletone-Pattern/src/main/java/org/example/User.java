package org.example;

public class User {

    //3.create local static varible default null.
    private static User user;

    //1.Constructor
    private User() {}

    //2.static method-factory method to create obj.
    public static User getUser() {

        if (user == null) {
            user = new User();
        }
        return user;
    }


    /*Block synchronized used for targeting only object creation part means new User().
    until and unless !st threat complete his work remain threat swill wait
    */
    public static User getThreadSafeUser() {

        if (user == null) {
            synchronized (User.class){
                if (user == null) {
                    user = new User();
                }
            }
        }
        return user;
    }
}

/*
 *  Lazy Way to obj creation. Not considered multi-thread part -NOT THREAD SAFE-
 *
 * Steps:
 *   1. Constructor is imp due to creation ob obj. so Making the constructor private is important to restrict object creation.
 *   2. Create static method to create obj of this class.
 *   3. Make sure creation of object should happen only 1st time-if condition to check the user is null or not if yes then only create new obj of user.
 *   4. Create one static local variable with default value null.
 *   5. get instance of class in main method access the getUser method print 2 obj and RUN you will get same hashCode.
 *
 *    NOTE: We can use refection API, Deserialization, Obj Cloning to break the singleton design pattern.
 *
 */
