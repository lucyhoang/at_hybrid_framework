package commons;

import java.io.File;

//Đôi khi không thuận tiện lắm
//Config nên để ở file ngoài để dễ dàng thay đổi mà không cần build 

public class GlobalConstants {
	public static final String DEV_SERVER = "https://demo.nopcommerce.com/";
	public static final String TESTING_SERVER = "";
	public static final String STAGING_SERVER = "";
	public static final long SHORT_TIMEOUT = 30;
	public static final long LONG_TIMEOUT = 60;
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloadFiles";
	
}
