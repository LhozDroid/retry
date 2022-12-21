/**
 *
 */
package dev.lhoz.resilence.retry;

/**
 * @author Lhoz
 *
 */
public class RetryBuilder extends Retry {

	/**
	 *
	 */
	public RetryBuilder() {
	}

	/**
	 * @return
	 */
	public Retry build() {
		return this;
	}

	/**
	 * @param attempts
	 * @return
	 */
	public RetryBuilder withAttempts(final int attempts) {
		super.setAttempts(attempts);
		return this;
	}

	/**
	 * @param runnable
	 * @return
	 */
	public RetryBuilder withMethod(final Runnable runnable) {
		super.setRunnable(runnable);
		return this;
	}

	/**
	 * @param sleep
	 * @return
	 */
	public RetryBuilder withSleep(final long sleep) {
		super.setSleep(sleep);
		return this;
	}
}
