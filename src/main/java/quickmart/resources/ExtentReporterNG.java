package quickmart.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReporterObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter sparkRep=new ExtentSparkReporter(path);
		sparkRep.config().setReportName("Quick Mart Test Cases");
		sparkRep.config().setDocumentTitle("Quick Mart");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(sparkRep);
		extent.setSystemInfo("Created By: ", "RITESH TIRODE");
		return extent;
	}
	
}
