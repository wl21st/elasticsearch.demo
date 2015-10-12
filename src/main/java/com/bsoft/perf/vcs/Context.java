/**
 * 
 */
package com.bsoft.perf.vcs;

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

	}

	private static void getCPUCores() {
		System.out.println("CPU Cores " + Runtime.getRuntime().availableProcessors());
	}

	private static void getPhysicalMemorySize() {
		com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory
				.getOperatingSystemMXBean();
		long physicalMemorySize = os.getTotalPhysicalMemorySize();

		System.out.println("Physical memory=" + physicalMemorySize);
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
