"use strict";

const sharedWorker = new SharedWorker(
	"WebSocketSharedWorker.js",
	{ type: "module", credentials: "same-origin" }
), webSocket = new WebSocket("ws://localhost:8001");

sharedWorker.port.onmessage = function (event) {

}
webSocket.onopen = function (event) {

}

webSocket.onclose = function (event) {

}

webSocket.onmessage = function (event) {

}

webSocket.onerror = function (event) {
	console.error(event);
	alert(event);
}
