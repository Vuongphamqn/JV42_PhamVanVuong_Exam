<%-- 
    Document   : home
    Created on : Apr 27, 2021, 7:20:35 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/webjars/bootstrap/4.5.3/css/bootstrap.min.css" />" 
              type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-12 col-lg-12">
                    <br><h2>Newss</h2><br>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12 col-md-12 col-lg-12">
                    <c:if test="${type != null && type == 'error'}">
                        <div class="alert alert-danger">
                            ${message}
                        </div>
                    </c:if>
                    <c:if test="${type != null && type == 'success'}">
                        <div class="alert alert-success">
                            ${message}
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12 col-md-6 col-lg-6">
                    <button class="btn btn-primary"
                            onclick="location.href = '<c:url value="/add-news" />'">Add News</button>
                </div>
                <div class="col-xs-12 col-md-6 col-lg-6">
                    <form action="${pageContext.request.contextPath}/search" method="POST"
                          class="form-inline float-right">
                        <div class="form-group">
                            <input name="strSearch" type="text" class="form-control" />
                            <input type="submit" value="search" class="btn btn-secondary"/>
                        </div>
                    </form>
                </div>
            </div><br>
            <c:if test="${action=='search'&&newss.size()>0}" >
                <div class="row">
                    <div class="col-xs-12 col-md-12 col-lg-12">
                        <p>Found: ${newss.size()} result.</p>
                    </div>
                </div>
            </c:if>



            <div class="row">
                <div class="col-xs-12 col-md-12 col-lg-12">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover">
                            <tr>
                                <th>NewsId</th>
                                <th>Title</th>
                                <th>Summary</th>
                                <th>Staff Name</th>
                                <th>Cate Name</th>
                                <!--                                <th>Price</th>
                                                                <th>Publish Date</th>-->
                                <th>Action</th>
                            </tr>
                            <c:if test="${newss != null && fn:length(newss) > 0}">
                                <c:forEach items="${newss}" var="news">
                                    <tr>
                                        <td>${news.id}</td>
                                        <td>${news.title}</td>
                                        <td>${news.summary}</td>
                                        <td>${news.staff.staffName}</td>
                                        <td>${news.category.cateName}</td>
                                        <!--                                        <td>
                                        <fmt:formatNumber type="currency" value="${b.bookDetail.price}" /></td>
                                    <td>
                                        <fmt:formatDate value="${b.bookDetail.publishDate}" 
                                                        pattern="dd/MM/yyyy" />
                                    </td>
                                        -->                                        <td>
                                            <button class="btn btn-warning"
                                                    onclick="location.href = '<c:url value="/edit/${news.id}" />'">Edit </button>
                                            <button class="btn btn-danger"
                                                    onclick="location.href = '<c:url value="/delete/${news.id}" />'">Delete </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${newss == null || fn:length(newss) <= 0}">
                                <tr><td colspan="8" style="color: red">No Value!!!</td></tr>
                            </c:if>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
