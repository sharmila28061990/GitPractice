package org.rerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailedRerun implements IRetryAnalyzer {
	int min=0;
	int max=4;
	public boolean retry(ITestResult result) {
		if(min<max) {
			min++;
			return true;
		}
		return false;
	}
	
}
