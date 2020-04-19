$(document).ready(function() {
	// 匹配密码，以字母开头，必须包含数字，长度在6-12之间。
	jQuery.validator.addMethod("isPwd", function(value, element) {
		var str = value;
		if (str.length < 6 || str.length > 12)
			return false;
		if (!/^[a-zA-Z]/.test(str))
			return false;
		if (!/[0-9]/.test(str))
			return false;
		return this.optional(element) || /[^A-Za-z0-9]/.test(str);
	}, "以字母开头，必须包含数字，长度在6-12之间");

	$("#user-form").validate({
		errorElement : 'span',
		errorClass : 'help-block',
		rules : {
			name : "required",
			dept: "required",
			role: "required",
			createDate: "required",
			account: "required",
			pwd : {
				required : true,
				isPwd : true
			},
			confirm_pwd : {
				required : true,
				isPwd : true,
				equalTo : "#pwd"
			},
		},
		messages : {
			name : "请输入姓名",
			password : {
				required : "请输入密码",
				minlength : jQuery.format("密码不能小于{0}个字符")
			},
			confirm_password : {
				required : "请输入确认密码",
				minlength : "确认密码不能小于6个字符",
				equalTo : "两次输入密码不一致"
			},
			dept : {
				required : "请输入科室"
			},
			role : {
				required : "请输入职位"
			},
			account : {
				required : "请输入登录账号",
			}
		},
		errorPlacement : function(error, element) {
			element.next().remove();
			element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
			element.closest('.form-group').append(error);
		},
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error has-feedback');
		},
		success : function(label) {
			var el=label.closest('.form-group').find("input");
			el.next().remove();
			el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
			label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
			label.remove();
		},
		submitHandler: function(form) {
			alert("submitted!");
		}

	})
});