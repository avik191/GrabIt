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

/*------*/
/* for fading out the alert message after 3 seconds */
$alert = $('.alert');
if($alert.length) {
	setTimeout(function() {
    	$alert.fadeOut('slow');
	   }, 3000
	);		
}

/* for admin data table*/

var $productsTable = $('#adminproductsTable');


if($productsTable.length) {
	
	var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
	console.log(jsonUrl);
	
	$productsTable.DataTable({
				lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
				pageLength : 30,
				ajax : {
					url : jsonUrl,
					dataSrc : ''
				},
				columns : [		
				           	{data: 'id'},


				           	{data: 'code',
				           	 bSortable: false,
				           		mRender: function(data,type,row) {
				           			return '<img src="' + window.contextRoot
									+ '/resources/images/' + data
									+ '.png" style="width:50px;height:50px"/>';					           			
				           		}
				           	},
				           	{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'isActive',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if(data) {											
										str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
										
									}else {
										str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
									}
									
									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

									return str;
								}
							}					           	
				],
				
				
				initComplete: function () {
					var api = this.api();
					api.$('.switch input[type="checkbox"]').on('change' , function() {							
						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dText = (checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
						var value = checkbox.prop('value');
					    bootbox.confirm({
					    	size: 'medium',
					    	title: 'Product Activation/Deactivation',
					    	message: dText,
					    	callback: function (confirmed) {
						        if (confirmed) {
						        	
						        	var activationUrl = window.contextRoot+'/manage/product/'+value+'/activation';
						        	$.post(activationUrl,function(data){
						        		bootbox.alert({
							            	size: 'medium',
							            	title: 'Information',
							            	message: data
							            });
						        	});
						        	
						        }
						        else {							        	
						        	checkbox.prop('checked', !checked);
						        }
					    	}
					    });																											
					});
						
				}
			});
}
//***********************//


// jQuery Validation Code

//methods required for validation

function errorPlacement(error, element) {
	// Add the 'help-block' class to the error element
	error.addClass("help-block");
	
	// add the error label after the input element
	error.insertAfter(element);
	
		

}	



// validating the product form element	
// fetch the form element
$categoryForm = $('#categoryForm');

if($categoryForm.length) {
	
	$categoryForm.validate({			
			rules: {
				name: {
					required: true,
					minlength: 2
				},
				description: {
					required: true,
					minlength: 3					
				}				
			},
			messages: {					
				name: {
					required: 'Please enter product name!',
					minlength: 'Please enter atleast two characters'
				},
				description: {
					required: 'Please enter product name!',
					minlength: 'Please enter atleast three characters'
				}					
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				errorPlacement(error, element);
			}				
		}
	
	);
	
}