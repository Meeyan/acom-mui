<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${APP_OM_PATH}/ui/sui/ui/global/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_OM_PATH}/ui/sui/ui/global/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_OM_PATH}/ui/css/form-elements.css">
    <link rel="stylesheet" href="${APP_OM_PATH}/ui/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="${APP_OM_PATH}/ui/sui/ot/js/html5shiv.min.js"></script>
    <script src="${APP_OM_PATH}/ui/sui/ot/js/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    <style>
        .form-title {
            line-height: 50px;
            text-align: right;
            padding-right: 0px !important;
            padding-left: 0px !important;
        }

        #codeValidateImg {
            float: left;
            height: 50px;
            width: 130px;
            margin-left: 10px;
            cursor: pointer;
        }
    </style>
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
                        <div class="form-top-right" style="padding-top: 20px;">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="${APP_OM_PATH}/admin/doLogin.html" method="post" class="login-form" id="loginForm">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 form-title" style="line-height: 50px;" for="form-username">账号：</label>
                                <div class="col-md-9">
                                    <input type="text" name="userName" class="form-username form-control" id="form-username" placeholder="管理员账号"/>
                                </div>
                            </div>

                            <div class="form-group col-md-12">
                                <label class="col-md-2 form-title" for="form-password">密码：</label>
                                <div class="col-md-9">
                                    <input type="password" name="password" class="form-password form-control" id="form-password" placeholder="管理员密码"/>
                                </div>
                            </div>

                            <div class="form-group col-md-12">
                                <label class="col-md-2 form-title" for="form-imageCode">验证码：</label>
                                <div class="col-md-9">
                                    <input type="text" name="imageCode" class="form-username form-control col-md-7" style="width: 180px;" id="form-imageCode"
                                           placeholder="请输入验证码"/>
                                    <img id="codeValidateImg" style="" src="${APP_OM_PATH}/admin/getImageCode.html"/>
                                </div>
                            </div>
                            <div class="col-md-12" id="error-msg-div" style="display: none;">
                                <label class="col-md-2 form-title" for="form-imageCode"></label>
                                <div class="col-md-9" style="color: red;font-weight: 500;" id="err-msg-cnt">用户名或者密码错误</div>
                            </div>

                            <button type="button" class="btn" style="width: 300px;margin: auto;display: block;" id="loginBtn">登录</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Javascript -->
<script src="${APP_OM_PATH}/ui/js/jquery-1.10.1.min.js"></script>
<script src="${APP_OM_PATH}/ui/sui/adminlte/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_OM_PATH}/ui/js/jquery.backstretch.min.js"></script>

<!--[if lt IE 10]>
<!--<script src="assets/js/placeholder.js"></script>-->
<![endif]-->

</body>

<script>
    jQuery(document).ready(function () {
        // 后台背景图片
        $.backstretch("${APP_OM_PATH}/ui/images/1.jpg");

        /*
         Form validation
         */
        $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function () {
            $(this).removeClass('input-error');
            $('#error-msg-div').hide();
        });

        $('#loginBtn').click(function () {
            var userNameForm = $('#form-username');
            var userPwdForm = $('#form-password');
            var imageCodeForm = $('#form-imageCode');
            if (userNameForm.val() == "") {
                $(userNameForm).addClass('input-error');
                showErrMsg('管理账号不能为空');
                return false;
            }
            if (userPwdForm.val() == "") {
                $(userPwdForm).addClass('input-error');
                showErrMsg('登录密码不能为空');
                return false;
            }
            if (imageCodeForm.val() == "" || imageCodeForm.val().trim().length != 4) {
                $(imageCodeForm).addClass('input-error');
                showErrMsg('验证码不能为空且必须为4位');
                return false;
            }

            $.ajax({
                url: '${APP_OM_PATH}/admin/checkUser.html',
                type: 'post',
                data: {
                    'userName': userNameForm.val(),
                    'imageCode': imageCodeForm.val(),
                    'password': userPwdForm.val()
                },
                dataType: 'json',
                success: function (data) {
                    if (data.retCode == 'success') {
                        $("#loginForm").submit();
                    } else {
                        showErrMsg(data.retMsg);
                    }
                },
                error: function (err) {
                    console.log(err.responseText);
                }
            });
        });

        $('#codeValidateImg').click(function () {
            $(this).attr('src', '${APP_OM_PATH}/admin/getImageCode.html?time=' + new Date());
        });
    });

    function showErrMsg(errMsg) {
        $('#err-msg-cnt').html(errMsg);
        $('#error-msg-div').show();
    }
</script>

</html>