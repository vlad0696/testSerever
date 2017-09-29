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
<%@page import="org.ipps.sisslr.controllers.ExampleController"%>
<% ExampleController exampleController = new ExampleController();%>

<h5>${currentNode.properties['jcr:title'].string}:</h5>

<c:set var="obj" value="<%=exampleController.parseRequest(request)%>"/>

<h4>${obj.UnpEgr}</h4>
<h4>${obj.RegisterNumber}</h4>
<h5>${obj.NumberForm}</h5>
<h5>${obj.ElectronicNumber}</h5>

<a href="license-detail/edit-license.html?id=${obj.id}">Редактировать</a>


