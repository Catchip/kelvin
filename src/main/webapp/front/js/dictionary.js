
function add(id){
var nowRows=document.getElementById("Tab"+id).rows;
var rows1=nowRows.length-1;
var table1=document.getElementById("Tab"+id).insertRow(rows1);

var addRow1=table1.insertCell(0);
addRow1.innerHTML="<input type='text' id='Num"+rows1+"' placeholder='输入序号'/>";

var addRow2=table1.insertCell(1);
addRow2.innerHTML="<input type='text' id='words"+rows1+"' placeholder='输入名称' />";

var addRow2=table1.insertCell(2);
addRow2.innerHTML="<input type='text' id='title"+rows1+"' placeholder='输入价值' />";

var addRow2=table1.insertCell(3);
addRow2.innerHTML="<input type='text' id='desc"+rows1+"' placeholder='输入状态' />";

var addRow1=table1.insertCell(4);
if(id==0)
{
addRow1.innerHTML="<input type='button' value='删除' onclick='del(this,0)'/><input type='button' value='确定' onclick='sure(this,0)'/>";
}
else{addRow1.innerHTML="<input type='button' value='删除' onclick='del(this,1)'/><input type='button' value='确定' onclick='sure(this,1)'/>";}
}
function del(tt,id){
var table2=document.getElementById("Tab"+id);
table2.deleteRow(tt.parentNode.parentNode.rowIndex);
}
function sure(su,id){
var table4=document.getElementById("Tab"+id).rows;
var rowss=su.parentNode.parentNode.rowIndex;



var cellss=table4[rowss].cells[3];
cellss.innerHTML=document.getElementById("desc"+rowss).value;


var cellss=table4[rowss].cells[2];
cellss.innerHTML=document.getElementById("title"+rowss).value;

var cellss=table4[rowss].cells[1];
cellss.innerHTML=document.getElementById("words"+rowss).value;

var cellss2=table4[rowss].cells[0];
cellss2.innerHTML=document.getElementById("Num"+rowss).value;

var tableCell1=su.parentNode;

if(id==0){tableCell1.innerHTML="<input type='button' value='删除' onclick='del(this,0)'/><input type='button' value='修改' onclick='change(this,0)'/>";}
else{tableCell1.innerHTML="<input type='button' value='删除' onclick='del(this,1)'/><input type='button' value='修改' onclick='change(this,1)'/>";}

}

function change(ch,id){
var table3=document.getElementById("Tab"+id).rows;
var rowss=ch.parentNode.parentNode.rowIndex;



var cellss2=table3[rowss].cells[3];
var oldR2=cellss2.innerHTML;
cellss2.innerHTML="<input type='text' id='desc"+rowss+"' value='' />";
document.getElementById("desc"+rowss).value=oldR2;


var cellss2=table3[rowss].cells[2];
var oldR2=cellss2.innerHTML;
cellss2.innerHTML="<input type='text' id='title"+rowss+"' value='' />";
document.getElementById("title"+rowss).value=oldR2;

var cellss=table3[rowss].cells[1];
var oldR=cellss.innerHTML;
cellss.innerHTML="<input type='text' id='words"+rowss+"' value='' />";
document.getElementById("words"+rowss).value=oldR;

var cellss2=table3[rowss].cells[0];
var oldR2=cellss2.innerHTML;
cellss2.innerHTML="<input type='text' id='Num"+rowss+"' value='' />";
document.getElementById("Num"+rowss).value=oldR2;

var tableCell1=ch.parentNode;
if(id==0){tableCell1.innerHTML="<input type='button' value='删除' onclick='del(this,0)'/><input type='button' value='确定' onclick='sure(this,0)' />";}
else{tableCell1.innerHTML="<input type='button' value='删除' onclick='del(this,1)'/><input type='button' value='确定' onclick='sure(this,1)' />";}
}
