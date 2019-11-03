<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <!-- bootstrap css -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <!-- main css -->
    <link rel="stylesheet" href="main.css" />

    <!-- font awesome -->
    <link rel="stylesheet" href="css/all.css" />
    <title>Đồ án 2</title>
  </head>

  <body>
    <section id="room-info" class="py-5">
      <div class="container">
        <!-- Bảng trạn thái -->
        <div class="row my-5">
          <div class="col-4 mx-auto">
            <div class="card card-body bg-secondary text-uppercase text-center">
              <div class="card-title text-white">
                <h6>Thông tin căn phòng</h6>
              </div>
              <div class="row">
                <p>
                  Nhiệt độ:
                  <span id="room-temp" class="text-light">26</span>
                  <span class="text-light">°C</span>
                </p>
              </div>
              <div class="row">
                <p>
                  Chế độ:
                  <span id="mode" class="text-light">Manual</span>
                </p>
              </div>
            </div>
          </div>
        </div>
        <!-- Kết thúc bảng trạng thái -->

        <div class="row">
          <!-- Đèn 1 -->
          <div class="col-4 text-center d-flex align-items-center flex-column">
            <div class='text-uppercase text-danger font-weight-bold'>
              <p>Đèn 1</p>
            </div>
            <div id="bulb-1" class="bulb-1 mb-3"></div>
            <button 
              class="btn btn-primary text-uppercase" 
              onclick="toggleStatusBulb_1()"
            >
              <span id="bulb-1-status">off</span>
            </button>
          </div>
          <!-- Kết thúc đèn 1 -->

          <!-- Đèn 2 -->
          <div class="col-4 text-center d-flex align-items-center flex-column">
            <div class='text-uppercase text-danger font-weight-bold'>
              <p>Đèn 2</p>
            </div>
            <div id="bulb-2" class="bulb-2 mb-3"></div>
            <button 
              class="btn btn-primary text-uppercase" 
              onclick="toggleStatusBulb_2()"
            >
              <span id="bulb-2-status">off</span>
            </button>
          </div>
          <!-- Kết thúc đèn 2 -->

          <!-- Quạt -->
          <div class="col-4 text-center d-flex align-items-center flex-column">
            <div class='text-uppercase text-danger font-weight-bold'>
              <p>Quạt</p>
            </div>
            <div id="fan" class="fan mb-3"></div>
            <button 
              class="btn btn-primary text-uppercase" 
              onclick="toggleStatusFan()"
            >
              <span id="fan-status">off</span>
            </button>
          </div>
          <!-- Kết thúc quạt -->
        </div>
      </div>
    </section>

    <!-- jquery -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="app.js"></script>
  </body>
  
</html>