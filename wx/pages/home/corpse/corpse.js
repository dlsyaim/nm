var image = require("../../../apis/image.js")
var config = require("../../../apis/config.js")
var dateFormat = require("../../../apis/dateFormat.js")
var http = require("../../../apis/request.js")
var httpSync = require("../../../apis/request_sync.js")

var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    component: {
      placeholderText: "溯源ID"
    },
    ishasData:true,
    isLoad:false,
    corpseArray: [
      {
        corpseImage: image.corpseImage,
        deviceId: "GDQ201707006214",
        causeOfDeath: "疾病",  //死亡原因
        dealTime: "2018-05-21 12:45"
      },
      {
        corpseImage: image.corpseImage,
        deviceId: "GDQ201707006214",
        causeOfDeath: "疾病",  //防疫药品名称
        dealTime: "2018-05-21 12:45"
      }
    ],
    maxLength: 6, //默认最大显示8个
    params: {
      index: 0,
      pageSize: 6,
    }
  },

  /**
   * 查询犬尸处理
   */
  searchCorpse(e){
    var that = this;
    that.setData({
      corpseArray: [],
      params: {
        index: 0,
        pageSize: 6,
      },
      query: e.detail.val
    })
    var query = e.detail.val;
    this.getScanList(query);
  },

  /**
   * 扫码查询犬尸处理
   */
  scanSearchCorpse(e) {
    var that = this;
    that.setData({
      corpseArray: [],
      params: {
        index: 0,
        pageSize: 6,
      },
      query: e.detail.val
    })
    var query = e.detail.val;
    this.getScanList(query);
  },

  //获取列表
  getScanList(query) {
    var that = this;
    var url = config.url.BASE_URL + "/corpseDisposal/findWXCorpseDisposalList";
    var token = app.globalData.token;
    var params = that.data.params;
    if (query && query != "") {
      params.searchKey = query
    }
    http.httpGet(url, token, params, function (res) {
      if (!res.rows || res.rows.length <= 0) {
        that.setData({
          corpseArray: []
        })
        return;
      }
      var data = res.rows;
      for (var index in data) {
        if (data[index].createDate != '' && data[index].createDate != null) {
          data[index].createDate = dateFormat(data[index].createDate, "yyyy-MM-dd HH:mm")
        }
      }
      if (data.length > 0) {
        that.setData({
          corpseArray: data,
        })
      }
    })
  },
  /**
   * 获取犬尸处理列表
   */
  getList(query,fun){
    var that = this;
    var url = config.url.BASE_URL + "/corpseDisposal/findWXCorpseDisposalList";
    var token = app.globalData.token;
    var params = that.data.params;
    if (query && query !=""){
      params.searchKey = query
    }
    http.httpGet(url, token, params, function (res) {
      console.log(res)
      var data = res.rows;
      if (data.length > 0) {
        for (var index in data) {
          if (data[index].createDate != '' && data[index].createDate != null) {
            data[index].createDate = dateFormat(data[index].createDate, "yyyy-MM-dd HH:mm")
          }
        }
        that.setData({
          corpseArray: that.data.corpseArray.concat(data),
        })
      }
      typeof fun == "function" && fun(data); 
    })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      corpseArray: [],
      maxLength: 6,
      params: {
        index: 0,
        pageSize: 6
      },
      isLoad:true
    });
    var query = that.data.query;
    that.getList(query, function (data) {
      if (!data || data.length == 0) {
        that.setData({
          ishasData: false
        })
        return;
      }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this;
    if (that.data.isLoad){
      that.setData({
        isLoad:false
      })
      return;
    }
    that.setData({
      corpseArray: [],
      maxLength: 6,
      params: {
        index: 0,
        pageSize: 6
      }
    });
    var query = that.data.query;
    that.getList(query,function(data){
      if (data && data.length > 0) {
        that.setData({
          ishasData: true
        })
        return;
      }
    });
  },

  /**
   * 跳转到犬尸处理页面
   */
  toCorpseInfoPage(e){
      var that = this;
      var index =  e.currentTarget.dataset.index;
      var corpse_index =   that.data.corpseArray[index];
      wx.navigateTo({
        url: '/pages/home/corpse/info/info?corpse_index=' + JSON.stringify(corpse_index),
      })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    var that = this;
    var query = that.data.query;
    that.setData({
      maxLength: that.data.maxLength * 2,
      params: {
        index: that.data.params.index + 6,
        pageSize: 6
      }
    });
    that.getList(query);
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  toCorpseAddPage(){
    wx.navigateTo({
      url: '/pages/home/corpse/add/add',
    })
  }

})