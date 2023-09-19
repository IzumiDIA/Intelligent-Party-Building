"use strict";

const displayTbody = document.getElementById("display-tbody"),
	tbodyRowTemplate = document.getElementById("tbody-row-template").content;
const dataImgTemplate = ( () => {
	const img = document.createElement('img');
	img.decoding = "async";
	img.referrerPolicy = "no-referrer";
	return img;
} )();

/**
 * @param startIndex {?number | ?string}
 * @param pageSize {?number | ?string}
 * @return {Promise<any>} return the object from response body.
 * @throws {Error} if response code is not validated value, try to get the text information of the response body.
 */
async function pagingQuery(startIndex = 0, pageSize = 8) {
	const response = await window.fetch("../", {
		method: "POST",
		mode: "no-cors",
		redirect: "manual",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: new URLSearchParams(
			{ startIndex: startIndex, pageSize: pageSize }
		)
	});
	if ( response.ok ) {
		return await response?.json();
	}else {
		throw new Error(`Code:${response.status}, Body:${await response?.text()}`);
	}
}

/**
 * @param JSONString {!Object}
 */
function addRecordItem(JSONString) {
	const tbodyRow = tbodyRowTemplate.cloneNode(true);
	tbodyRow.querySelector(".current_node").textContent = JSONString.currentNode;
	tbodyRow.querySelector(".current_subNode").textContent = JSONString.currentSubNode;
	// tbodyRow.querySelector(".current_form_data").textContent = JSON.stringify(JSONString.fileObjArray);
	for ( const { file_AbsPath, fileSourceName } of JSONString.fileObjArray ) {
		console.log(file_AbsPath, fileSourceName);
		const formEntry = document.createElement('p'),
			img = dataImgTemplate.cloneNode(true);
		formEntry.textContent = fileSourceName + ':';
		img.src = "../" + file_AbsPath.substring(file_AbsPath.indexOf("Cache"));
		img.alt = fileSourceName;
		img.title = fileSourceName;
		formEntry.appendChild(img);
		tbodyRow.querySelector(".current_form_data").appendChild(formEntry);
	}
	delete JSONString.currentNode;
	delete JSONString.currentSubNode;
	delete JSONString.fileObjArray;
	for ( const key in JSONString ) {
		tbodyRow.querySelector(".current_form_data").appendChild(document.createTextNode(`[${key}]: ${JSONString[key]}`));
	}
	displayTbody.appendChild(tbodyRow);
}

const testParam = `{"currentNode": "NODE_STATE_1", "fileObjArray": [{"file_AbsPath": "E:\\\\ProjectWare\\\\party-affairs-server\\\\Cache\\\\团员证照片-85200249-0.png", "fileSourceName": "团员证照片"}], "入团时间": "2023-04-09", "currentSubNode": "A"}`;

addRecordItem(JSON.parse(testParam));
