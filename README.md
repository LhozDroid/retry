# Java Retry
A simple and small framework to retry a method...

1- Use the builder to construct the retry objects

```java
final Retry retryConnect = RetryBuilder.getInstance()//
				.attemptFor(this.options.getRetries()) //
				.sleepFor(this.options.getTimeout()) //
				.forMethod(this::connect)//
				.build();
```

2- Execute it
```java
try {
  retryConnect.run();
} catch (final RetryException e) {
  ClientSocket.LOG.error(e.getLocalizedMessage(), e);
  this.notifyOnConnectionFailed();
  throw new SocketConnectionException("Unable to connect.", e);
}
```

<a href="https://www.paypal.com/donate/?cmd=_donations&business=CSQRVLE2D43NU&item_name=Buy+me+a+beer!&currency_code=USD">
  <strong>Buy me a beer!</strong>
</a>
