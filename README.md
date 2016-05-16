Build this using Maven

Start execution.  You don't need Tomcat.

Then, go to url's such as:
 
localhost:5050/foo    shows direct url mapping

localhost:5050/bar    shows another direct url mapping

localhost:5050/nested/sheep/dog     shows a nested mapping

localhost:5050/handlebars     shows rendering a handlebars template

localhost:5050/json      shows producing a JSON response

localhost:5050/static/assets/images/sheep.jpg    shows rendering a static asset (an image)

localhost:5050/injected       shows an injected "module" (where a module has a service and a handler)


