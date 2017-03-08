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
    // 6. simple pages tests, e.g. assert the "todos" title is displayed, assert the main input field display, assert the All/Active/Completed buttons are displayed etc
    // 6. text overload - negative, e.g. that we can add 1,000 character strings etc
    // 7. text validation - negative, e.g. assert that the text input is the same as the text displayed

    public static void main (String[] args)
    {
        String browser = "chrome";

        String[] testCases = {"testcase1", "testcase2", "testcase3", "testcase4", "testcase5"};

        for(String tc : testCases){
            TestCase tc1 = new TestCase(tc, browser);
        }
    }

    public static String getFolder(){
        return "G:\\ShareOne\\Cliff\\Dev\\seleniumjava";
    }
}
