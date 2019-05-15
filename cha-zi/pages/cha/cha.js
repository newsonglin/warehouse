const WORDS = require('../../utils/words.js')

Array.prototype.contains = function (obj) {
  var i = this.length;
  while (i--) {
    if (this[i] === obj) {
      return true;
    }
  }
  return false;
}



var pageObject = {
    data: {
      inputTextWidth: wx.getSystemInfoSync().windowWidth*0.77,
      inputWord:'',
      searchResult: '',
      searchResultNumber:-1000, //-1:no input; 0: empty return; 1: must return; 2:green return;
    },
    bindSearchWordInput:function(e){
      this.setData({
        inputWord: e.detail.value,
        searchResult:'',
        searchResultNumber: -1000
      })
    },
    
    doSearch: function (e) {
      var inputWord=this.data.inputWord;
      if(inputWord==''){
        this.setData({
          //searchResult: "你啥都没输入呀！",
          searchResultNumber:-1
        })
        return;
      }

      var result="这个字没有学过哟！";
      var resultNumber=0;//Assume nothing returned

      //Search in must words map
      for(var entry of WORDS.MUST_MAP){
        if (entry[1].contains(inputWord)) {
          result = entry[0];  
          resultNumber=1;
          break;
        }
      }

      //Search in green words map
      if(resultNumber==0){//search green map only when must map returns no result
        for (var entry of WORDS.GREEN_MAP) {
          if (entry[1].contains(inputWord)) {
            result = entry[0];
            resultNumber = 2;
            break;
          }
        }
      }

      this.setData({
        searchResult: result,
        searchResultNumber:resultNumber
      })
    },
  }

Page(pageObject)