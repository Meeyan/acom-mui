<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
    <title>角色管理</title>
    <%-- 页面公共头部文件 --%>
    <jsp:include page="headComm.jsp"/>

    <link rel="stylesheet" href='<%request.getParameter("APP_OM_PATH");%>/ui/sui/plugins/jqgrid/jqgrid.css'/>
    <link rel="stylesheet" href='<%request.getParameter("APP_OM_PATH");%>/ui/sui/plugins/wdtree/tree.css'/>
    <script src='<%request.getParameter("APP_OM_PATH");%>/ui/sui/plugins/datepicker/WdatePicker.js'></script>

</head>
<body>
<!-- Main content -->
<section class="content">
    <div class="ui-layout" id="layout" style="height: 100%; width: 100%;">
        <div class="ui-layout-west">
            <div class="west-Panel">
                <div class="panel-Title">角色列表- <c:out value="${APP_OM_PATH}"/></div>
                <div id="itemTree"></div>
            </div>
        </div>
        <div class="ui-layout-center">
            <div class="center-Panel">
                <div class="panel-Title">包含模块</div>
                <div class="titlePanel">
                    <div class="title-search">
                        <a class="btn btn-default lr-replace"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
                        <a class="btn btn-default" id="btn-add-mudole"><i class="fa fa-plus"></i>&nbsp;新增模块</a>
                        <a class="btn btn-default lr-add"><i class="fa fa-plus"></i>&nbsp;新增权限</a>
                        <a class="btn btn-default lr-edit"><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a>
                        <a class="btn btn-default lr-delete"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
                    </div>
                    <div class="toolbar moduletoolbar">
                        <script></script>
                    </div>
                </div>
                <div class="gridPanel">
                    <table id="gridTable"></table>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>

<%-- 页面公共底部js文件 --%>
<jsp:include page="footComm.jsp"/>

<script src='<c:out value="${APP_OM_PATH}"/>/ui/sui/plugins/jqgrid/grid.locale-cn.js'></script>
<script src='<c:out value="${APP_OM_PATH}"/>/ui/sui/plugins/jqgrid/jqgrid.js'></script>
<script src='<c:out value="${APP_OM_PATH}"/>/ui/sui/plugins/validator/validator.js'></script>
<script src='<c:out value="${APP_OM_PATH}"/>/ui/sui/plugins/layout/jquery.layout.js'></script>
<script src='<c:out value="${APP_OM_PATH}"/>/ui/sui/plugins/wdtree/tree.js'></script>
<script src='<c:out value="${APP_OM_PATH}"/>/ui/sui/supermgr/Module/ModuleMgr/ModuleMgr.js'></script>

<script type="text/javascript">
    $(document).ready(function () {
        var module = new ModuleMgr();
        module.initGridPage();
        loadRoleList();

        $("#btn-add-mudole").click(function () {
            var parentId = $("#gridTable-button").jqGridRowValue("Id");
            $.fn.modalOpen({
                id: "addModuleForm",
                title: '添加模块',
                url: '/admin/addModule.html',
                width: "700px",
                btn: '',    // 添加可以隐藏底部的按钮
                height: "320px",
                callBack: function (iframeId) {
                    // 异步加载所有的模块
                }
            });
        });

        $(window).resize();
    });

    function loadRoleList() {
        var item = {
            height: $.fn.getLayoutContentHeight(),
            url: "/admin/loadRoleData.html",
            onnodeclick: function (item) {
                alert(item.id);
            }
        };
        //初始化
        $("#itemTree").treeview(item);
    }

</script>
