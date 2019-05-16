

let mid = '';
$(function () {
	
	//初始化村委会下拉框
    new MySelct({
        id:"selectedPastoral",
        url:"/biz/pastoralCommittee/findPastoralByAreaId",
        value:"id",
        text:"name"
    });

  //初始化民族下拉框
    new MySelct({
        id:"selectedNation",
        url:"/biz/protector/selectEthnic",
        value:"value",
        text:"name",
    });
        //初始化学历下拉框
        new MySelct({
            id:"selectEducationBackground",
            url:"/biz/protector/selectEducationBackground",
            value:"value",
            text:"name",
        });
    
    laydate.render({
        elem: '#birth', //指定元素
        type:"datetime",
        format:"yyyy-MM-dd",
        value:new Date()
    });
    
}
)


// 保存
function saveDogOwner(form) {
	if(form.files.value==''){
		layer.msg(qxzqzzp);
		return false;
	}
	
	if(form.name.value==''){
		layer.msg(qsrqzxm);
		form.name.focus();
		return false;
	}
	if(form.phoneNum.value==''){
		layer.msg(qsrqzdh);
		form.phoneNum.focus();
		return false;
	}
	if(form.cardNum.value==''){
		layer.msg(qsrqzzjhm);
		form.cardNum.focus();
		return false;
	}
	
	var re=/^[1][3,4,5,7,8][0-9]{9}$/;    
	if(!re.test(form.phoneNum.value.trim())){
		layer.msg(qsrzqdsjhm);
		form.phoneNum.focus();
		return false;   
	}
	//检查身份证号
	var reg = /^([0-9]{15}|[0-9]{18})$/;
	if(!reg.test(form.cardNum.value.trim())){
		layer.msg(qsrzzsfzhm);
		form.cardNum.focus();
		return false;   
	}
	var flag1 = false;
	//身份证唯一性判断
	$.ajax({
        type: 'GET',
        url: '/biz/dogOwner/judugeExit',
        data: {cardNum:form.cardNum.value.trim()},
        dataType: "json",
        async: false,
        success: function (r) {
        	if(r.code==1){
        		layer.msg(gsfzhmyjczqcxsr);
        		form.cardNum.focus();
        	}else{
        		flag1=true;
        	}
        },
        error: function () {
        	layer.alert(wzcwqlxgly);
        }
    })
    
    var flag2 = false;
    //电话号码唯一性判断
    $.ajax({
        type: 'GET',
        url: '/biz/dogOwner/judugeExit',
        data: {phoneNum:form.phoneNum.value.trim()},
        dataType: "json",
        async: false,
        success: function (r) {
        	if(r.code==1){
        		layer.msg(gdhhmyjczqcxsr);
        		form.phoneNum.focus();
        	}else{
        		flag2 = true;
        	}
        	
        	
        },
        error: function () {
        	layer.alert(wzcwqlxgly);
        }
    })
    
    if(flag1&&flag2){
    	 //表单提交,添加犬主信息
        var data = $('#dogOwnerAdd').serialize();
        $.ajax({
            type: 'POST',
            url: '/biz/dogOwner/addDogOwner',
            data: data,
            dataType: "json",
            success: function (r) {
                mid = r.id;
                // console.log(r.code);
                uploadPic();
            },
            error: function () {
                // console.log(r.msg);
            }
        })
    }
	
}



function uploadPic() {
    $("#file-1").fileinput("upload");
}

$("#file-1").fileinput({
	language: 'zh', //设置语言
    enctype: 'multipart/form-data',
    theme: 'fa',
    uploadUrl: '/biz/manureDisposal/uploadPic', // you must set a valid URL here else you will get an error
    overwriteInitial: false,
    maxFileSize: 0,
    showUpload:false,
    //showCancel:true,
    uploadAsync:false,       //设置为同步
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    },
    layoutTemplates:{
        actionDelete:'',
        actionUpload:'',
    },
    uploadExtraData:function(){//向后台传递参数
        var data={
            id: mid,
            type: 8
        };
        return data;
    }

    // maxFileCount:4,
    // previewFileIcon:"<iclass='glyphicon glyphicon-king'></i>",
    // uploadAsync:false,
    }).on("filebatchuploadsuccess",function (event,data) {
        // todo 弹框提示，页面跳转
        var code = data['response'].code;
        var msg = data['response'].msg;
        if (code==10001) {
            msg=idNotNull
        }else if(code==10002){
            msg=typeNotNull
        }else if(code==10003){
            msg=uploadPicFailure
        }
        if (code == 0) {
            msg=operationSuccess
            layer.alert(msg);
            layer.confirm(msg, {
                btn : [ determine ]
            }, function() {
                location.href='/biz/dogOwner/dogOwner_List';
            })
            // self.location='/biz/manureDisposal';
            // location.href='/biz/manureDisposal';
        } else {
            layer.alert(msg);
        }
    });
