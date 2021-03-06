<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>DapurKue</title>

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
                <h1><a href="index.jsp">DapurKue</a></h1>
                <h2>Famously Delicious</h2>
            </div>
            <div id="headright" class="grid_7 prefix_5 omega">
                <choose>
                <when test="${empty userSession.name}" >
                    <h3 class="login">
                        <a href="auth/login">Admin</a> / <a href="user/register1">Sign up</a> / <a href="auth/login">Login</a></h3>
                </when>
                <otherwise>
                    <c:out value="${userSession.name}" />
                    <a href="logout.jsp">Logout </a>
                    <%--<c:out value="${sessionScope['loginUser']}" />--%>
                </otherwise>
                <p>Subtotal: $ 00.00</p>
                </choose>
                <p><span class="vChart"><a href="shoppingcart.jsp">View Cart</a></span> <span class="cOut"><a href="checkout.jsp">Checkout</a></span></p>
            </div>
        </div>
        <div id="mainMenu" class="grid_16">
            <ul>
                <li><a href="index.jsp" class="active">Home</a></li>
                <li><a href="product/list" target="_parent">Cakes</a></li>
                <li><a href="product-details.jsp">Order &amp; Delivery</a></li>
                <li><a href="View-history.jsp">View History</a></li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="admin/addProduct">Add Product</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <li><a href="customer/register">Edit</a></li>
                </sec:authorize>
                <li><a href="#">Contact</a></li>
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
        <div class="products grid_16">
            <div class="productsWarp">
                <ul>
                    <li></li>
                    <li><a href="product-overview.jsp"><img src="resources/images/cake2.jpg" alt="" width="938" height="398" /></a></li>
                    <li><a href="product-overview.jsp"><img src="resources/images/cake3.jpg" alt="" width="938" height="398" /></a></li>
                    <li><a href="product-overview.jsp"><img src="resources/images/cake3.jpg" alt="" width="938" height="398" /></a></li>
                    <li><a href="product-overview.jsp"><img src="resources/images/cake3.jpg" alt="" width="938" height="398" /></a></li>
                </ul>
            </div>
        </div>
        <div class="productThumb grid_10 prefix_3 suffix_3">
            <ul>
                <li class="grid_2 alpha"><a href="#"><img src="resources/images/thumb1.jpg" alt="" width="100" height="60" /></a></li>
                <li class="grid_2"><a href="#"><img src="resources/images/thumb2.jpg" alt="" width="100" height="60" /></a></li>
                <li class="grid_2"><a href="#"><img src="resources/images/thumb1.jpg" alt="" width="100" height="60" /></a></li>
                <li class="grid_2"><a href="#"><img src="resources/images/thumb2.jpg" alt="" width="100" height="60" /></a></li>
                <li class="grid_2 omega"><a href="#"><img src="resources/images/thumb1.jpg" alt="" width="100" height="60" /></a></li>
            </ul>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="fresh">
    <div class="container_16">
        <div id="freshCake" class="grid_16">
            <div class="grid_1 alpha"> <a class="prevButton">&laquo;</a></div>
            <div class="headLine grid_14">
                <h3>Fresh from the oven</h3>
            </div>
            <div class="grid_1 omega"> <a class="nextButton">&raquo;</a></div>
        </div>
        <div class="newCakes">
            <div class="scroller">
                <div class="newCake"><a href="product-details.jsp" class="grid_4"><img src="resources/images/freshCake1.jpg" alt="" width="220" height="120" /></a></div>
                <div class="newCake"><a href="product-details.jsp" class="grid_4"><img src="resources/images/freshCake2.jpg" alt="" width="220" height="120" /></a></div>
                <div class="newCake"><a href="product-details.jsp" class="grid_4"><img src="resources/images/freshCake3.jpg" alt="" width="220" height="120" /></a></div>
                <div class="newCake"><a href="product-details.jsp" class="grid_4"><img src="resources/images/freshCake4.jpg" alt="" width="220" height="120" /></a></div>
                <div class="newCake"><a href="product-details.jsp" class="grid_4"><img src="resources/images/freshCake2.jpg" alt="" width="220" height="120" /></a></div>
                <div class="newCake"><a href="product-details.jsp" class="grid_4"><img src="resources/images/freshCake3.jpg" alt="" width="220" height="120" /></a></div>
                <div class="newCake"><a href="product-details.jsp" class="grid_4"><img src="resources/images/freshCake4.jpg" alt="" width="220" height="120" /></a></div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="richContent">
    <div class="container_16">
        <div class="popularCakes grid_4">
            <h4>Popular Cakes</h4>
            <ul>
                <li><a href="#">Ultimate Choco Brownie</a></li>
                <li><a href="#">Mokakokoa Brownie</a></li>
                <li><a href="#">CoffeeBrown</a></li>
                <li><a href="#">Delicacheese</a></li>
                <li><a href="#">Berries Cheesecake</a></li>
            </ul>
        </div>
        <div class="recommended grid_4">
            <h4>Recommended</h4>
            <ul>
                <li><a href="#">Ultimate Choco Brownie</a></li>
                <li><a href="#">Mokakokoa Brownie</a></li>
                <li><a href="#">CoffeeBrown</a></li>
                <li><a href="#">Delicacheese</a></li>
                <li><a href="#">Berries Cheesecake</a></li>
            </ul>
        </div>
        <div class="specialOffer grid_4">
            <h4>Special Offer</h4>
            <ul>
                <li><a href="#">Ultimate Choco Brownie</a></li>
                <li><a href="#">Mokakokoa Brownie</a></li>
                <li><a href="#">CoffeeBrown</a></li>
                <li><a href="#">Delicacheese</a></li>
                <li><a href="#">Berries Cheesecake</a></li>
            </ul>
        </div>
        <div class="orderPhone grid_4">
            <h4><em>Order by Phone</em> <span>987-654-321</span></h4>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div id="richContent2">
    <div class="container_16">
        <div class="fromBlog grid_4">
            <h4>From the blog</h4>
            <h5>New Recipes in Our Basket</h5>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. vivamus tempor justo sit amet metus cursus consequat. Nulla viverra, felis vel accumsan fermentum... <a href="#" class="bookMan">more &raquo;</a></p>
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