function myFunction() {
  // 声明变量
  var input, filter, table, tr, td, i;
	//获取搜索框输入的内容
  input = document.getElementById("myInput");
  filter = input.value;
	// 获取当前表格下的所有tr
  table = document.getElementById("Tab0");
  tr = table.getElementsByTagName("tr");
 
  // 循环表格每一行，查找匹配项
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
//下面的逻辑代码根据自己的需求以及实际页面的组成编写，我这里给的是搜索到颜色变红
    if (td) {
	var iAndText = td.innerHTML;
	var arr = iAndText.split("</i>");
      if ( filter != "") {
	var a = td[i];
	a.style.color = "red";
      } else {
	var a = td;
	a.style.color = "";
      }
    } 
  }
}