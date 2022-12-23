/**
 *
 */
package com.github.lhoz.resilence.retry;

/**
 * @author Lhoz
 *
 */
public class RetryException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public RetryException(final String message) {
		super(message);
	}
}
