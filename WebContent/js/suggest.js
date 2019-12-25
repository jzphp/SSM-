define("common/js/suggest",["require","exports","module"],function(){var e={create:function(){return function(){this.initialize.apply(this,arguments)}}},t=e.create();return t.prototype={initialize:function(e,t){var s=this.getDom(e);this.History=t,this.container=e,this.searchBtn=s.searchBtn,this.suggestTrigger=s.suggestTrigger,this.suggestPanel=s.suggestPanel,this.clearTextBtn=s.clearTextBtn,this.suggestHistoryPanel=s.suggestHistoryPanel,this.timer=null,this.currIndex=-1,this.addListener()},createSuggest:function(e){var t=this;this.timer&&clearTimeout(this.timer),this.timer=setTimeout(function(){if(e.length>0)t.getTargetSuggest(e);else{if(!isLogin)return void t.clearSuggest();t.getLatestSuggest()}},200)},getTargetSuggest:function(e){var t=this;$.ajax({type:"get",url:"//www.imooc.com/search/history?words="+e,dataType:"jsonp",success:function(e){var s=e&&e.data;s&&t.autoComplete(s)}})},getLatestSuggest:function(){var e=this;return this.History?(e.autoComplete(this.History.getData(),"history"),!1):void $.ajax({type:"GET",url:"//www.imooc.com/index/searchhistory",dataType:"jsonp",success:function(t){t.data.length&&e.autoComplete(t.data)}})},addListener:function(){var e=this;this.suggestTrigger.on({keyup:function(t){switch(e.timer&&clearTimeout(e.timer),t.keyCode){case 38:e.setCurrIndex("up"),e.itemSwitch();break;case 40:e.setCurrIndex("down"),e.itemSwitch();break;case 13:return e.triggerSearch($(this)),!1;default:var s=e.getTriggerValue($(this));e.createSuggest(s),e.setClearTextBtnState(s)}},focus:function(){var t=e.getTriggerValue($(this));e.container.addClass("suggest-active"),e.container.parent().addClass("search-active"),e.createSuggest(t)},blur:function(){e.container.removeClass("suggest-active"),e.container.parent().removeClass("search-active"),setTimeout(function(){e.clearSuggest()},200)}}),this.searchBtn.on("click",function(){e.triggerSearch($(e.suggestTrigger))}),this.suggestPanel.on({click:function(){e.searchBtn.trigger("click")},mouseover:function(){e.currIndex=$(this).index()},mouseout:function(){e.currIndex=-1}},"li"),this.clearTextBtn.on("click",function(){e.clearSearchText()})},itemSwitch:function(e){var t=this.suggestPanel.find("li"),s=null,r="";t.removeClass("light"),this.currIndex>-1&&(s=t.eq(this.currIndex),s.addClass("light"),r=s.data("key"),this.setTriggerValue(r),this.setClearTextBtnState(r),e&&e())},search:function(e){if(this.History)return this.History.setData(e),location.href="//www.imooc.com/search/course?words="+encodeURIComponent(e)+"&type=sz",!1;switch(OP_CONFIG.module){case"wenda":location.href="//www.imooc.com/search/wenda?words="+encodeURIComponent(e);break;case"article":location.href="//www.imooc.com/search/article?words="+encodeURIComponent(e);break;case"course":location.href="//www.imooc.com/search/course?words="+encodeURIComponent(e);break;default:location.href="//www.imooc.com/search/?words="+encodeURIComponent(e)}},autoComplete:function(e,t){var s=[],r="";if(this.currIndex=-1,e.length){if("history"==t&&this.suggestHistoryPanel.length>0)r=this.History.tpl(e);else{for(var i=0,n=e.length;n>i;i++){var a=this.tpl(e[i]);s.push(a)}r=s.join("")}this.suggestPanel.html(r).slideDown(100)}else this.clearSuggest()},triggerSearch:function(e){if(this.currIndex>-1){var t=this.suggestPanel.find("li");this.search(t.eq(this.currIndex).data("key"))}else{var s=this.getTriggerValue(e);if(!s)return this.search(""),!1;this.search(s)}},setTriggerValue:function(e){this.suggestTrigger.val(e)},getTriggerValue:function(e){return $.trim(e.val())},getTriggerEl:function(e){return e.closest("[data-search]").find("[data-suggest-trigger]")},setCurrIndex:function(e){var t=this.suggestPanel.find("li"),s=t.length;this.currIndex="up"===e?this.currIndex>-1?this.currIndex-1:s-1:this.currIndex<s-1?this.currIndex+1:-1},setClearTextBtnState:function(e){e?this.clearTextBtn.removeClass("hide"):this.clearTextBtn.addClass("hide")},clearSearchText:function(){this.setTriggerValue(""),this.clearTextBtn.addClass("hide")},clearSuggest:function(){this.suggestPanel.slideUp(100).delay(100).html("")},tpl:function(e){return'<li data-key="'+e.word+'">'+e.word+"</li>"},getDom:function(e){return{searchBtn:e.find("[data-search-btn]"),suggestTrigger:e.find("[data-suggest-trigger]"),suggestPanel:e.find("[data-suggest-result]"),clearTextBtn:e.find("[data-clear-btn]"),suggestHistoryPanel:e.find("[data-suggest-history]")}}},t});