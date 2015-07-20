<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
  <head>
    <title>管理登录平台</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  <body scroll="no" style="background:none;" >
        <input type="hidden" id="showMsg" value="${msg}"/>
        <script type="text/javascript">WX_DIALOG.pageInit();</script>
        <div class="header">
            <div class="logo">管理中心</div>
            <div class="nav"></div>
            <div class="logininfo"></div>
        </div>
        <div class="main loginmain" id="main">
            <div class="mainC">
                 <h1>管理中心</h1>
                 <p>介绍内容</p>
            </div>
            <div class="mainD" id="mainD">
                <form method="post"  id="loginform" action="login.action">
                    <div class="msg"></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        <input type="hidden" name="opr" value="login"  />
                            <th width="60" height="36px">用户名</th>
                            <td colspan="2"><input id="loginName" type="text" name="adminName"  class="txt" style="width:150px;" maxlength="18" date-lable="用户名" data-validator="required" /></td>
                        </tr>
                        <tr>
                            <th height="36px">密  码</th>
                            <td colspan="2"><input id="loginPwd"  type="password" name="adminPwd" class="txt" style="width:150px;"  maxlength="18" date-lable="用户密码" data-validator="required" /></td>
                        </tr>
                        <tr>
                            <td height="46" valign="bottom"></td>
                            <td><input value="登录"  tabindex="4" type="submit" class="loginBtn"/></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="copyright">2013-2015 WX.</div>
  </body>
</html>

