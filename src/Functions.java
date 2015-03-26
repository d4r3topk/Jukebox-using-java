import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;


public class Functions extends PlaybackListener implements Runnable{

	private Node currentSong;
	private AdvancedPlayer player;
	private Thread playerThread;
	private int pausedOnFrame;
	static boolean suspendFlag;
	Thread t1;
	public Functions(Node currentSong){
		this.currentSong = currentSong;
		 
	}
	 public Thread NewThread(String threadname) {
	      Thread t = new Thread(this, threadname);
	      System.out.println("New thread: " + t);
	      suspendFlag = false;
	      t.start(); // Start the thread
	      return t;
	   }
	
	public void play() throws Exception {
		try{
			 
			  FileInputStream fis = new FileInputStream(currentSong.filepath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		player = new AdvancedPlayer(bis);
		//player.play(pausedOnFrame, Integer.MAX_VALUE);
		t1 = NewThread("Play");
	}
		catch(FileNotFoundException e1){e1.printStackTrace();}
		
		
	}
	
	public void pause() throws InterruptedException{
		 t1.wait();
      player.setPlayBackListener(new PlaybackListener() {
			
		    @Override
		    public void playbackFinished(PlaybackEvent event) {
		    	pausedOnFrame = event.getFrame();
		    }
		});
      
      //suspendThread();
     // try{
      //playerThread.
      //}catch(Exception ex){ex.printStackTrace();}
	}
      

	void suspendThread() {
		
		suspendFlag = true;
		// TODO Auto-generated method stub
		
	}
	
	/*public synchronized void resumeThread(){
		suspendFlag = false;
		notify();*/
	//}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
							
			player.play(pausedOnFrame, Integer.MAX_VALUE);
			Thread.sleep(200);
			synchronized(this){
				while(suspendFlag)
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			}
	 catch (JavaLayerException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
   } catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	  public void pauseThread() throws InterruptedException
	    {
		  
	        synchronized(this)
	        {
	            wait();
	        }
	    }

	    public void resumeThread()
	    {
	        synchronized(this)
	        {
	            notify();
	        }
	    }
	
}