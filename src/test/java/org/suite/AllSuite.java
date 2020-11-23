package org.suite;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//SuiteClass using Junit
@RunWith(Suite.class)
@SuiteClasses({SuiteSample.class, SuiteSample1.class, SuiteSample2.class})
public class AllSuite {
@Test
private void resultClass() {
	Result rcc = JUnitCore.runClasses(SuiteSample.class, SuiteSample1.class, SuiteSample2.class);
	int fcc = rcc.getFailureCount();
	System.out.println(fcc);
	int rc = rcc.getRunCount();
	System.out.println(rc);	
	long rtt = rcc.getRunTime();
	System.out.println(rtt);
	List<Failure> fail = rcc.getFailures();
	for (Failure failure : fail) {
		System.out.println(failure.toString());
	}
	
}

}
