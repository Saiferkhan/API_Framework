package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;

    public static ExtentReports createInstance() {
        if (extent == null) {
        	//String reportDir="C:\\Users\\user\\eclipse-workspace\\APIFramework\\target";
            String reportDir = System.getProperty("user.dir") + "/target/APIRepot/";
            String reportPath = reportDir + "ApiRestassuredReport2.html";

            try {
                // ✅ Ensure directory exists (NIO way)
                Files.createDirectories(Paths.get(reportDir));
                System.out.println("Report directory: " + reportDir);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create report directory: " + reportDir, e);
            }

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Api Automation Test Report");
            sparkReporter.config().setReportName("Restassured POM Framework Execution");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
        return extent;
    }

}
