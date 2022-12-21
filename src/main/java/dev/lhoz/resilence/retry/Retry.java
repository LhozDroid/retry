/**
 *
 */
package dev.lhoz.resilence.retry;

import lombok.extern.log4j.Log4j2;

/**
 * @author Lhoz
 *
 */
@Log4j2
public class Retry {
	private int attempts = -1;
	private long sleep = 0L;

	private Runnable runnable = null;

	/**
	 *
	 */
	protected Retry() {
	}

	/**
	 * @throws RetryException
	 */
	public void run() throws RetryException {
		if (this.runnable != null) {
			boolean success = false;
			int left = this.attempts;

			while (!success && (left == -1 || left > 0)) {
				try {
					this.runnable.run();
					success = true;
					break;
				} catch (final Exception e) {
					Retry.LOG.debug(e.getLocalizedMessage(), e);
					left = left - (left == -1 ? 0 : 1);
				}

				try {
					Thread.sleep(this.sleep);
				} catch (final Exception e) {
					Retry.LOG.debug(e.getLocalizedMessage(), e);
					Retry.LOG.error(e.getLocalizedMessage());
				}
			}

			if (!success) {
				throw new RetryException("Unable to complete process.");
			}
		}
	}

	/**
	 * @param attempts
	 */
	protected void setAttempts(final int attempts) {
		if (attempts >= 0) {
			this.attempts = attempts;
		}
	}

	/**
	 * @param runnable
	 */
	protected void setRunnable(final Runnable runnable) {
		this.runnable = runnable;
	}

	/**
	 * @param sleep
	 */
	protected void setSleep(final long sleep) {
		this.sleep = sleep;
	}
}
