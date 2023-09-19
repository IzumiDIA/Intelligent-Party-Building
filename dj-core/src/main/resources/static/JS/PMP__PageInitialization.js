"use strict";

import {displayImageAfterSelectFile, formDataSubmit, processProgressNode, progressTab2, resetDisplayedImage} from "static/JS/PartyMembershipProcess.js";

window.progressTab2 = progressTab2;
window.displayImageAfterSelectFile = displayImageAfterSelectFile;
window.resetDisplayedImage = resetDisplayedImage;
window.formDataSubmit = formDataSubmit;
Object.freeze(window.document);

document.querySelectorAll(`body > input[hidden="hidden"][name="progress-tab"][type="radio"]`)
	.forEach(function (element) {
		element.addEventListener("click", () => processProgressNode.value = element.value);
		if ( element.id === this ) element.click();
	}, ( () => {
		const windowLocationHash = window.location.hash,
			index = windowLocationHash.indexOf("?", 2);
		return window.decodeURI(index > 2 ? windowLocationHash.substring(1, index) : windowLocationHash.substring(1));
	} )());
