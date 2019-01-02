# OSGI Spring Boot Demo

This is a demo application that shows that it's possible to run Spring Boot apps in OSGI container.

To produce bundle run `mvn clean install`. It will be available in `target/deploy`.

To verify that app is working try access `http://localhost:9015/simple` endpoint.
```
$ curl http://localhost:9015/simple
some text. Means that scan works. Finally.
```