# SpringCloudServerConfigAndEurekaDiscovery
This project shows how to manage server/client configuration using spring cloud config server and also how to user eureka server as service discovery

=================================================================================================================================
1. SpringCloudConfigServerWithEureka -----> is the Spring cloud config server. The eureka-service-user, eureka-service-account and
eureka-service-bankingService get their required configuration resources from here on start-up. SpringCloudConfigServerWithEureka has only 
one dependency, which is the spring-cloud-config-server, in the pom.xml and the springboot application must be annotated with 
@EnableConfigServer. The bootstrap.properties file has the uri information to the git repository where the backing file is located. 


2. eureka-service-register-------> is the eureka service discovery server where every other servers/clients register themselves and discover
other registered services. The only dependencies needed here is spring-cloud-starter-netflix-eureka-server and the application needs to be
annotated with @EnableEurekaServer. The application.yml file has the necessary configuration file for the server and also sets the default
url for other servers/clients to use in order to register themselves with the eureka service registry. The eureka server is not required
to register itself, hence the register-with-eureka attribute in the yml file must be false for the eureka. 

*****What this application does is that it gives a user of a given bank some kind of services, like checking balance for the customer and 
getting all accounts or customers for the bank officers. But the application is divided in to different modules and all services register
themselves with the eureka server. The spring cloud config server has different config resources for different modules in the application.
Hence, each module first needs to communicate with the sprsing cloud config server in order to communicate with other modules. For instance
the banking module exposes the services to users, but relies on the account and user modules to serve the services. Hence, it gets the url
resource of the account and user modules from the spring cloud config server and pass the request to the eureka server. Then the eureka server
makes the request to the appropriate service provider. *******************************************************************************

3. eureka-service-user ----------> the user module. It checks if a given user with a given account number is a user or not. 

4. eureka-service-account -------> exposes the list of accounts and also provides services like check balance, deposite money, withdraw money.

5. eureka-service-bankingService -------> this exposes the services to the application users. 


================================================================tutorial by: Bereket Babiso on 10/10/2018 Southfield MI=================
