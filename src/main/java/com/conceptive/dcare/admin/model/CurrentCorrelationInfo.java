package com.conceptive.dcare.admin.model;



import org.springframework.stereotype.Component;


@Component
public class CurrentCorrelationInfo {
	 private static CurrentCorrelationInfo instance;

	  private ThreadLocal<CorrelationInfo> threadLocal = new ThreadLocal<CorrelationInfo>();

	  private CurrentCorrelationInfo() {
	    // Do nothing.
	  }

	  /**
	   * Provides singleton access to the threads current correlation info.
	   * 
	   * @return CurrentCorrelationInfo The threads current correlation info.
	   */
	  public static CurrentCorrelationInfo getInstance() {

	    synchronized (CurrentCorrelationInfo.class) {
	      if (instance == null) {
	        instance = new CurrentCorrelationInfo();
	      }
	    }
	    return instance;

	  }

	  /**
	   * Gets the current thread's correlation info instance.
	   * 
	   * @return CorrelationInfo The correlation info instance for the thread.
	   */
	  public CorrelationInfo get() {

	    CorrelationInfo currentCorrelationInfo = this.threadLocal.get();

//	    if (currentCorrelationInfo == null) {
//	      throw new SystemErrorException("CorrelationInfo does not exist.");
//	    }

	    return currentCorrelationInfo;
	  }

	  /**
	   * Sets the current thread's correlation info instance.
	   * 
	   * @param correlationInfo The correlation info instance.
	   */
	  public void set(CorrelationInfo correlationInfo) {

	    this.threadLocal.set(correlationInfo);

	  }

	  /**
	   * Removes the current threads correlation info instance.
	   */
	  public void remove() {

	    this.threadLocal.remove();
	  }
}
