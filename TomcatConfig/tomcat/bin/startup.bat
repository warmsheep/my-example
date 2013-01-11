@echo off
if "%OS%" == "Windows_NT" setlocal
rem ---------------------------------------------------------------------------
rem Start script for the CATALINA Server
rem
rem $Id: startup.bat 467182 2006-10-23 23:47:06Z markt $
rem ---------------------------------------------------------------------------


rem Guess CATALINA_HOME if not defined


echo 本示例为强制设置Tomcat的环境变量和JAVA的环境变量，不被系统中已经设定好的环境变量所影响

echo 设定CURRENT_DIR（当前目录）
cd ..
set CURRENT_DIR=%cd%

echo 这里需要在tomcat下新建jdk的文件夹，并将jdk文件拷贝至其中
set JAVA_HOME=%CURRENT_DIR%/jdk
set CLASSPATH=.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;
set PATH=%PATH%;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;

echo 设定TOMCAT的环境变量
set CATALINA_HOME=%CURRENT_DIR%
set CATALINA_BASE=%CATALINA_HOME%
set EXECUTABLE=%CATALINA_HOME%\bin\catalina.bat



rem Get remaining unshifted command line arguments and save them in the
set CMD_LINE_ARGS=
:setArgs
if ""%1""=="""" goto doneSetArgs
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto setArgs
:doneSetArgs


echo RUN的话不会新开一个窗口，方便查看错误信息
call "%EXECUTABLE%" run %CMD_LINE_ARGS%

:end
