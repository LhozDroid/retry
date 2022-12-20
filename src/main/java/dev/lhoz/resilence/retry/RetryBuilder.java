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
	 * @param
	 * @param <R>
	 * @return
	 */
	public static RetryBuilder getInstance() {
		return new RetryBuilder();
	}

	/**
	 *
	 */
	private RetryBuilder() {
	}

	/**
	 * @param attempts
	 * @return
	 */
	public RetryBuilder attemptFor(final int attempts) {
		super.setAttempts(attempts);
		return this;
	}

	/**
	 * @return
	 */
	public Retry build() {
		return this;
	}

	/**
	 * @param runnable
	 * @return
	 */
	public RetryBuilder forMethod(final Runnable runnable) {
		super.setRunnable(runnable);
		return this;
	}

	/**
	 * @param sleep
	 * @return
	 */
	public RetryBuilder sleepFor(final long sleep) {
		super.setSleep(sleep);
		return this;
	}
}
