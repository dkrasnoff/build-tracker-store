# Build tracker strore

This is a service application for storing and showing data received
from  [build tracking plugin](https://github.com/dvkrasnov/tracking-plugin)

## Run service

**Prerequisites**

* maven
* java 11
* docker

Before build and run application you need to start database for it. The most simple way is to run docker-compose from
the root of this project:

```bash
docker-compose up -d
```

After this docker container postgres-db will be started up on port=5432 host=localhost with:

* user=**postgres**
* password=**password**
* created db=**tracking_build**.

Now you can run your application with default properties:

```bash
 mvn clean package -Dmaven.test.skip=true && java -jar ./target/build-tracker-store-1.0.0.jar
```

And UI with executed builds will be available on: http://localhost:8080/build

## Custom service settings
You can set custom setting by setting up environment variable from this table:

Variable name  | Description       | Default value (if not set)
--- |-------------------| ---
buildTrackerStorePort | server port       | 8080
datasourceInternalUrl | database url      | jdbc:postgresql://localhost:5432/tracking_build
datasourceInternalUsername | database username | postgres
datasourceInternalPassword | database password | password