(function($){
	var __validate = $.fn.validate;
	$.fn.forumvalidate = function(opts) {
		var __rules = $.extend({
			username:"required",
			password:"required",
			name:"required",
			confirmPwd:{
				equalTo:"#password"
			},
			email:"email",
			title:"required",
			cid:{
				min:1
			},
			newName:"required"
		},opts?(opts.rules||{}):{});
		var __messages = $.extend({
			username:"The user name cannot be empty",
			password:"User passwords cannot be empty",
			confirmPwd:"The two input passwords are incorrect",
			email:"The mail format is incorrect",
			name:"The name cannot be empty",
			cid:"The article must choose the column",
			title:"The title of the article must be typed",
			newName:"The homepage image must be uploaded"
		},opts?(opts.messages||{}):{});
		var __defaultOpts = $.extend(opts||{},{
			rules:__rules,
			messages:__messages,
			errorElement: opts?(opts.errorElement||"span"):"span",
			errorClass:opts?(opts.errorClass||"errorContainer"):"errorContainer"
		});
		$.extend($.fn.validate.prototype,__defaultOpts);
		__validate.call(this,__defaultOpts);
		return this;
	}
})(jQuery)