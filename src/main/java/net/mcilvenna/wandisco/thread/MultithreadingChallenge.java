package net.mcilvenna.wandisco.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

class MultithreadingChallenge {
	static final class SharedInteger {
		private int i;
		private final Object lock = new Object();

		SharedInteger() {
			i = 0;
		}

		void increment() {
			synchronized (lock) {
				i++;
			}
		}

		int get() {
			return i;
		}
	}

	static final class LockOrdering {
		private final ReentrantLock a;
		private final ReentrantLock b;
		private final ReentrantLock c;

		LockOrdering() {
			a = new ReentrantLock();
			b = new ReentrantLock();
			c = new ReentrantLock();
		}

		void opA() throws InterruptedException {
			boolean done = false;
			while (!done) {
				if (c.tryLock()) {
					try {
						a.tryLock();
						Thread.sleep(5_000);
						b.lock();
						assert a.isHeldByCurrentThread() && b.isHeldByCurrentThread();
					} finally {
						b.unlock();
						a.unlock();
						c.unlock();
						done = true;
					}
				}
			}
		}

		void opB() throws InterruptedException {
			boolean done = false;
			while (!done) {
				if (c.tryLock()) {
					try {
						b.tryLock();
						Thread.sleep(5_000);
						a.lock();
						assert a.isHeldByCurrentThread() && b.isHeldByCurrentThread();
					} finally {
						a.unlock();
						b.unlock();
						c.unlock();
						done = true;
					}
				}
			}
		}
	}

	static void problem1() throws InterruptedException {
		final int threads = 10;
		final int incrementsPerThread = 1_000_000;
		final int expected = threads * incrementsPerThread;

		final CountDownLatch cdl = new CountDownLatch(threads);
		final SharedInteger x = new SharedInteger();
		for (int i = 0; i < threads; i++) {
			(new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						for (int i = 0; i < incrementsPerThread; i++) {
							x.increment();
						}
					} finally {
						cdl.countDown();
					}
				}
			})).start();
		}
		cdl.await();

		assert expected == x.get();
		System.out.println("Problem 1 done!");
	}

	static void problem2() throws InterruptedException {
		final CountDownLatch cdl = new CountDownLatch(2);
		final LockOrdering lo = new LockOrdering();
		(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lo.opA();
				} catch (final InterruptedException e) {
				} finally {
					cdl.countDown();
				}
			}
		})).start();
		(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lo.opB();
				} catch (final InterruptedException e) {
				} finally {
					cdl.countDown();
				}
			}
		})).start();
		cdl.await();
		System.out.println("Problem 2 done!");
	}

	public static void main(final String[] args) throws InterruptedException {
		problem1();
		problem2();
	}
}
