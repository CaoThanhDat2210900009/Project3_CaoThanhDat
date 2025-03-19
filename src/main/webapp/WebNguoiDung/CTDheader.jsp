<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Header Example</title>
  <link rel="stylesheet" href="../css/home.css">
</head>
<body>
  <header>
    <div class="header-container">
      <div class="logo">
       <img src="${pageContext.request.contextPath}/images/tritue.jpg" alt="Logo">
      </div>
      
      <!-- Thêm ảnh ở giữa logo và hotline -->
      <div class="center-image">
        <img src="${pageContext.request.contextPath}/images/anhbia.png" alt="Center Image">
      </div>
      
      <div class="contact-info">
        <a href="tel:+0914195266">Hotline: 0914195266</a>
      </div>
    </div>
    <nav>
      <ul>
        <li><a href="CTDtrangchu.jsp">Trang Chủ</a></li>
        <li><a href="CTDgioithieu.jsp">Giới thiệu</a></li>
        <li><a href="#">Bản Quyền</a>
          <ul class="dropdown">
            <li><a href="CTDtacgia.jsp">Tác Giả</a></li>
            <li><a href="CTDsach.jsp">Sách</a></li>
            <li><a href="CTDbanquyen.jsp">Bản Quyền</a></li>
            <li><a href="CTDnxb.jsp">Nhà Xuất Bản</a></li>
          </ul>
        </li>
        <li><a href="CTDluat.jsp">Luật Bản Quyền</a></li>
        <li><a href="https://www.facebook.com/atay.441221/?locale=vi_VN">Liên Hệ</a></li>
      </ul>
    </nav>
  </header>
</body>
</html>
