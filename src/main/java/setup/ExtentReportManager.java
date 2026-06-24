package setup;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}

	public static ExtentReports createInstance() {
		String reportFileName = getReportFileName();

		String outputLocation = System.getProperty("user.dir") + "\\target\\" + reportFileName;
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(outputLocation);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setReportName("Testing");
		sparkReporter.config().setDocumentTitle("Project Extent Report");
		sparkReporter.config().setTheme(Theme.DARK);
		return extent;
	}

	private static String getReportFileName() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timeStamp = dateFormat.format(new Date());
		return "Campus_ExtentReport_" + timeStamp + ".html";
	}

}
