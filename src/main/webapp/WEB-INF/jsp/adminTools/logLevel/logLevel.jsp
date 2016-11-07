<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log Level</title>
    </head>
    <body>
        <div>
            <h2>Log Level</h2>
            <form method="post" action="changeLogLevel.cfg" >
                <label for="loggerName">Logger name:</label>
                <input name="loggerName" type="text" value="${loggerName}" />
                <br/>(Leave empty if you want to change the log level of the root logger)
                <ul id="opcionesNuvelLog">
                    <li><input type="radio" name="level" value="ALL" ${nivelLogActual == "ALL"?"checked":""} /><span>ALL</span></li>
                    <li><input type="radio" name="level" value="TRACE" ${nivelLogActual == "TRACE"?"checked":""} /><span>TRACE</span></li>
                    <li><input type="radio" name="level" value="DEBUG" ${nivelLogActual == "DEBUG"?"checked":""} /><span>DEBUG</span></li>
                    <li><input type="radio" name="level" value="INFO" ${nivelLogActual == "INFO"?"checked":""} /><span>INFO</span></li>
                    <li><input type="radio" name="level" value="WARN" ${nivelLogActual == "WARN"?"checked":""} /><span>WARN</span></li>
                    <li><input type="radio" name="level" value="ERROR" ${nivelLogActual == "ERROR"?"checked":""} /><span>ERROR</span></li>
                    <li><input type="radio" name="level" value="FATAL" ${nivelLogActual == "FATAL"?"checked":""} /><span>FATAL</span></li>
                    <li><input type="radio" name="level" value="OFF" ${nivelLogActual == "OFF"?"checked":""} /><span>OFF</span></li>
                </ul>
                <br />
                <div>
                    <input value="Change" type="submit" />
                </div>
            </form>
            <div class="errorMessage">${errorMessage}</div>
            <div class="okMessage">${okMessage}</div>
        </div>
        <a href="adminToolsMenu.cfg">Go to menu</a>
    </body>
</html>