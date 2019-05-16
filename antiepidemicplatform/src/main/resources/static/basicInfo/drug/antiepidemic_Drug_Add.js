window.onload = function(){
new Vue({
    el:"#app",
    data:{
        drug:{
        	drugName:'',
        	period:'',
        	usageMode:'',
        	purposeOfUse:'',
        	drugComposition:'',
        	description:'',
        	type:0,
        	areaId:1,//待定
        	orgId:1//待定
            //deviceId:0
        }
    },
    methods:{
    	submit: function() {
    		if(this.drug.drugName==null ||this.drug.drugName.trim()==''){
    			layer.msg(qsrypm);
    			$("#drug").focus();
    			return false;
    		}
    		axios.post('/biz/drug/addDrug',this.drug)
                .then(function (res) {
                    if(res.status==200){
                    	layer.confirm(addSuccess, {
                      btn : [ determine ]
                       }, function() {
                       
                       window.location="/biz/drug/antiepidemic_Drug_List";
                       })
             
                           
                    }else {
                    	layer.confirm(addFailure, {
                      btn : [ determine ]
                       }, function() {
                       
                       window.location="/biz/drug/antiepidemic_Drug_List";
                       })
                    }
                	
                })
                .catch(function (error) {
                	layer.alert(wzcwqlxgly);
                });
    		/*$.ajax({
    	        type: "post",
    	        url: "/biz/forage/addForage",
    	        data:JSON.stringify(this.forage),
    	        dataType: "json",
    	        success: function (result) {
    	        	if(result.code==0){
    	        		layer.msg("添加饲料成功");
    	        	}else{
    	        		layer.msg("添加饲料失败");
    	        	}
    	        	window.location="/biz/forage/forage_List";
    	        }
    		}
    		)*/
        }
    }
});
}