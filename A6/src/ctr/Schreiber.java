package ctr;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class Schreiber extends Thread {

	private Speicher speicherSchreiber;
	private String[] textSchreiber;
	private int zahlWiederholungSchreiber;
	private ReentrantReadWriteLock.WriteLock lockSchreiber;

	Schreiber(Speicher speicher, String[] text, int zahlWiederholungen, ReentrantReadWriteLock.WriteLock lock) {
		this.lockSchreiber = lock;
		this.speicherSchreiber = speicher;
		this.textSchreiber = text;
		this.zahlWiederholungSchreiber = zahlWiederholungen;
	}

	public void run() {
		lockSchreiber.lock();
		try {
			for (int i = 0; i < zahlWiederholungSchreiber; i++) {
				for (String s : textSchreiber) {
					speicherSchreiber.writeLine(s);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			lockSchreiber.unlock();
		}
	}
}
