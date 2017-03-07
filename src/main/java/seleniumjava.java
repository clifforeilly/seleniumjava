/**
 * Created by co17 on 07/03/2017.
 */
public class seleniumjava {

    //tests to include:
    // 1. add a new item - positive
    // 2. delete existing item - positive
    // 3. edit existing item - positive
    // 4. mark as completed - positive
    // 5. filter items - positive
    // 6. add a new item - negative
    // 7. delete existing item - negative
    // 8. edit existing item - negative
    // 9. mark as completed - negative
    // 10. filter items - negative

    public static void main (String[] args)
    {
        String browser = "chrome";

        String[] testCases = {"testcase1", "testcase2", "testcase3", "testcase4", "testcase5"};

        for(String tc : testCases){
            TestCase tc1 = new TestCase(tc, browser);
        }
    }
}
