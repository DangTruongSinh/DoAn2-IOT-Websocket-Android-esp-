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
				<a href="/login?action=logout">Logout</a>
				<!-- Bảng trạn thái -->
				<div class="row my-5">
					<div class="col-8 mx-auto" id="khung_giua">

						<div class="card-title text-white">
							<h6 id="tieude">Thông tin căn phòng</h6>
						</div>

						<div class="row ml-3">
							<p class="textfont">
								Chế độ:
								<span id="mode-text" class="text-light">Manual</span>
							</p>
							<label class="switch">
								<input type="checkbox" onclick="toggleMode()">
								<span class="slider round"></span>
							</label>
						</div>
						<div class="row ml-3 textfont">
							<p class="textfont">
								Thời gian mở: 
								<span id="time-on" class="text-light">00:00</span>
							</p>
						</div>
						<div class="row ml-3 ">
							<p class="textfont">
								Thời gian tắt: 
								<span id="time-off" class="text-light">00:00</span>
							</p>
						</div>
						<div class="row justify-content-center">
							<button type="button" class="btn btn-danger" data-toggle="modal"  onclick="showAlert()" id="settime-btn">Đặt thời gian</button>
						</div>
						<div class="container khung_duoi">
							<div class="row ">
								<!-- Đèn 1 -->
								<div class="col-3 cot1">
									<div class=" text-center d-flex align-items-center flex-column col-push-5">
										<div class='font-weight-bold'>
											<p class="text-light">Đèn1</p>
										</div>
										<div id="bulb-1" class="device mb-3"></div>
										<button id = "btn-den1"
										class="btn btn-primary text-uppercase" 
										onclick="toggleStatusBulb_1()"
										>
										<span id="bulb-1-status">off</span>
										</button>
								</div>
							</div>
							<!-- Đèn 2 -->
							<div class="col-3 cot2" >

								<div class="col-push-5 text-center d-flex align-items-center flex-column">
									<div class='font-weight-bold'>
										<p class="text-light">Đèn2</p>
									</div>
									<div id="bulb-2" class="device mb-3">

									</div>
									<button id = "btn-den2"
									class="btn btn-primary text-uppercase" 
									onclick="toggleStatusBulb_2()"
									>
									<span id="bulb-2-status">off</span>
								</button>
							</div>
						</div>

						<!-- Quạt -->
						<div class="col-3 cot3">
							<div class="col-push-5 text-center d-flex align-items-center flex-column">
								<div class='font-weight-bold'>
									<p class="text-light" style="margin: 0;padding: 0;">Quạt</p>
								</div>
								<!--<div id="fan" class="device mb-3"></div> -->
								<img id = "fan" class = "" src="quat.png">
								<button id = "btn-quat" style="background-color:#007BFF;color:white;"
								class="btn text-uppercase" 
								onclick="toggleStatusFan()"
								>
								<span id="fan-status">off</span>
							</button>
						</div>
					</div>
					<!-- Kết thúc quạt -->
					<div class="col-3 cot4">
						<div class="col-push-5 align-items-center text-center">
							<p style="margin: 0;padding: 0" class='font-weight-bold text-light'>Nhiệt độ:</p>
							<img src="cloud.png">
							<br>
							<span id="room-temp" class="text-light">26</span>
                  			<span class="text-light">°C</span>
						</div>
					</div>
					
				</div>
			</div>

		</div>



	</div>
</div>
<!-- Kết thúc bảng trạng thái -->


</div>


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
</section>

<!-- jquery -->
<script src="js/jquery-3.3.1.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.bundle.min.js"></script>
<script src="app.js"></script>
</body>
</html>

