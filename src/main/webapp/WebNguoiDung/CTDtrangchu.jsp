<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Quản lý Bản Quyền</title>
  <link rel="stylesheet" href="../css/trangchu.css">
</head>
<body>
    <%@ include file="../WebNguoiDung/CTDheader.jsp" %>
    <main>
        <section class="slider-container">
          <div class="slider">
            <div class="slider-item">
              <img src="${pageContext.request.contextPath}/images/hoinghi.jpg" alt="Slider Image">
              <h3>Lễ kết nạp bốn quân chứng ưu tú của Cục Bản quyền tác giả Việt Nam</h3>
              <p>12/03/2025</p>
            </div>
            <div class="slider-item">
              <img src="${pageContext.request.contextPath}/images/hoinghi2.jpg" alt="Slider Image">
              <h3>Hội nghị Tổng kết kết quả thực hiện nhiệm vụ năm 2024 và triển khai</h3>
              <p>12/01/2025</p>
            </div>
            <div class="slider-item">
              <img src="${pageContext.request.contextPath}/images/hoinghi3.jpg" alt="Slider Image">
              <h3>Tài liệu Hội nghị triển khai Chi thị 30/CT-TTg ngày 29/8/2024 của Thủ Tướng</h3>
              <p>30/12/2024</p>
            </div>
          </div>
        </section>

        <section class="services">
          <div class="service-item">
            <img src="${pageContext.request.contextPath}/images/hoinghi4.jpg" alt="Service Image">
            <h3>Đăng ký quyền tác giả, quyền liên quan</h3>
          </div>
          <div class="service-item">
            <img src="${pageContext.request.contextPath}/images/hoinghi5.jpg" alt="Service Image">
            <h3>Tìm kiếm chủ sở hữu quyền tác giả</h3>
          </div>
          <div class="service-item">
            <img src="${pageContext.request.contextPath}/images/hoinghi6.jpg" alt="Service Image">
            <h3>Cấp phép khai thác, sử dụng tác phẩm không tìm được chủ sở hữu</h3>
          </div>
          <div class="service-item">
            <img src="${pageContext.request.contextPath}/images/hoinghi7.jpg" alt="Service Image">
            <h3>Khai thác quyền dịch và quyền sao chép theo phụ lục Công ước Berne</h3>
          </div>
        </section>
    </main>

    <%@ include file="../WebNguoiDung/CTDfooter.jsp" %>
</body>
</html>
