# Java Retry
A simple and small framework to retry a method...

1- Use the builder to create the retry object

```java
final Retry retry = new RetryBuilder()//
			.withAttempts(3) //
			.withSleep(500) //
			.withMethod(() -> {
				// TODO: Do something
			}).build();
```

2- Execute it

```java
retry.run();
```

<a href="https://www.paypal.com/donate/?cmd=_donations&business=CSQRVLE2D43NU&item_name=Buy+me+a+beer!&currency_code=USD">
  <strong>Buy me a beer!</strong>
</a>
