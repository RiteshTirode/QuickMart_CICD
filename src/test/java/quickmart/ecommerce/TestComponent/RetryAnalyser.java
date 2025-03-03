package quickmart.ecommerce.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	int count = 0;
	int imax = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (count < imax) {
			count++;
			return true;
		}
		return false;
	}

}
