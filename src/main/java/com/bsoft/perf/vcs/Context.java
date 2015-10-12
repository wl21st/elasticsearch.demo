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

		Properties props = System.getProperties();

		Map<String, Object> sortedEntries = new TreeMap<String, Object>();

		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			sortedEntries.put((String) entry.getKey(), entry.getValue());
		}

		for (Map.Entry<String, Object> entry : sortedEntries.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}

		com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory
				.getOperatingSystemMXBean();
		long physicalMemorySize = os.getTotalPhysicalMemorySize();

		System.out.println("Physical memory=" + physicalMemorySize);

		System.out.println("CPU Cores " + Runtime.getRuntime().availableProcessors());

	}

}
