var $table = $('#tableProductList');

// execute the code only when there is a table
if ($table.length) {
	var jsonUrl = '';
	if (window.categoryId == '') {
		jsonUrl = window.contextRoot + "/json/data/all/products";
	} else {
		jsonUrl = window.contextRoot + "/json/data/category/"
				+ window.categoryId + "/products";
	}
	// console.log("inside table");
	$table
			.DataTable({

				lengthMenu : [ [ 3, 5, 10, -1 ],
						[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
				pageLength : 5,
				// data: products -- load static data into table from products
				// array
				ajax : {
					url : jsonUrl,
					dataSrc : ''
				},

				columns : [
						{
							data : 'code',
							mRender : function(data, type, row) {
								return '<img src="'
										+ window.contextRoot
										+ '/resources/images/'
										+ data
										+ '.png" style="width:100px;height:100px" />'
							}
						},
						{
							data : 'name'
						},
						{
							data : 'brand'
						},
						{
							data : 'unitPrice',
							mRender : function(data, type, row) {
								return '&#8377; ' + data
							}
						},
						{
							data : 'quantity',
							mRender : function(data, type, row) {
								if (data < 1) {
									return '<span style="color:red">Out Of Stock</span>'
								}
								return data
							}
						},
						{
							data : 'id',
							bSortable : false,
							mRender : function(data, type, row) {
								var str = '';
								str += '<a href="'
										+ window.contextRoot
										+ '/show/'
										+ data
										+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
								
								
								if(row.quantity<1){
									str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								}
								else{
									str += '<a href="'
										+ window.contextRoot
										+ '/add/'
										+ data
										+ '/cart" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								}
								
								
								return str
							}
						}

				]

			});
}