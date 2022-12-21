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
	protected Runnable runnable = null;

	protected int attempts = -1;
	protected long sleep = 0L;

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
}
