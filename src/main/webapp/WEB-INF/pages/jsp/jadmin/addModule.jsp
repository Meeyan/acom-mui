<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <title>SuperMgr后台框架</title>
    <jsp:include page="headComm.jsp"/>
    <style type="text/css">
        .step-content {
            min-height: 320px !important;
        }
    </style>
</head>
<body>
<form id="modelForm" class="form" action="" method="post">
    <div class="formDiv">
        <div class="widget-body">
            <div class="step-content" id="wizard-steps" style="border-left: none; border-bottom: none; border-right: none;">
                <div class="step-pane active" id="step-1" style="margin-left: 0px; margin-top: 15px; margin-right: 30px;">
                    <input id="Id" type="hidden" value="@ViewBag.ModuleId"/>
                    <table class="form">
                        <tr>
                            <th class="formTitle">模块名称：<font face="宋体">*</font></th>
                            <td class="formValue" colspan="2">
                                <input id="moduleName" type="text" name="moduleName" class="form-control" placeholder="请输入模块名称" isvalid="yes" checkexpession="NotNull"/>
                            </td>
                        </tr>
                        <tr>
                            <th class="formTitle" valign="top" style="padding-top: 4px;">模块描述：</th>
                            <td class="formValue" colspan="3">
                                <textarea id="moduleDesc" name="moduleDesc" class="form-control" style="height: 70px;"></textarea>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="form-button" id="wizard-actions" style="text-align: center;">
            <a id="btn_finish" disabled class="btn btn-success">完成</a>
        </div>
    </div>
</form>

</body>
</html>

<%-- 页面公共底部js文件 --%>
<jsp:include page="footComm.jsp"/>

<script src='<c:out value="${APP_OM_PATH}"/>/ui/sui/plugins/validator/validator.js'></script>
<script src='<c:out value="${APP_OM_PATH}"/>/ui/sui/plugins/wdtree/tree.js'></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#btn_finish").click(function () {
            if (!$('#modelForm').Validform()) {
                return false;
            }
            $.ajax({
                type: 'post',
                url: '/admin/system/saveModule.html',
                data: $('#modelForm').serialize(),
                dataType: 'json',
                success: function (data) {
                    $.fn.modalMsg("提交成功", "success");
                    $.fn.modalClose();
                }
            });
        });
    });

</script>