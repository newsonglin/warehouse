### How to run this cxf-spring

#### 1. In idea, open run/debug configurations
#### 2. Add a new smart tomcat (install the plugin if you don't have)
#### 3. Fill correct field.
     tomcat server: You tomcat server location
     deployment: the webapp location, such as F:\projects\my-github\warehouse\cxf-spring\src\main\webapp
     context path: something like /

#### 4. Run/debug this new create application

#### 5. Access http://localhost:8080/

#### 6. Access specify WS

http://{hostname}:{port}/{Context Path}/{CXFServlet url-pattern in web.xml}/{address in jaxrs:sever configuration}/{service class @path}/{service method @path}

