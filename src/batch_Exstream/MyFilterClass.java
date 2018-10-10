package batch_proccess;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilterClass implements FilenameFilter {
	
	private String[] extensionArray = {"xml"};

	@Override
	public boolean accept(File dir, String name) {
		if(dir.exists()) {
			for (String ext : extensionArray){
				if(name.endsWith(ext))
					return true;
			}
		}
		
		return false;
	}

}
