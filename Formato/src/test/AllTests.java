package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCSV.class, TestJSON.class, TestTXT.class, TestXML.class })
public class AllTests {
}
