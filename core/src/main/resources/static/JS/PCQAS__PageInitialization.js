"use strict";

import {
	subjectRowFormSubmit, FOCUS_EVENT_ACTIVE, ScoringItemPush, ScoringItemPop, calculateResult
} from "static/JS/PersonalComprehensiveQualityAssessmentScheduleFilling.js";

window.document["FOCUS_EVENT_ACTIVE"] = FOCUS_EVENT_ACTIVE;
window.document["ScoringItemPush"] = ScoringItemPush;
window.document["ScoringItemPop"] = ScoringItemPop;
window.document["calculateResult"] = calculateResult;
Object.freeze(window.document);

document.querySelectorAll("form.PCQAS-Table__Subject-Row").forEach(
	(value, key, parent) => {
		console.log(key);
		value.addEventListener("submit", subjectRowFormSubmit);
	}
);
