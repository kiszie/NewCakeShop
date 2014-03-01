<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>DapurKue | Add Product</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" media="all" href="resources/styles/960.css" />
    <link rel="stylesheet" type="text/css" media="all" href="resources/styles/reset.css" />
    <link rel="stylesheet" type="text/css" media="all" href="resources/styles/text.css" />
    <link rel="stylesheet" type="text/css" media="all" href="resources/style.css" />
    <link rel="stylesheet" type="text/css" media="all" href="resources/brown/style.css" />
    <script type="text/javascript" src="resources/scripts/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="resources/scripts/jquery.tools.min.js"></script>
    <script type="text/javascript" src="resources/scripts/dapur.js"></script>
</head>
<body>
<div id="warp">
    <div id="main" class="container_16">
        <div id="header" class="grid_16">
            <div id="logo" class="grid_4 alpha">
                <h1><a href="../index.jsp">DapurKue</a></h1>
                <h2>Famously Delicious</h2>
            </div>
            <div id="headright" class="grid_7 prefix_5 omega">
                <c:if test="${empty sessionScope['loginUser']}">
                    <h3 class="login">
                        <a href="login(admin).jsp">Admin/</a><a href="../security/login.jsp">Sign up</a> / <a href="../security/login.jsp">Login</a></h3>
                </c:if>
                <c:if test="${not empty sessionScope['loginUser']}">
                <a href="View-history.jsp"><c:out value="${sessionScope['loginUser']}" /></a>
                    <a href="logout.jsp">Logout </a>
                </c:if>
                <p>Subtotal: $ 00.00</p>
                <p><span class="vChart"><a href="shoppingcart.jsp">View Cart</a></span> <span class="cOut"><a href="checkout.jsp">Checkout</a></span></p>
            </div>
        </div>
        <div id="mainMenu" class="grid_16">
            <ul>
                <li><a href="../index.jsp">Home</a></li>
                <li><a href="product-overview.jsp">Cakes</a></li>
                <li><a href="product-details.jsp">Order &amp; Delivery</a></li>
                <li><a href="productList">ProductList</a></li>

            </ul>
        </div>
        <div id="stickySearch" class="grid_16">
            <div class="stickyNews grid_12 alpha">
                <p>Valentine’s BrownieCheese Special Package. <em>Free Delivery.</em> <a href="#" class="bookMan">More &raquo;</a></p>
            </div>



            <div class="search grid_4 omega">
                <form action="#" method="get">
                    <input type="text" value="Type your keyword" id="s" name="s" onfocus="if (this.value == 'Type your keyword') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Type your keyword';}" />
                </form>
            </div>
        </div>
        <div class="checkout grid_16">
            <div class="newAccount grid_8 alpha">
                <h4>Create New Product</h4>
                <form:form  method="post" action="/product/addValidProduct" commandName="product" enctype="multipart/form-data">
                <form:hidden path="id"/>
                <fieldset>
                        <form:label path="name">Product name: </form:label>
                        <label>
                        <form:input path="name" />
                        </label>

                        <form:errors path="name" cssClass="error"/>
                        <br />

                        <form:label path="des">Description: </form:label>
                        <label>
                        <form:input path="des"/>
                        </label>
                        <form:errors path="des" cssClass="error"/>
                        <br />

                        <form:label path="price">Price:</form:label>
                         <label>
                        <form:input path="price"/>
                        </label>
                        <form:errors path="price" cssClass="error"/>
                        <br />

                          <form:label path="image">images</form:label>
                         <label>
                        <input type="file" name="file" id="file" />
                         </label>
                        <form:errors path="image" cssClass="error"/>
                        <br />


                    <p>
                        <input type="submit" value="Create New Account" tabindex="6" name="update" class="newAccountButton" />
                    </p>
                </fieldset>
            </div>

                    <input type="hidden" value="30" />
            </form:form>
                </form>
            </div>
            <div class="loginPage grid_8 omega">
                <h4>Login</h4>
                <div id="login-error"> ${error}</div>
                <form action="../../j_spring_security_check" method="post" >

                    <fieldset>
                        <label for="j_username">Username:</label>
                        <input type="text" tabindex="1" size="50" value="" id="j_username" name="j_username" class="text" />
                        <br />
                        <label for="j_password">Password:</label>
                        <input type="password" tabindex="2" size="22" value="" id="j_password" name="j_password" class="text" />
                        <br />


                        <div class="clear"></div>
                    </fieldset>
                    <p>
                        <input type="submit" value="Login" tabindex="3" name="update" class="userLogin" />
                    </p>
                    <input type="hidden" value="30" />
                </form>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="richContent2">
    <div class="container_16">
        <div class="lastTweet grid_4">
            <h4>Latest Tweets</h4>
            <p><a href="#">@someone</a> yes indeed this is one hell of a free css template! <a href="#">Read More</a> <span><em>15 minutes ago</em></span></p>
            <p><a href="#">@someone</a> yes indeed this is one hell of a free css template! <a href="#">Read More</a> <span><em>15 minutes ago</em></span></p>
        </div>
        <div class="corporateInfo grid_4">
            <h4>Corporate Info</h4>
            <ul>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Term &amp; Conditions</a></li>
                <li><a href="#">Franchise</a></li>
                <li><a href="#">About us</a></li>
                <li><a href="#">FAQ</a></li>
            </ul>
        </div>
        <div class="storeDelivery grid_4">
            <h4>Store &amp; Delivery</h4>
            <ul>
                <li><a href="#">Store Locator</a></li>
                <li><a href="#">Delivery Terms &amp; Pricing</a></li>
                <li><a href="#">Delivery Coverage</a></li>
                <li><a href="#">Gift Services</a></li>
                <li><a href="#">Track my order</a></li>
            </ul>
        </div>
        <div class="socialNet grid_4">
            <h4>Keep in touch</h4>
            <ul>
                <li><a href="#" class="facebook">Facebook</a></li>
                <li><a href="#" class="twitter">Twitter</a></li>
                <li><a href="#" class="feed">Feed</a></li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div id="footer">
    <div class="container_16">
        <div class="copyright grid_16">
            <p class="left">Copyright &copy; 2010, Your Company Here, All Rights Reserved</p>
            <p class="right"><a href="http://all-free-download.com/free-website-templates/">Free CSS Templates</a> by <a href="http://tokokoo.com/">Tokokoo</a> &amp; <a href="http://www.instantshift.com/">instantShift</a></p>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>