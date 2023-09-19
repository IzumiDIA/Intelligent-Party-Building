"use strict";

const UPLOAD_FILE_SIZE_LIMIT = 1024 * 1024 * 16,
	progressTab2 = document.getElementById("入党积极分子"),
	processProgressNode = document.getElementById("process-progress-node");

class SendFileObject {
	static #semaphore = 0;

	/**
	 * @param fileSourceName {!string}
	 * @param fileContent {!File}
	 */
	constructor(fileSourceName, fileContent) {
		++SendFileObject.#semaphore;
		this.fileSourceName = fileSourceName;
		const fileReader = new FileReader();
		fileReader.readAsDataURL(fileContent);
		const that = this;
		fileReader.onloadend = function () {
			that.fileContent = this.result;
			--SendFileObject.#semaphore;
		}
	}

	fileSourceName;
	fileContent;

	static get semaphore() {
		return this.#semaphore;
	}

	toString() {
		return JSON.stringify(this);
	}
}

/**
 * @param fileInputDom {!HTMLInputElement}
 */
function displayImageAfterSelectFile(fileInputDom) {
	if ( fileInputDom.files.length > 0 ) {
		const selectedFile = fileInputDom.files[0];
		if ( selectedFile.size < UPLOAD_FILE_SIZE_LIMIT ) fileInputDom.style.backgroundImage = `url("${URL.createObjectURL(selectedFile)}")`;
		else window.alert("This file is too large!");
	}else resetBackgroundImage(fileInputDom);
}

/**
 * @param fileInputDom {!HTMLInputElement}
 */
function resetDisplayedImage(...fileInputDom) {
	fileInputDom.forEach(resetBackgroundImage);
}

/**
 * @param inputElement {!HTMLInputElement}
 */
function resetBackgroundImage(inputElement) {
	inputElement.style.backgroundImage = "initial";
}

/**
 * @param formDOM {!HTMLFormElement}
 * @param sectionID {?string}
 * @param formName {?string}
 * @return {boolean} always <code>false</code>.
 */
function formDataSubmit(formDOM, sectionID = formDOM.parentNode.id, formName = formDOM.name) {
	console.log(formDOM.querySelector("input"));
	const sendData = {
		currentNode: sectionID,
		currentSubNode: formName,
		fileObjArray: []
	};
	formDOM.querySelectorAll("input[required]").forEach((v, k, p) => {
		if ( v.type === "file" ) {
			sendData.fileObjArray.push(new SendFileObject(v.name, v.files[0]));
		}else {
			sendData[v.name] = v.value.toString();
		}
	});
	console.log(sendData);
	const id = window.setInterval(() => {
		if ( SendFileObject.semaphore === 0 ) {
			const requestBody = JSON.stringify(sendData);
			console.log(requestBody);
			requestJSONFetch(requestBody);
			window.clearInterval(id);
		}
	}, 100);
	window.setTimeout(() => window.clearInterval(id), 5000);
	return false;
}

/**
 * @param requestBody {!string}
 */
function requestJSONFetch(requestBody) {
	window.fetch("../partyMembershipProcess", {
		method: "PUT", // NOTE: 'PUT' is unsupported in no-cors mode.
		redirect: "manual",
		headers: {
			"Content-Type": "application/json; charset=UTF-8"
		},
		body: requestBody
	}).then(response => {
		console.log("response.status: ", response.status);
		return response.text();
	}).then(bodyData => {
		console.log("bodyData", bodyData);
	}).catch(reason => {});
}

/**
 * @param fileInputDom {!HTMLInputElement}
 */
function uploadFileCache(fileInputDom) {
	window.fetch("", {
		method: "PUT", // NOTE: 'PUT' is unsupported in no-cors mode.
		redirect: "manual",
		body: fileInputDom.files[0],
		headers: {
			"Content-Type": fileInputDom.files[0].type
		}
	}).then(response => {
		if ( response.ok ) {
			// TODO
		}else {
			throw new Error(`错误的状态码: [${response.status}], 状态信息: “${response.statusText}”`);
		}
	}).catch(reason => {
	});
}

/**
 * @param JSON_String {!string}
 */
function applicationSumit(JSON_String) {
	window.fetch("", {
		method: "PUT",
		mode: "no-cors",
		redirect: "manual",
		headers: {
			"Content-Type": "application/json; charset=UTF-8"
		},
		body: JSON_String
	}).then(response => {
		return response.formData()
	}).catch(reason => {
		console.error(reason);
	});
}

export {
	progressTab2, processProgressNode,
	displayImageAfterSelectFile, resetDisplayedImage, formDataSubmit
}
