# ----------------------------- Dockerfile--------------------
FROM openjdk:8-jdk-oracle

RUN mkdir -p /andrey/

WORKDIR /andrey/

COPY favicon/ /andrey/

ENV ENV_SITE_URL=http://sergey.com

RUN echo $ENV_SITE_URL

ENTRYPOINT ["/bin/sh", "/andrey/favicon.sh"]


