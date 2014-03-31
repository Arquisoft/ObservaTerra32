REM Ahora en Uniovi el proxy se detecta automaticamente 
REM set JAVA_OPTS=-Dhttp.proxyHost=proxy.uniovi.es -Dhttp.proxyPort=8888
set JAVA_OPTS=%JAVA_OPTS% -Djboss.server.log.threshold=INFO
set JAVA_OPTS=%JAVA_OPTS% -Xms512m -Xmx1000m -XX:MaxPermSize=256m
set JAVA_OPTS=%JAVA_OPTS% -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n
REM Vamos a definir la unidad S: asociada a la carpeta raiz de nuestro entorno-sdi
REM Es importante respetar la unidad "S", ya que será la que se use SIEMPRE internamente en todas las configuraciones de nuestras herramientas.
set UNIDAD=S:
subst %UNIDAD% %CD%
REM Definimos variables de entorno necesarias para lanzar Eclipse
set APACHE_HOME=%UNIDAD%\apache
set JBOSS_HOME=%UNIDAD%\jboss
set JAVA_HOME=%UNIDAD%\jdk
set PATH=%JAVA_HOME%\bin;%PATH%
set CLASSPATH=;%JAVA_HOME%\lib\tools.jar;.;%CLASSPATH%
%UNIDAD%
cd jboss\bin
standalone --server-config=standalone-full.xml