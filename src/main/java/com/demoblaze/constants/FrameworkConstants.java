package com.demoblaze.constants;

/**
 * FrameworkConstants
 *
 * This class contains all framework level constants.
 * No hardcoded values should be used in the framework.
 *
 * @author Gopi Kishan Behera
 */

public final class FrameworkConstants {

	private FrameworkConstants() {
		//Prevent object creation
	}
	
	// ===========================
    // Configuration Files
    // ===========================
	
	public static final String CONFIG_FILE_PATH = "src/main/resources/config/config.properties";
			
	public static final String QA_CONFIG_FILE_PATH = "src/main/resources/config/qa.properties";
	
	public static final String STAGE_CONFIG_FILE_PATH = "src/main/resources/config/stage.properties";

    public static final String PROD_CONFIG_FILE_PATH = "src/main/resources/config/prod.properties";
    
   
    // ===========================
    // Test Data
    // ===========================
    
    public static final String EXCEL_PATH = "src/test/resources/testdata/excel/";

    public static final String JSON_PATH = "src/test/resources/testdata/json/";

    public static final String CSV_PATH = "src/test/resources/testdata/csv/";
    
    
 // ===========================
    // Reports
    // ===========================

    public static final String ALLURE_RESULTS =
            "allure-results/";

    public static final String ALLURE_REPORT =
            "allure-report/";

    public static final String SCREENSHOT_PATH =
            "screenshots/";

    public static final String LOG_PATH =
            "logs/";

    // ===========================
    // Timeouts
    // ===========================

    public static final int IMPLICIT_WAIT = 10;

    public static final int EXPLICIT_WAIT = 20;

    public static final int PAGE_LOAD_TIMEOUT = 60;
}
