# cook-book-back-end
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/614595dd08364dfd8e8de37883a96fbc)](https://www.codacy.com/app/ArtemVolynskiy/cook-book-back-end?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ArtemVolynskiy/cook-book-back-end&amp;utm_campaign=Badge_Grade)

Spring MVC based RESTFUL API application which serves possible meal combinations to fit into user's daily ration.
Ration is calculated based on the data, consumed from the user.

* Demo is available here:


* You can also use Swagger-endpoint for convenience:



How to run 
----------

* Java 8 and Maven have to be installed on you machine.
* Build war file and put it in your application server
* Test it with your API testing tool (postman, soapUi, ect...)

Dependencies
---------

* spring 4.3.7 RELEASE
* spring MVC 3.3.7 RELEASE
* spring security 4.2.2
* hibernate 5.2.9
* Junit 4.12
* Maven

Design
------

Requirements:
-------------

* The application returns personalized results based on you sex, age, weight etc...
It is highly recommended to provide valid information (valid for any human like protein form of life)