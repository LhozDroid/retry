/**
 *
 */
package dev.lhoz.resilence.retry.example;

import java.util.concurrent.atomic.AtomicInteger;

import com.github.lhoz.resilence.retry.Retry;
import com.github.lhoz.resilence.retry.RetryBuilder;
import com.github.lhoz.resilence.retry.RetryException;

import lombok.extern.log4j.Log4j2;

/**
 * @author Lhoz
 *
 */
@Log4j2
public class RetryExample {
	/**
	 * @param args
	 * @throws RetryException
	 */
	public static void main(final String[] args) throws RetryException {
		final AtomicInteger wait = new AtomicInteger(3);

		final Retry retry = new RetryBuilder()//
				.withAttempts(4)//
				.withSleep(500)//
				.withMethod(() -> {
					if (wait.get() > 0) {
						RetryExample.LOG.info("Will retry...");
						wait.set(wait.get() - 1);
						throw new RuntimeException();
					}
					RetryExample.LOG.info("Success");
				}).build();

		retry.run();
	}
}
