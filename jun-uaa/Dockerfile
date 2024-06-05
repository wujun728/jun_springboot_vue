FROM openjdk:8u292

LABEL MAINTAINER=Andy
WORKDIR /apps
ADD target/jun-uaa.jar /apps/
CMD ["java","-jar","jun-uaa.jar"]
# docker run --name jun-uaa \
# -e spring_cloud_nacos_server_addr=10.0.0.12:8848 \
# -e jun_datasource_ip=10.0.0.12 \
# -e jun_datasource_username=root \
# -e jun_datasource_password=redhat \
# -e spring_redis_host=10.0.0.12 \
# -d jun-uaa:4.5