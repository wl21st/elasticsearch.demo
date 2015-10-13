/**
 * 
 */
package com.bsoft.perf.vcs;

import java.io.File;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * @author lluo
 */
public class Context {

  /**
   * @param args
   */
  public static void main(String[] args) {

    systemContext();

    getPhysicalMemorySize();

    getCPUCores();

    getRuntimeInformation();
    
    JDKManagementFactory.printUsage();

  }

  private static void getCPUCores() {
    System.out
        .println("CPU Cores " + Runtime.getRuntime().availableProcessors());
  }

  private static void getPhysicalMemorySize() {
    com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory
        .getOperatingSystemMXBean();
    long physicalMemorySize = os.getTotalPhysicalMemorySize();

    System.out.println("Physical memory=" + physicalMemorySize);
  }

  private static void getRuntimeInformation() {
    /* Total number of processors or cores available to the JVM */
    System.out.println("Available processors (cores): "
        + Runtime.getRuntime().availableProcessors());

    /* Total amount of free memory available to the JVM */
    System.out
        .println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());

    /* This will return Long.MAX_VALUE if there is no preset limit */
    long maxMemory = Runtime.getRuntime().maxMemory();
    /* Maximum amount of memory the JVM will attempt to use */
    System.out.println("Maximum memory (bytes): "
        + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

    /* Total memory currently available to the JVM */
    System.out.println("Total memory available to JVM (bytes): "
        + Runtime.getRuntime().totalMemory());

    /* Get a list of all filesystem roots on this system */
    File[] roots = File.listRoots();

    /* For each filesystem root, print some info */
    for (File root : roots) {
      System.out.println(String.format(
          "File system root: %s, totol: %.2f(gb), free: %.2f(gb), usable: %.2f(gb)",
          root.getAbsolutePath(),
          root.getTotalSpace() * 1f / 1024 / 1024 / 1024,
          root.getFreeSpace() * 1f / 1024 / 1024 / 1024,
          root.getUsableSpace() * 1f / 1024 / 1024 / 1024));
    }
  }

  /**
   * Interested context include the os/jvm vendor/country/hostname/user
   * name/timezone.
   */
  private static void systemContext() {

    Properties props = System.getProperties();

    Map<String, Object> sortedEntries = new TreeMap<String, Object>();

    for (Map.Entry<Object, Object> entry : props.entrySet()) {
      sortedEntries.put((String) entry.getKey(), entry.getValue());
    }

    for (Map.Entry<String, Object> entry : sortedEntries.entrySet()) {
      System.out.println(entry.getKey() + "=" + entry.getValue());
    }
  }

}
