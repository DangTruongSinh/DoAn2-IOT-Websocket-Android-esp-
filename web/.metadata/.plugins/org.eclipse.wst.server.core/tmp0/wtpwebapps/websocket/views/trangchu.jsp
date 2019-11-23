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
          <div class="col-8 mx-auto">
            <div class="card card-body bg-success text-uppercase text-center">
              <div class="card-title text-white">
                <h6>Thông tin căn phòng</h6>
              </div>
              <div class="row ml-3">
                <p>
                  Nhiệt độ:
                  <span id="room-temp" class="text-light">26</span>
                  <span class="text-light">°C</span>
                </p>
              </div>
              <div class="row ml-3">
                <p>
                  Chế độ:
                  <span id="mode-text" class="text-light">Manual</span>
                </p>
              </div>
              <div class="row ml-3">
                <p>
                  thời gian mở: 
                  <span id="time-on" class="text-light">00:00</span>
                </p>
              </div>
              <div class="row ml-3">
                <p>
                  thời gian tắt: 
                  <span id="time-off" class="text-light">00:00</span>
                </p>
              </div>
              <div class="row justify-content-center">
                <button type="button" class="btn btn-danger" data-toggle="modal"  onclick="showAlert()" id="settime-btn">Đặt thời gian</button>
              </div>
            </div>
          </div>
        </div>
        <!-- Kết thúc bảng trạng thái -->

        <div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Thiết lập thời gian</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <div class="form-group row">
                  <label for="example-time-input" class="col-2 col-form-label">Giờ mở</label>
                  <div class="col-10">
                    <input class="form-control" type="time" value="17:30" id="time-on-input">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="example-time-input" class="col-2 col-form-label">Giờ tắt</label>
                  <div class="col-10">
                    <input class="form-control" type="time" value="22:00" id="time-off-input">
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" id="saveChanges" onclick="saveChanges()" data-dismiss="modal">Lưu thay đổi</button>
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <!-- Chế độ -->
          <div class="col mx-auto text-center d-flex align-items-center flex-column mb-4">
            <div class='text-uppercase text-danger font-weight-bold'>
              <p>Chế độ</p>
            </div>
            <button 
              class="btn btn-primary text-uppercase" 
              onclick="toggleMode()"
            >
              <span id="mode-status" class="text-uppercase">automa</span>
            </button>
          </div>
          <!-- Kết thúc chế độ -->
        </div>
        <div class="row">
          <!-- Đèn 1 -->
          <div class="col-4 text-center d-flex align-items-center flex-column">
            <div class='text-uppercase text-danger font-weight-bold'>
              <p>Đèn 1</p>
            </div>
            <div id="bulb-1" class="device mb-3"></div>
            <button 
              class="btn btn-primary text-uppercase" 
              onclick="toggleStatusBulb_1()" style="visibility: visible"
              id = "btn-den1"
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
            <div id="bulb-2" class="device mb-3"></div>
            <button 
              class="btn btn-primary text-uppercase" 
              onclick="toggleStatusBulb_2()" id="btn-den2"
              style="visibility: visible"
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
            <div id="fan" class="device mb-3"></div>
            <button 
              class="btn btn-primary text-uppercase" 
              onclick="toggleStatusFan()" id = "btn-quat"
              style="visibility: visible"
            >
              <span id="fan-status">off</span>
            </button>
          </div>
          <!-- Kết thúc quạt -->
        </div>
      </div>
    </section>
	$(document).ready(function(){
	
    <!-- jquery -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="app.js"></script>
    }
  </body>
</html>
