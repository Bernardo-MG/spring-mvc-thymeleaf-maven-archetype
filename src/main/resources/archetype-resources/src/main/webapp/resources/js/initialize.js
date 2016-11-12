/**
 * Licensed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Loads all the Javascript functions used by the site.
 *
 * This requires access to the code in the following Javascript files:
 * - chevron-toggle.js
 * - smooth-scroll.js
 */

/**
 * Initializes scripts when the document loads.
 */
$(document).ready(function() {

	// Sets up chevron toggling
	initChevronToggle();

	// Sets up smooth scroll
	initSmoothScroll();

	// Initializes tooltips
	$('body').tooltip({
	    selector: '[data-toggle=tooltip]'
	});

	$(".dataTable").DataTable({
		"renderer" : "bootstrap",
		"order" : [],
		"columnDefs" : [ {
			"targets" : "no-sort",
			"orderable" : false,
		}, {
			"targets" : "hidden",
			"visible" : false,
		} ]
	});

});
