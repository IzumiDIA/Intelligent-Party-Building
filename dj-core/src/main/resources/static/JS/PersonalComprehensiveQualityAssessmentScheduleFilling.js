// noinspection JSNonASCIINames
"use strict";

const FOCUS_EVENT_ACTIVE = new Event(
	"focusout", {
		bubbles: false,
		cancelable: false,
		composed: false
	});

/**
 * @param {HTMLElement} itemRowContainer 对应标签的ID值
 */
function ScoringItemPush(itemRowContainer) {
	const templateDOM = document.getElementById(`${itemRowContainer.id}-templateRow`).content
		// language=CSS
		                        .querySelector(".Item-Row__Detailed-Pair");
	itemRowContainer.appendChild(templateDOM.cloneNode(true));
}

function ScoringItemPop(pairContainerDOM) {
	if ( pairContainerDOM.hasChildNodes() ) pairContainerDOM.lastElementChild.remove();
}

/**
 * @param {!HTMLOutputElement} resultOutput
 * @param {!HTMLFormElement} that <strong style="color:red;">必须无视⌈any⌋</strong>
 */
function calculateResult(resultOutput, that) {
	// language=CSS
	resultOutput.value = Array.from(that.querySelectorAll(`input[type="number"][name][required]`))
		.map(inputDOM => Number.parseFloat(inputDOM.value))
		.filter(number => !Number.isNaN(number))
		.reduce((leftValue, rightValue) => leftValue + rightValue, 0)
		.toFixed(2);
}

/**
 * @this {HTMLFormElement}
 * @param {SubmitEvent} event
 */
function subjectRowFormSubmit(event) {
	event.preventDefault();
	const subjectRow_DTO = {};
	// language=CSS
	this.querySelectorAll(".Item-Row__Spans").forEach(
		ItemRow__Span => {
			const itemRow__Span_ID_OBJ = {},
				itemRow__Span_ID = ItemRow__Span.id,
				// language=CSS
				description = `input[name="${itemRow__Span_ID}描述"][type="text"]`,
				// language=CSS
				scoreValue = `input[name="${itemRow__Span_ID}分值"][type="number"]`;
			ItemRow__Span.querySelectorAll(".Item-Row__Detailed-Pair").forEach(
				itemRow__DetailedPair =>
					itemRow__Span_ID_OBJ[itemRow__DetailedPair.querySelector(description).value] =
						Number.parseFloat(itemRow__DetailedPair.querySelector(scoreValue).value)
			);
			if ( Object.getOwnPropertyNames(itemRow__Span_ID_OBJ).length !== 0 ) {
				subjectRow_DTO[itemRow__Span_ID] = itemRow__Span_ID_OBJ;
			}
		}
	);
	console.table(subjectRow_DTO);
	console.log(JSON.stringify(subjectRow_DTO));
}

export {
	FOCUS_EVENT_ACTIVE, ScoringItemPush, ScoringItemPop, calculateResult, subjectRowFormSubmit
}
