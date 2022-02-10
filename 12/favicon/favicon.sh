# Script written by Andrey
echo on
#echo --------------------------------------------- favicon.sh ------------------------------------------------------

export CLASSPATH=${PWD}/favicon.jar
export CLASSPATH=${PWD}/org.apache.commons.logging_1.2.0.v20180409-1502.jar:$CLASSPATH
export CLASSPATH=${PWD}/org.apache.httpcomponents.httpclient_4.5.13.v20210128-2225.jar:$CLASSPATH
export CLASSPATH=${PWD}/org.apache.httpcomponents.httpcore_4.4.14.v20210128-2225.jar:$CLASSPATH

#echo $CLASSPATH

java favicon.main ${ENV_SITE_URL}


