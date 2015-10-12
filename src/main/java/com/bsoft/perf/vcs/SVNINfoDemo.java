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

	private String srcPath = "/home/sfuser/try/primefaces-read-only/src";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SVNINfoDemo app = new SVNINfoDemo();

		app.start();

	}

	public SVNINfoDemo() {
		clientmanager = SVNClientManager.newInstance();
	}

	public void start() {

		SVNWCClient wcclient = clientmanager.getWCClient();

		try {
			
			SVNInfo result = wcclient.doInfo(new File(srcPath), null);

			System.out.println("Repository-UUID=" + result.getRepositoryUUID());
			System.out.println("URL=" + result.getURL());
			System.out.println("Kind=" + result.getKind());
			
			System.out.println("Rev=" + result.getRevision());
			System.out.println("RepositoryRootURL=" + result.getRepositoryRootURL());
			
			System.out.println("Committed-Date=" + result.getCommittedDate());
			System.out.println("Committed-Rev=" + result.getCommittedRevision());

		} catch (SVNException e) {
			e.printStackTrace();
		}

	}

}
