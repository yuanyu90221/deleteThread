package deleteGarbage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class DeleteMain implements Runnable{
	private static Logger logger = Logger.getLogger(DeleteMain.class);
	public static final String deleteFolder = "deleteFolder";
	 private static String readFolder="";
	static Properties prop = new Properties();
	public static void main(String[] args) {
		
		DeleteMain dm = new DeleteMain();
		Thread dt = new Thread(dm);
		dt.start();
	}
	
	static {
		loadProperties();
	}
	public static void loadProperties(){
	    InputStream input = null;
	    try {
			input = new FileInputStream("./config/config.properties");
			prop.load(input);
			logger.info("deltefolder:"+ prop.getProperty(deleteFolder));
			readFolder = prop.getProperty(deleteFolder);
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally{
			if(input != null){
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
			logger.info("properties loaded!!");
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			FileTransverse.visitAllDirsAndFiles(new File(readFolder));
		}
	}
}
