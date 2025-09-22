this project is working after adding cxf.path=/
1) this project contains restful producer and async producer 
2) normal consumer and async consumer
3) basic spring security - by default its is commented and un comment when neccessary
   <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
   </dependency>
4) final url to hit app is http://localhost:8080/services/helloservice/patients/all
5) this has caching demo for car controller