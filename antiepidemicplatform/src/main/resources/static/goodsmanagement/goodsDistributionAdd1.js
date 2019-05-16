$(function () {
    validateRule();
    //初始化物资类型下拉列表
    new MySelct({
        id:"goodsType",
        url:"/biz/manureDisposal/initSelectData",
        value:"value",
        text:"name",
        params: {
            type: "goods_type"
        }
    });
    //初始化接收人下拉列表(本乡组织的所有防疫员)
    new MySelct({
        id:"receiver",
        url:"/biz/protector/initProtectorSel2",
        value:"id",
        text:"name"
    });

})

$.validator.setDefaults({
    submitHandler : function(form) {
        $(form).find(":submit").attr("disabled", true).attr("value", "Submitting...");
        save();
    }
});

function save() {
    debugger

    let data = $('#saveGoodsDistribution').serialize();
    $.ajax({
        type: 'POST',
        url: '/biz/goodsInfo/save',
        data: data,
        dataType: "json",
        success: function (r) {
            layer.confirm(operationSuccess, {
                btn : [ determine ]
            }, function() {
                location.href='/biz/goodsInfo';
            })
        },
        error: function () {
            // console.log(r.msg);
        }
    })
}


function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#saveGoodsDistribution").validate({
        rules : {
            goodsName : {
                required : true
            },
            goodsAmount : {
                required : true,
                min : 1,
                digits:true
            }
        },
        messages : {
            goodsName : {
                required : icon + pleaseInputGoodsName
            },
            goodsAmount : {
                required : icon + pleaseInputNumber,
                digits : icon + onlyInputPosInt
            }
        }
    })
}
