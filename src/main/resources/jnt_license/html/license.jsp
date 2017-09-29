<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="jcr" uri="http://www.jahia.org/tags/jcr" %>
<%@ taglib prefix="ui" uri="http://www.jahia.org/tags/uiComponentsLib" %>
<%@ taglib prefix="functions" uri="http://www.jahia.org/tags/functions" %>
<%@ taglib prefix="query" uri="http://www.jahia.org/tags/queryLib" %>
<%@ taglib prefix="utility" uri="http://www.jahia.org/tags/utilityLib" %>
<%@ taglib prefix="s" uri="http://www.jahia.org/tags/search" %>
<%@page import="org.ipps.sisslr.controllers.ExampleController" %>
<%@ page import="org.ipps.sisslr.controllers.LicenseController" %>
<%@ page import="java.util.List" %>
<template:addResources type="javascript" resources="jquery.simplePagination.js"/>
<template:addResources type="css" resources="css/simplePagination.css"/>
 <style>
    tr:hover{
        background: darkgray;
    }
    /**
* CSS themes for simplePagination.js
* Author: Flavius Matis - http://flaviusmatis.github.com/
* URL: https://github.com/flaviusmatis/simplePagination.js
*/

    ul.simple-pagination {
        list-style: none;
    }

    .simple-pagination {
        display: block;
        overflow: hidden;
        padding: 0 5px 5px 0;
        margin: 0;
    }

    .simple-pagination ul {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .simple-pagination li {
        list-style: none;
        padding: 0;
        margin: 0;
        float: left;
    }
    span.ellipse.clickable {
        cursor: pointer;
    }

    .ellipse input {
        width: 3em;
    }

    .light-theme span {
        cursor:pointer;
    }

    .light-theme a, .light-theme span {
        float: left;
        color: #666;
        font-size:14px;
        line-height:24px;
        font-weight: normal;
        text-align: center;
        border: 1px solid #BBB;
        min-width: 14px;
        padding: 0 7px;
        margin: 0 5px 0 0;
        border-radius: 3px;
        box-shadow: 0 1px 2px rgba(0,0,0,0.2);
        background: #efefef; /* Old browsers */
        background: -moz-linear-gradient(top, #ffffff 0%, #efefef 100%); /* FF3.6+ */
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffffff), color-stop(100%,#efefef)); /* Chrome,Safari4+ */
        background: -webkit-linear-gradient(top, #ffffff 0%,#efefef 100%); /* Chrome10+,Safari5.1+ */
        background: -o-linear-gradient(top, #ffffff 0%,#efefef 100%); /* Opera11.10+ */
        background: -ms-linear-gradient(top, #ffffff 0%,#efefef 100%); /* IE10+ */
        background: linear-gradient(top, #ffffff 0%,#efefef 100%); /* W3C */
    }

    .light-theme a:hover, .light-theme li:not(.disabled):not(.active) span:hover {
        text-decoration: none;
        background: #FCFCFC;
    }

    .light-theme .current {
        background: #666;
        color: #FFF;
        border-color: #444;
        box-shadow: 0 1px 0 rgba(255,255,255,1), 0 0 2px rgba(0, 0, 0, 0.3) inset;
        cursor: default;
    }

    .light-theme .ellipse {
        background: none;
        border: none;
        border-radius: 0;
        box-shadow: none;
        font-weight: bold;
        cursor: default;
    }


 </style>

<%  ExampleController exampleController = new ExampleController();
    LicenseController licenseController = new LicenseController();
    Integer pageNumber=0;
    String path= "/cms/"+ request.getPathInfo();
    if (request.getParameter("page")==null) {
        pageNumber = 1;
    }
    else{
        pageNumber=Integer.parseInt(request.getParameter("page"));
    }
%>
<table class="table">
    <tr>
        <th>Номер лицензии</th>
        <th>Номер решения о выдаче лицензии</th>
        <th>Наименование лицензируемого вида деятельности</th>
        <th>Наименование лицензиата</th>
        <th>УНП</th>
        <th>Сервисы</th>
    </tr>
    <c:forEach var="entity" items="<%= licenseController.getLicense(pageNumber)%>">
        <tr class="license-table-row" >
            <td>${entity[1]}</td>
            <td>${entity[2]}</td>
            <td>${entity[3]}</td>
            <td>${entity[4]}</td>
            <td>${entity[5]}</td>
            <%--<td>--%>
            <%--<c:forEach var="service" items="<%=licenseController.serviceList%>">--%>
               <%--<c:if test="${service[0]== entity[0]}">--%>
                   <%--${service[1]},--%>
            <%--</c:if>--%>
            <%--</c:forEach>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>

</table>
<div id="compact-pagination" class="pagination"></div>


<% response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
%>
<script>
    $(function() {
        $('#compact-pagination').pagination({
            items: <%=licenseController.pageCount%>,
            itemsOnPage: 20,
            cssStyle: 'light-theme',
            hrefTextPrefix:'?page=',
            currentPage:<%=request.getParameter("page")%>
        });
    });
</script>
