package com.bsoft.perf.vcs;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.management.MBeanServerConnection;

public class JDKManagementFactory {

  /**
   * This method will print the physical memory usage and the CPU load.
   */
  public static void printUsage() {

    OperatingSystemMXBean operatingSystemMXBean = ManagementFactory
        .getOperatingSystemMXBean();

    for (Method method : operatingSystemMXBean.getClass()
        .getDeclaredMethods()) {

      method.setAccessible(true);

      if (method.getName().startsWith("get")
          && Modifier.isPublic(method.getModifiers())) {
        Object value;

        try {
          value = method.invoke(operatingSystemMXBean);
        } catch (Exception e) {
          value = e;
        } // try

        System.out.println(method.getName() + " = " + value);
      } // if

    } // for

  }

}
