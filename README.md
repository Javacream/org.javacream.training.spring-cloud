# training.spring-cloud

## heroku deployment

````shell
$ mvn clean package
$ heroku container:push web
$ heroku container:release web
$ heroku open
````