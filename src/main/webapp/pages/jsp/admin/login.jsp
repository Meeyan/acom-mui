<%@ page contentType="text/html;charset=utf8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="/ui/sui/ui/global/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/ui/sui/ui/global/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/ui/css/form-elements.css">
    <link rel="stylesheet" href="/ui/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="/ui/sui/ot/js/html5shiv.min.js"></script>
    <script src="/ui/sui/ot/js/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>后台管理系统</strong></h1>
                    <div class="description">

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>欢迎登陆后台管理系统</h3>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/admin/doLogin.html" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">账号：</label>
                                <input type="text" name="userName" placeholder="管理员账号" class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码：</label>
                                <input type="password" name="password" placeholder="管理员密码" class="form-password form-control" id="form-password">
                            </div>
                            <button type="button" class="btn" id="loginBtn">登录</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Javascript -->
<script src="/ui/js/jquery-1.10.1.min.js"></script>
<script src="/ui/sui/adminlte/bootstrap/js/bootstrap.min.js"></script>
<script src="/ui/js/jquery.backstretch.min.js"></script>

<!--[if lt IE 10]>
<!--<script src="assets/js/placeholder.js"></script>-->
<![endif]-->

</body>

<script>
    jQuery(document).ready(function () {
        // 后台背景图片
        $.backstretch("/ui/images/1.jpg");

        /*
         Form validation
         */
        $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function () {
            $(this).removeClass('input-error');
        });

        $('#loginBtn').click(function () {

            /*$(this).find('input[type="text"], input[type="password"], textarea').each(function () {
             if ($(this).val() == "") {
             e.preventDefault();
             $(this).addClass('input-error');
             return false;
             } else {
             $(this).removeClass('input-error');
             }
             });*/

            var userNameForm = $('#form-username');
            var userPwdForm = $('#form-password');

            if (userNameForm.val() == "") {
                $(userNameForm).addClass('input-error');
                return false;
            }

            if (userPwdForm.val() == "") {
                $(userPwdForm).addClass('input-error');
                return false;
            }

            $.ajax({
                url: '/admin/checkUser.html',
                type: 'post',
                data: {
                    'userName': userNameForm.val(),
                    'password': userPwdForm.val()
                },
                dataType: 'json',
                success: function (data) {
                    alert(data.retMsg)

                },
                error:function(err){
                    alert(err);
                    console.log(err.responseText);
                }
            });

        });

    });
</script>

</html>