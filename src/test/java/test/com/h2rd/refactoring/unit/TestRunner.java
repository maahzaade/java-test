package test.com.h2rd.refactoring.unit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
