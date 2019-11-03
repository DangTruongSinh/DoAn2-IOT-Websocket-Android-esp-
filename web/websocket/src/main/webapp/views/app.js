let statusBulb_1 = false;
let statusBulb_2 = false;
let statusFan = false;
let websocket;
class Type{
	constructor(name,status) {
	    this.name = name;
	    this.status = status;
	  }
}
// Chức năng Đèn 1
function toggleStatusBulb_1() {
  statusBulb_1 = !statusBulb_1;
  if (statusBulb_1) {
	  den1 = new Type("den1",1);
  } else {
	  den1 = new Type("den1",0);
  }
  let myjson = JSON.stringify(den1);
  sendMessage(myjson);
 // console.log('Đèn 1 đang mở:', statusBulb_1);
}

// Chức năng Đèn 2
function toggleStatusBulb_2() {
  statusBulb_2 = !statusBulb_2; 
  if (statusBulb_2) {
	  den2 = new Type("den2",1);
  } else {
	  den2 = new Type("den2",0);
  }
  let myjson = JSON.stringify(den2);
  sendMessage(myjson);
  console.log('Đèn 2 đang mở: ', statusBulb_2);
}

// Chức năng Quạt
function toggleStatusFan() {
  statusFan = !statusFan;
  if (statusFan) {
	  quat = new Type("quat",1);
  } else {
	  quat = new Type("quat",0);
  }
  let myjson = JSON.stringify(quat);
  sendMessage(myjson);
  console.log('Đèn 2 đang mở: ', statusBulb_2);
}

function handleTrangThai(object)
{
	if(!object.name.localeCompare('den1'))
	{
		if(object.status == true)
		{
			document.getElementById('bulb-1-status').innerHTML = 'on';
			document.getElementById('bulb-1').style.backgroundColor = 'yellow';
			statusBulb_1 = true;
		}
		else
		{
			 document.getElementById('bulb-1-status').innerHTML = 'off';
			 document.getElementById('bulb-1').style.backgroundColor = 'grey';
			 statusBulb_1 = false;
		}
	}
	else if(!object.name.localeCompare('den2'))
	{
		if(object.status == true)
		{
			document.getElementById('bulb-2-status').innerHTML = 'on';
		    document.getElementById('bulb-2').style.backgroundColor = 'yellow';
		    statusBulb_2 = true;
		}
		else
		{
			 document.getElementById('bulb-2-status').innerHTML = 'off';
			 document.getElementById('bulb-2').style.backgroundColor = 'grey';
			 statusBulb_2 = false;
		}
	    
	}
	else if(!object.name.localeCompare('quat'))
	{
		if(object.status == true)
		{
			document.getElementById('fan-status').innerHTML = 'on';
		    document.getElementById('fan').style.backgroundColor = 'yellow';
		    statusFan = true;
		}
		else
		{
			document.getElementById('fan-status').innerHTML = 'off';
		    document.getElementById('fan').style.backgroundColor = 'grey';
		    statusFan = false;
		}
	}
	else if(!object.name.localeCompare('nhietdo'))
	{
		document.getElementById('room-temp').innerHTML = object.nhietdo;
	}
	else if(!object.name.localeCompare('chedo'))
	{
		if(object.status == true)
			document.getElementById('mode').innerHTML = "AUTO";
		else
			document.getElementById('mode').innerHTML = "MANUAL";
	}
}
function handlePreLoadData(item, index)
{
	console.log(item);
	handleTrangThai(item);
}
function connect() {
  websocket = new WebSocket("ws://localhost:8080/realtime-data");
  websocket.onopen = function(message) {processOpen(message);};
  websocket.onmessage = function(message) {processMessage(message);};
  websocket.onclose = function(message) {processClose(message);};
  websocket.onerror = function(message) {processError(message);};
}
function disconnect() {
  websocket.close();
}

function processOpen(message) {
  console.log("Server connect... \n");
}
function processMessage(message) {
	let obj = JSON.parse(message.data);
	console.log(typeof message.data);
	if(Array.isArray(obj))
	{
		console.log("ke:"+message.data);
		obj.forEach(handlePreLoadData);
	}
	else
	{
		handleTrangThai(obj);
	}
	
}
function processClose(message) {
	console.log("Server Disconnect... \n");
}
function processError(message) {
	console.log("Error... " + message +" \n");
}
function sendMessage(message) {
  if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
    websocket.send(message);
  }
}
connect();
