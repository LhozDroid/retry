/**
 *
 */
package com.github.lhoz.resilence.retry;

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
		if (attempts > 0) {
			this.attempts = attempts;
		}
		return this;
	}

	/**
	 * @param runnable
	 * @return
	 */
	public RetryBuilder withMethod(final Runnable runnable) {
		this.runnable = runnable;
		return this;
	}

	/**
	 * @param sleep
	 * @return
	 */
	public RetryBuilder withSleep(final long sleep) {
		if (sleep > 0) {
			this.sleep = sleep;
		}
		return this;
	}
}
