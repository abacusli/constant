$(".nav-ul").on("click",".item-nav",function(){console.log(this),$(".item-nav").find("a").removeClass("current-active"),$(this).find("a").addClass("current-active")}),$(document).on("click","input[data-checkall]",function(){var t=$(this).attr("data-checkall");console.log(t),$('input[name="'+t+'"]').prop("checked",$(this).prop("checked"))}),$(document).ready(function(){$("#calendartime").val(moment().subtract("hours",1).format("YYYY-MM-DD HH:mm:ss")+" - "+moment().format("YYYY-MM-DD HH:mm:ss")),$("#calendartime").daterangepicker({startDate:moment().startOf("day"),endDate:moment(),maxDate:moment(),dateLimit:{days:30},showDropdowns:!0,showWeekNumbers:!1,timePicker:!0,timePickerIncrement:60,timePicker24Hour:!0,ranges:{"今日":[moment().startOf("day"),moment()],"昨日":[moment().subtract("days",1).startOf("day"),moment().subtract("days",1).endOf("day")],"最近7日":[moment().subtract("days",6),moment()],"最近30日":[moment().subtract("days",29),moment()]},opens:"right",buttonClasses:["btn btn-default"],applyClass:"btn-small btn-primary blue",cancelClass:"btn-small",format:"YYYY-MM-DD HH:mm:ss",separator:" to ",locale:{applyLabel:"确定",cancelLabel:"取消",fromLabel:"起始时间",toLabel:"结束时间",customRangeLabel:"自定义",daysOfWeek:["日","一","二","三","四","五","六"],monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],firstDay:1}},function(t,a,e){$("#calendartime").val(t.format("YYYY-MM-DD HH:mm:ss")+" - "+a.format("YYYY-MM-DD HH:mm:ss"))}),$(".pagination-content").pagination({totalData:100,showData:5,coping:!0,homePage:"首页",endPage:"末页"})});