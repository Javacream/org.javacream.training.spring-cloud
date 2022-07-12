# training.spring-cloud

## heroku deployment

````shell
$ heroku create
$ mvn clean package
$ heroku container:push web --app <app-name-from-create>
$ heroku container:release web --app <app-name-from-create>
$ heroku open --app <app-name-from-create>
````