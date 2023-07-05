package utils;

public class StopWatch {

  private static long start;
  private static long end;

  public void start() {
    end = 0;
    start = System.currentTimeMillis();
  }

  public long stop() {
    end = System.currentTimeMillis();
    return getDiff();
  }

  public static long getDiff() {
    return end - start;
  }

  public static boolean executedBefore(long millis) {
    return (end - start) < millis;
  }

  public long getElapsedTime() {
    return end;
  }

  public boolean isWithin(long timeAllowed) {
    return getElapsedTime() <= timeAllowed;
  }
}
