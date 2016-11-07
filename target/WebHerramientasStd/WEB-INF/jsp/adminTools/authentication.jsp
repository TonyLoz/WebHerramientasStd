<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Tools</title>
    </head>
    <body>
        <div>
            <h2>${initParam.appTitle}&nbsp;-&nbsp;Admin Tools</h2>
            <div>
                <form action="signInAdminTools.cfg" method="post">
                    <table class="formulario">
                        <tbody>
                            <tr>
                                <td>
                                    <label for="user">User</label>
                                </td>
                                <td>
                                    <input id="user" name="user" type="text" maxlength="20" 
                                        value="${user}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="password">Password</label>
                                </td>
                                <td>
                                    <input id ="password" name="password" type="password" maxlength="20" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br />
                    <input id="iniciarSesion" type="submit" value="Sign in" />
                </form>
                <div class="errorMsg">${errorMsg}</div>
            </div>
        </div>
    </body>
</html>
