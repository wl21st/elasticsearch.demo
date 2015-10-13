/**
 * 
 */

package com.bsoft.perf.vcs;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNInfo;
import org.tmatesoft.svn.core.wc.SVNWCClient;

/**
 * Local working copy info.
 * 
 * @author lluo
 */
public class SVNINfoDemo {

  private SVNClientManager clientmanager;

  private String[] wcList = new String[] { "K:\\dev\\main\\build-system",
      "K:\\dev\\main\\main", "K:\\dev\\main\\maestro" };

  /**
   * @param args
   */
  public static void main(String[] args) {

    SVNINfoDemo app = new SVNINfoDemo();

    try {
      app.start();
    } finally {
      app.close();
    }

  }

  public SVNINfoDemo() {

    initialize();

  }

  public void initialize() {
    clientmanager = SVNClientManager.newInstance();
  }

  public void close() {
    if (clientmanager != null) {
      clientmanager.dispose();
    }
  }

  public void start() {
    for (String wcPath : wcList) {
      svnInfo(wcPath);
    }
  }

  public void svnInfo(String wcPath) {

    SVNWCClient wcclient = clientmanager.getWCClient();

    try {

      SVNInfo result = wcclient.doInfo(new File(wcPath), null);

      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println("WC-Path=" + wcPath);
      System.out.println("RepositoryRootURL=" + result.getRepositoryRootURL());
      System.out.println("Repository-UUID=" + result.getRepositoryUUID());
      System.out.println("URL=" + result.getURL());
      System.out.println("Kind=" + result.getKind());

      System.out.println("Rev=" + result.getRevision());

      System.out.println("Committed-Date=" + result.getCommittedDate());
      System.out.println("Committed-Rev=" + result.getCommittedRevision());
      System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

    } catch (SVNException e) {
      e.printStackTrace();
    }

  }

}
