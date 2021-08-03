<%-- 
    Document   : book
    Created on : Apr 27, 2021, 8:31:11 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
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
                <div class="col-xs-12 col-md-12 col-lg-12" 
                     style="text-align: center">
                    <c:if test="${action == 'add'}">
                        <h2>Create News</h2>
                    </c:if>
                    <c:if test="${action != 'add'}">
                        <h2>Update News</h2>
                    </c:if>
                </div>
            </div>

            <mvc:form action="${pageContext.request.contextPath}/result"
                      method="POST" modelAttribute="news"> 
                <!--Dong goi toan bo form vao model book va gui xuong Controller-->

                <c:if test="${action == 'edit'}">
                    <input type="text" name="id" value="${news.id}" hidden />
                    <!--<input type="text" name="bookDetail.id" value="{news.bookDetail.id}" hidden />-->
                </c:if>

                <div class="row">
                    <div class="col-xs-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="titleId">Title <span style="color: red">(*)</span></label>
                            <input type="text" id="titleId"
                                   class="form-control" name="title" value="${news.title}" />
                            <span style="color: red"><mvc:errors path="title" /></span>
                        </div>
                    </div>

                    <div class="col-xs-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="summaryId">Summary <span style="color: red">(*)</span></label>
                            <input type="text" id="summaryId"
                                   class="form-control" name="summary" 
                                   value="${news.summary}"/>
                            <span style="color: red"><mvc:errors path="summary" /></span>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col-xs-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="contentsId">Content <span style="color: red">(*)</span></label>
                            <input type="text" id="contentsId"
                                   class="form-control" name="contents" 
                                   value="${news.contents}"/>
                            <span style="color: red"><mvc:errors path="contents" /></span>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="createdDateId">Create Date</label>
                            <input type="date" id="createdDateId"
                                   class="form-control" name="createdDate"
                                   value="${news.createdDate}"/>
                        </div>
                    </div>


                </div>

                <div class="row">
                    <div class="col-xs-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label>Category</label>
                            <select name="category.id" class="form-control">
                                <c:forEach items="${categories}" var="c">
                                    <c:if test="${news.category.id == c.id}">
                                        <option value="${c.id}" selected>${c.cateName}</option>
                                    </c:if>
                                    <c:if test="${news.category.id != c.id}">
                                        <option value="${c.id}">${c.cateName}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label>Staff Name</label>
                            <select name="staff.id" class="form-control">
                                <c:forEach items="${staffs}" var="staff">
                                    <c:if test="${news.staff.id == staff.id}">
                                        <option value="${staff.id}" selected>${staff.staffName}</option>
                                    </c:if>
                                    <c:if test="${news.staff.id != staff.id}">
                                        <option value="${staff.id}">${staff.staffName}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    
<!--                    <div class="col-xs-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="staffNameId">Staff Name <span style="color: red">(*)</span></label>
                            <input type="text" id="staffNameId"
                                   class="form-control" name="staff.staffName" 
                                   value="${news.staff.staffName}"/>
                            <span style="color: red"><mvc:errors path="staff.staffName" /></span>
                        </div>
                    </div>-->
                </div>

                <div class="row">
                    <div class="col-xs-12 col-md-12 col-lg-12" 
                         style="text-align: center">
                        <c:if test="${action == 'add'}">
                            <button type="submit" 
                                    class="btn btn-success">Create</button>
                        </c:if>
                        <c:if test="${action != 'add'}">
                            <button type="submit" 
                                    class="btn btn-success">Update</button>
                        </c:if>
                    </div>
                </div>

            </mvc:form>
        </div>
    </body>
</html>
