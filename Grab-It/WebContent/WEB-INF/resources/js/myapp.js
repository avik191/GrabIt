var products = [
			['1','ABC'],
			['2','DEF'],
			['3','DSA'],
			['4','GFG'],
			['5','WER'],
			['6','FSD'],
			['7','SDF'],
			['8','HFG'],
			['9','YUT'],
			['10','UYT'],
			['11','TUY'],
			['12','UIO'],
			['13','RTE']
	];

var $table = $('#tableProductList');

//execute the code only when there is a table
if($table.length)
{
	//console.log("inside table");
	$table.DataTable({
		pageLength: 5,
		lengthMenu: [[3,6,9,-1],['3 Entries','6 Entries','9 Entries','All Entries']],
		data: products
	});
}