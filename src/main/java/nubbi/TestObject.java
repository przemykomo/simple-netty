package nubbi;

import java.io.Serializable;

public class TestObject implements Serializable {

    int someInt;
    String someString;

    public TestObject(int value, String text) {
        someInt = value;
        someString = text;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "someInt=" + someInt +
                ", someString='" + someString + '\'' +
                '}';
    }
}
