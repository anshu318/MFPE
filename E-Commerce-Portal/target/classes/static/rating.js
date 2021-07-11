var val = 0;
(function($, window, document, undefined) {
	// undefined is used here as the undefined global
	// variable in ECMAScript 3 and is mutable (i.e. it can
	// be changed by someone else). undefined isn't really
	// being passed in so we can ensure that its value is
	// truly undefined. In ES5, undefined can no longer be
	// modified.

	// window and document are passed through as local
	// variables rather than as globals, because this (slightly)
	// quickens the resolution process and can be more
	// efficiently minified (especially when both are
	// regularly referenced in your plugin).

	// Create the defaults once
	var pluginName = "ratingStar",
		defaults = {
			initialStar: 0,
			selectedClass: "is-selected",
			hoverClass: "is-hover",
			afterClick: null,
		};

	// The actual plugin constructor
	function Plugin(element, options) {
		this.$element = $(element);

		this.options = $.extend({}, defaults, options);

		this._defaults = defaults;
		this._name = pluginName;

		this.init();
	}

	Plugin.prototype = {
		init: function() {
			var self = this;

			this.$starItems = this.$element.find(".c-rating-star__item");

			/* 1. Visualizing things on Hover - See next part for action on click */
			this.$starItems
				.on("mouseover", function() {
					self.onMouseOver(self, this);
				})
				.on("mouseout", function() {
					self.onMouseOut(self, this);
				});

			/* 2. Action to perform on click */
			this.$starItems.on("click", function() {
				self.onClick(self, this);
			});
		},

		onClick: function(context, jqContext) {
			var $this = $(jqContext);
			var $stars = context.$starItems;
			var onStar = parseInt($this.data("value"), 10); // The star currently selected

			// remove all active star
			$stars.removeClass("is-selected");

			for (i = 0; i < onStar; i++) {
				$stars.eq(i).addClass("is-selected");
			}

			var $selected = $this.parent().children(".is-selected").last();
			var ratingValue = parseInt($selected.data("value"), 10);

			if (context.options.afterClick) {
				context.options.afterClick(ratingValue, $selected);
			}
		},

		onMouseOver: function(context, jqContext) {
			// The star currently mouse on
			var currentStar = parseInt($(jqContext).data("value"), 10);

			// all start item
			var $stars = context.$starItems;

			// Now highlight all the stars that's not after the current hovered star
			for (i = 0; i <= currentStar; i++) {
				if (i < currentStar) {
					$stars.eq(i).addClass("is-hover");
				} else {
					$stars.eq(i).removeClass("is-hover");
				}
			}
			val = currentStar;
		},

		onMouseOut: function(context, jqContext) {
			for (i = 0; i <= context.$starItems.length; i++) {
				context.$starItems.eq(i).removeClass("is-hover");
			}
		},
	};

	// A really lightweight plugin wrapper around the constructor,
	// preventing against multiple instantiations
	$.fn[pluginName] = function(options) {
		return this.each(function() {
			if (!$.data(this, "plugin_" + pluginName)) {
				$.data(this, "plugin_" + pluginName, new Plugin(this, options));
			}
		});
	};
})(jQuery, window, document);

$(document).ready(function() {
	$(".js-rating-star").ratingStar({
		afterClick: function(value, el) { },
	});
});