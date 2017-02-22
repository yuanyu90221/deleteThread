package deleteGarbage;

import java.io.File;

import org.apache.log4j.Logger;

public class FileTransverse {
	private static Logger logger = Logger.getLogger(FileTransverse.class);
	public static void visitAllDirsAndFiles(File dir) {
//	      System.out.println(dir);
	      if (dir.isDirectory()) {
	         String[] children = dir.list();
	         
	         for (int i = 0; i < children.length; i++) {
	            visitAllDirsAndFiles(new File(dir, children[i])); 
	         } 
	      } else if(dir.isFile()){
	    	  // delete logic
	    	 dir.delete();
	    	 logger.info(dir + " is deleted!");
	      }
	   }
}
