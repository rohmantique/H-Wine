var startIdx = 1;
var endIdx = 6;

window.addEventListener('scroll', function() {
  // 스크롤이 하단에 도달했으면
  if (window.scrollY + window.innerHeight >= document.body.offsetHeight) {
	   console.log("스크롤 실행되나??");
	   sortedList();
	   }
	});

function addWineListInfinity() {
	let val = $("#js_select").val();
	let html = "";
	
	$.ajax({
				url : "/product/sortedAdded",
				type : "GET",
				data : {
					"w_price1": w_price1,
					"w_price2": w_price2,
					"w_type": w_type,
					"wr_nation_kor": wr_nation_kor,
					"wv_variety_kor": wv_variety_kor,
					"w_sweetness": w_sweetness,
					"w_acidity": w_acidity,
					"w_body": w_body,
					"w_tannin": w_tannin,
					"sort" : val,
					"startIdx" : startIdx,
					"endIdx" : endIdx
				},
				beforeSend : function(xhr) {
					let header = $("meta[name='_csrf_header']")
							.attr("content");
					let token = $("meta[name='_csrf']").attr(
							"content");
					xhr.setRequestHeader(header, token);
				},
				success : function(data) {
					//alert("성공");
					for (let i = 0; i < data.length; i++) {
						html += "<li>"
						html += "<div class='item'>"
						html += "<div class='main_img'>"
						html += "<a href=/product/item?w_id="
								+ data[i].w_id
								+ " class='prd_img table_box'><picture>"
						html += "<img src='" + data[i].w_img + "'loading='lazy'> </picture></a>"
						html += "<p class='vivino'>평균 평점<em> "
								+ data[i].avg_db_rating
								+ " </em></p>"
						html += "<div class='label_wrap'>"
						/* html+="<span class='icon new'>NEW</span>" */
						html += "</div>"
						html += "</div>"
						html += "<div class='info'>"
						html += "<div class='more_info'>"
						html += "<p class='prd_name'>"
						html += "<a href='/product/item?w_id=" + data[i].w_id + "'>";
						html += "<span class='list-wine-name'>" + data[i].w_name_kor
							 + "</span>"
						html += "<span class='en list-wine-name-eng'>"
								+ data[i].w_name + "</span></a>"
						html += "</p>"
						html += "</div>"
						html += "<div class='cate_label' style='display:flex;'>"
						html += "<div style='margin-top: 5px; margin-left: 5px;'>"
					         + "<img id='wine_nation_image' src='/resources/asset/images/shop/default/icon_rec_flag_italia.png'>"
					         + "</div>"
						html += "<span style='background: #F6EC9C; padding: 9px; '>"
								+ data[i].w_type  + "</span>"
						html += "<span style='background: #E0D8EA; padding: 3%;' id='wine_nation_kor'>"
								+ data[i].wr_nation_kor + "</span>"
						
						html += "</div>"
						html += "</div>"
						html += "<div class='price_area' style='text-align: right; font-weight: bold;'>"
						html += "<p class='price' style='margin-left:2px; font-size: 13px;'>"
						html += "<ins style='text-decoration-line:none;'><strong>"
								+ comma(data[i].w_price)
								+ "</strong>원</ins>"
						html += "</p>"
						html += "</div>"
						html += "</div>"
						html += "</div>"
						html += "</li>"
					}
						$('#product_ul').append(html);
						startIdx+=6;
						endIdx+=6;
				},

				error : function(request, status, error) {
					alert("code:" + request.status + "\n"
							+ "message:" + request.responseText
							+ "\n" + "error:" + error);
				}
			});
}


															