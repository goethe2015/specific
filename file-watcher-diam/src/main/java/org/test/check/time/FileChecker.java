package org.test.check.time;

import java.io.File;
import java.util.TimerTask;

public class FileChecker extends TimerTask{

	private long timestamp;
	private File file;
	protected boolean changed;
	
	public FileChecker(File file) {
		this.timestamp = file.lastModified();
		this.file = file;
	}
	
	public void run(){
		long timestamp = file.lastModified();
		if (this.timestamp != timestamp){
			this.changed=true;
			this.timestamp = timestamp;
		}else{
			this.changed=false;
		}
		System.out.println("Changed? " + this.changed + " Time: " + this.scheduledExecutionTime());
	}

	public boolean isChanged() {
		return changed;
	}
	
}
