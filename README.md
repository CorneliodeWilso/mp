# Build
mvn clean package && docker build -t com.mp/mp-core .

# RUN

docker rm -f mp-core || true && docker run -d -p 8080:8080 -p 4848:4848 --name mp-core com.mp/mp-core 