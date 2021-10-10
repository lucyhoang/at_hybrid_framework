package reportConfig;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		try {
			if (extent == null) {
				String workingDir = System.getProperty("user.dir");
				extent = new ExtentReports(workingDir + "/Reports/ExtentReportV2_Log.html", true);
			}
		}
		catch (Exception e) {
			return null;
		}
		return extent;
	}
}