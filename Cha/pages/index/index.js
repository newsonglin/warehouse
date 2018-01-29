const app = getApp()
Page({
  data:{},
  forward: function () {
    wx.navigateTo({
      url: '../cha/cha',
      success: function (res) {
        // success  
      },
      fail: function () {
        // fail  
      },
      complete: function () {
        // complete  
      }
    })
  }
})