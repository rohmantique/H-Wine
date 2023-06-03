<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" type="text/css"
	href="${RESOURCES_PATH}/css/shop/main.css">
<link rel="stylesheet" type="text/css"
	href="${RESOURCES_PATH}/css/shop/slick.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<html lang="ko">
<body>

	<style>
.wrap .logo {
	padding-top: 16px;
}

::-webkit-scrollbar {
	display: none;
}

.swiper-pagination-progressbar-fill {
	background: #46675c !important;
}

.con_area.con3 {
	padding: 30px 0 0;
	/*background-color: #f2f4f5;*/
}

.main_page .con_area.con3 .inner_box {
	padding: 0 18px 47px;
	font-size: 17px;
	font-weight: 700;
}

.main_page .con_area.con3 .text_wrap {
	padding: 0 12px;
	line-height: 2.1;
	font-size: 25px;
}

.main_page .con_area.con3 .select_wrap {
	position: relative;
	word-break: keep-all;
	margin: 0 auto;
	width: fit-content;
}

.con_area.con3 .select_wrap .inp_select {
	position: static;
}

.con_area.con3 .select_wrap .inp_select .select_list {
	position: absolute;
	left: 0;
	top: 0;
	bottom: 0;
	height: auto;
	padding: 0;
	font-size: 20px;
	font-weight: 700;
	color: #46675c;
	line-height: 2;
	background: none;
	z-index: 1;
	opacity: 0;
}

.con_area.con3 .select_wrap .inp_select option {
	font-size: 17px;
	cursor: pointer;
	padding: 13px 12px;
}

.inp_select .select_list option {
	color: #1b2529;
}

.con_area.con3 .select_wrap .select_box {
	position: relative;
	display: inline-flex;
	align-items: center;
	width: 50%;
	border: none;
	border-bottom: 3px solid #46675c;
	color: #46675c;
	font-weight: 600;
	justify-content: center;
}

.con_area.con3 .select_wrap .select_box span {
	padding-right: 26px;
}

.con_area.con3 .select_wrap .select_box span::after {
	position: absolute;
	left: auto;
	bottom: 20px;
	flex-shrink: 0;
	display: inline-block;
	width: 20px;
	height: 20px;
	margin: 0 0 0 9px;
	background: url(/resources/asset/images/shop/default/arr_down5.png)
		no-repeat;
	background-size: contain;
	content: "";
}

.con_area.con3 .inner_box .btn_wrap {
	margin-top: 33px;
}

.bunker_products_box {
	font-size: 17px;
	font-weight: 300;
}

.bunker_products {
	/*display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;*/
	
}

}
.bunker_product {
	/*border: 1px solid;*/
	padding: 8px 1em;
	min-width: 212px;
	max-width: 212px;
}

.bunker_en {
	font-size: 13px;
	color: darkgray;
	display: block;
}

#bunker_wfood {
	
}

.bunker_item {
	display: flex;
	align-items: center;
}

.select-style {
	border: 1px solid #ccc;
	width: 150px;
	border-radius: 3px;
	overflow: hidden;
	background: #fafafa url("img/icon-select.png") no-repeat 90% 50%;
}

.select-style select {
	width: 110%;
	border: none;
	box-shadow: none;
	background: transparent;
	background-image: none;
	-webkit-appearance: none;
}

.select-style select:focus {
	outline: none;
}

.bunker_item>.main_img {
	width: 35%;
	margin: 0 auto;
	display: flex;
	justify-content: flex-end;
}

.bunker_item>.info {
	width: 65%;
}
</style>
	<div class="mainSlide main-swiper">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<a href="/product/list?ctgr=4"> <img alt=""
					src="/resources/asset/banner/mainSlide1.jpg"></a>
			</div>
			<div class="swiper-slide">
				<img alt="" src="/resources/asset/banner/mainSlide2.jpg">
			</div>
			<div class="swiper-slide">
				<a href="/product/listFood/돼지"> <img alt=""
					src="/resources/asset/banner/mainSlide3.jpg"></a>
			</div>
			<div class="swiper-slide">
				<a href="/product/listFood/닭고기"> <img alt=""
					src="/resources/asset/banner/mainSlide4.jpg"></a>
			</div>
		</div>
		<div class="swiper-pagination"
			style="position: relative; margin-top: -7px;"></div>
	</div>
	<!-- header -->
	<div class="layer wine_profile_layer"></div>
	<!-- //와인 프로파일 레이어 -->

	<!-- 알림설정 레이어 -->
	<div class="layer push_layer" id="push_layer">
		<div class="display_table">
			<div class="table_cell">
				<div class="layer_area">
					<button type="button" class="layer_close"
						onclick="commonUI.layer.close()">
						<span>Layer Close</span>
					</button>
					<div class="layer_tit">알림설정</div>
					<div class="layer_con">
						<ul>
							<li>
								<div class="btn switch">
									<strong class="tit">푸시알림</strong>
									<div class="btn_switch_module js_switch css_switch">
										<input type="checkbox" id="btn_switch01"
											class="btn_switch_check" onchange="">
										<div class="btn_switch_area">
											<div class="btn_switch">
												<label class="bar" for="btn_switch01">&nbsp;</label>
											</div>
										</div>
									</div>
								</div>
								<p class="info">와인나라 앱에서 보내는 알림을 받을 수 있습니다.</p>
							</li>
							<li>
								<div class="btn switch">
									<strong class="tit">광고성 정보 수신 동의</strong>
									<div class="btn_switch_module js_switch css_switch">
										<input type="checkbox" id="btn_switch02"
											class="btn_switch_check" onchange="">
										<div class="btn_switch_area">
											<div class="btn_switch">
												<label class="bar" for="btn_switch02">&nbsp;</label>
											</div>
										</div>
									</div>
								</div>
								<p class="info">신규서비스 및 고객 맞춤 혜택 정보를 받을 수 있습니다.</p>
							</li>
							<li>
								<div class="btn switch">
									<strong class="tit">야간 수신 동의</strong>
									<div class="btn_switch_module js_switch css_switch">
										<input type="checkbox" id="btn_switch03"
											class="btn_switch_check" onchange="">
										<div class="btn_switch_area">
											<div class="btn_switch">
												<label class="bar" for="btn_switch03">&nbsp;</label>
											</div>
										</div>
									</div>
								</div>
								<p class="info">야간(오후 9시 ~ 오전8시)에 알림을 받을 수 있습니다.</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //알림설정 레이어 -->

	<!-- 알림내역 레이어 -->
	<div class="layer push_lists_layer" id="push_lists_layer">
		<div class="display_table">
			<div class="table_cell">
				<div class="layer_area">
					<button type="button" class="layer_close"
						onclick="commonUI.layer.close()">
						<span>Layer Close</span>
					</button>
					<div class="layer_tit">알림내역</div>
					<div class="layer_con">
						<ul>
							<li><strong class="tit">4월 이달의 와인</strong>
								<p class="info">봄에 어울리는 색, 그리고 향을 테마로 준비한 이달의 와인 5종을 소개합니다.</p>
								<div class="img">
									<img
										src="/resources/asset/images/shop/product/mb_recom_lnb.jpg"
										alt="">
								</div>
								<div class="btn_box">
									<span class="date">2022.04.01</span>
									<button type="button" class="btn_more">자세히보기</button>
								</div></li>
							<li><strong class="tit">아발론 브랜드 기획전</strong>
								<p class="info">최고 가성비 와인, 아바론 브랜드 기획전</p>
								<div class="btn_box">
									<span class="date">2022.04.01</span>
									<button type="button" class="btn_more">자세히보기</button>
								</div></li>
							<li><strong class="tit">아발론 브랜드 기획전</strong>
								<p class="info">최고 가성비 와인, 아바론 브랜드 기획전</p>
								<div class="btn_box">
									<span class="date">2022.04.01</span>
									<button type="button" class="btn_more">자세히보기</button>
								</div></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //알림내역 레이어 -->

	<!-- 설정 레이어 -->
	<div class="layer set_layer">
		<div class="display_table">
			<div class="table_cell">
				<div class="layer_area">
					<button type="button" class="layer_close btn_close"
						onclick="commonUI.layer.close()">
						<span>Layer Close</span>
					</button>
					<div class="layer_tit">설정</div>
					<div class="layer_con">
						<strong class="tit">푸시설정</strong>
						<div class="set_con">
							<span>알림설정</span>
							<div class="btn_switch_module js_switch css_switch">
								<input type="checkbox" id="btn_alarm" class="btn_switch_check"
									onchange="push_ajax('push',this);">
								<div class="btn_switch_area">
									<div class="btn_switch">
										<!-- <span class="txt left">ON</span> -->
										<label class="bar" for="btn_alarm">&nbsp;</label>
										<!-- <span class="txt right">OFF</span> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //설정 레이어 -->


	<input type="hidden" id="path_gb" value="MOBILE">

	<!-- contents -->
	<section id="contents" style="margin-top: 55px;">	
		<div class="content main_page">
			<div class="main_visual"></div>
			<sec:authorize access="isAnonymous()">
				<div class="section slide_prd product_lists_page">
					<div
						style="display: flex; justify-content: space-between; margin-bottom: 20px;">
						<span style="font-size: 25px; font-weight: 500;"> H-믈리가
							추천하는 와인 </span> <a href="/decanting/bookList" class="btn_more"
							style="top: auto;">더보기</a> <br>
					</div>
					<div style="margin-bottom: 10px;">
						<span style="font-size: 17px; font-weight: 500;">H-WINE에서 선정한 H-믈리의 추천 와인이에요.
						</span>
					</div>
					<!-- 개인 마케팅 -->

					<div class="prd_wrap swiper">
						<ul class="n_prd_list se_list swiper-wrapper"
							style="overflow: visible;">
							<c:forEach items="${mainProduct}" var="product"
								varStatus="status">
								<c:if test="${product.key eq 'nonLogin'}">
									<c:forEach items="${product.value}" var="nonproduct"
										varStatus="status">
										<li class="swiper-slide" style="border-right: 2px solid #ddd;">
											<div class="item">
												<div style="margin-top: 5px;">
													<c:if test="${10 ne status.count}">
														<span style="font-size: 68px;">0<c:out
																value="${status.count}"></c:out>
														</span>
													</c:if>
													<c:if test="${status.count eq 10 }">
														<span style="font-size: 68px;"> <c:out
																value="${status.count}"></c:out>
														</span>
													</c:if>
												</div>
												<div class="main_img">
													<a href="/product/item?w_id=${nonproduct.w_id }"
														class="prd_img table_box"> <picture> <img
															src="${nonproduct.w_img }" alt=""> </picture>
													</a>
												</div>
												<div class="info">
													<div class="more_info">
														<p class="prd_name" style="font-size: 14px;">
															<a href="/product/item?w_id=${nonproduct.w_id }"> <span>${nonproduct.w_name_kor
														}</span>
																<span class="en"
																style="font-size: 13px; color: darkgray;">${nonproduct.w_name
														}</span>
															</a>
														</p>
													</div>
													<div class="info">
														<div class="price_area" style="margin-right: 18px;">
															<p class="price" style="font-size: 14px;">
																<ins>
																	<strong> <fmt:formatNumber
																			value="${nonproduct.w_price }" pattern="#,###" />
																	</strong>원
																</ins>
															</p>
														</div>
													</div>
												</div>
											</div>
										</li>
									</c:forEach>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<div class="separator"
					style="width: 465px; height: 8px; background: #ececec !important;"></div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<c:if test="${recProList.size() > 0 }">
					<div class="section slide_prd product_lists_page">
						<div
							style="display: flex; justify-content: space-between; margin-bottom: 20px;">
							<span style="font-size: 25px; font-weight: 500;"> <sec:authentication
									property="principal.mnickname" />의 취향에 맞을 만한 와인
							</span> <a href="/decanting/bookList" class="btn_more"
								style="top: auto;">더보기</a>
						</div>
						<div style="margin-bottom: 10px;">
							<span style="font-size: 17px; font-weight: 500;"> <sec:authentication
									property="principal.mnickname" />님이 작성한 디캔팅 북 기반으로 추천드려요.
							</span>
						</div>
						<!-- 개인 마케팅 -->
						<div class="prd_wrap swiper">
							<ul class="n_prd_list se_list swiper-wrapper"
								style="overflow: visible;">
								<c:forEach items="${recProList}" var="recPro" varStatus="status">
									<li class="swiper-slide" style="border-right: 2px solid #ddd;">
										<div class="item">
											<div style="margin-top: 5px;">
												<c:if test="${10 ne status.count}">
													<span style="font-size: 68px;">0<c:out
															value="${status.count}"></c:out></span>
												</c:if>
												<c:if test="${status.count eq 10 }">
													<span style="font-size: 68px;"> <c:out
															value="${status.count}"></c:out>
													</span>
												</c:if>
											</div>
											<div class="main_img">
												<a href="/product/item?w_id=${recPro.w_id }"
													class="prd_img table_box"> <picture> <img
														src="${recPro.w_img }" alt=""> </picture>
												</a>
											</div>
											<div class="info">
												<div class="more_info">
													<p class="prd_name" style="font-size: 14px;">
														<a href="/product/item?w_id=${recPro.w_id }"> <span>${recPro.w_name_kor
													}</span>
															<span class="en"
															style="font-size: 13px; color: darkgray;">${recPro.w_name }</span>
														</a>
													</p>
												</div>
												<div class="info">
													<div class="price_area" style="margin-right: 18px;">
														<p class="price" style="font-size: 14px;">
															<ins>
																<strong> <fmt:formatNumber
																		value="${recPro.w_price }" pattern="#,###" />
																</strong>원
															</ins>
														</p>
													</div>
												</div>
											</div>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</c:if>
				<c:if test="${birthAndGender.size() > 0 }">
					<div class="section slide_prd product_lists_page">
						<div
							style="display: flex; justify-content: space-between; margin-bottom: 20px;">
							<span style="font-size: 25px; font-weight: 500;"> <sec:authentication
									property="principal.mnickname" />님, 이런 와인은 어때요?
							</span> <br>
						</div>
						<div style="margin-bottom: 10px;">
							<span style="font-size: 17px; font-weight: 500;"> <sec:authentication
									property="principal.mnickname" />님의 연령대에서 많이 구매한 와인이에요.
							</span>
						</div>
						<!-- 개인 마케팅 -->

						<div class="prd_wrap swiper">
							<ul class="n_prd_list se_list swiper-wrapper"
								style="overflow: visible;">
								<c:forEach items="${birthAndGender}" var="bgProduct"
									varStatus="status">
									<c:if test="${bgProduct.key eq 'birthAndGender'}">
										<c:forEach items="${bgProduct.value}" var="product"
											varStatus="status">
											<li class="swiper-slide"
												style="border-right: 2px solid #ddd;">
												<div class="item">
													<div style="margin-top: 5px;">
														<c:if test="${10 ne status.count}">
															<span style="font-size: 68px;">0<c:out
																	value="${status.count}"></c:out></span>
														</c:if>
														<c:if test="${status.count eq 10 }">
															<span style="font-size: 68px;"> <c:out
																	value="${status.count}"></c:out>
															</span>
														</c:if>
													</div>
													<div class="main_img">
														<a href="/product/item?w_id=${product.w_id }"
															class="prd_img table_box"> <picture> <img
																src="${product.w_img }" alt=""> </picture>
														</a>
													</div>
													<div class="info">
														<div class="more_info">
															<p class="prd_name" style="font-size: 14px;">
																<a href="/product/item?w_id=${product.w_id }"> <span>${product.w_name_kor
													}</span>
																	<span class="en"
																	style="font-size: 13px; color: darkgray;">${product.w_name }</span>
																</a>
															</p>
														</div>
														<div class="info">
															<div class="price_area" style="margin-right: 18px;">
																<p class="price" style="font-size: 14px;">
																	<ins>
																		<strong> <fmt:formatNumber
																				value="${product.w_price }" pattern="#,###" />
																		</strong>원
																	</ins>
																</p>
															</div>
														</div>
													</div>
												</div>
											</li>
										</c:forEach>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>
				</c:if>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<div class="separator"
					style="width: 465px; height: 8px; background: #ececec !important;"></div>
			</sec:authorize>

			<!-- 신상품 -->
			<div class="prd_wrap slide_prd section newarrivals"
				style="margin-top: 30px;">
				<div
					style="display: flex; justify-content: space-between; margin-bottom: 20px;">
					<span style="font-size: 25px; font-weight: 500;">오직 H-WINE
						에서만</span> <a href="/product/list?ctgr=8" class="btn_more"
						style="top: auto;">더보기</a>
				</div>
				<div style="margin-bottom: 10px;">
					<span style="font-size: 17px; font-weight: 500;">H-WINE 에서
						새롭게 선보이는 와인이에요. </span>
				</div>
				<div class="prd_wrap swiper">
					<ul class="n_prd_list swiper-wrapper" style="overflow: visible;">
						<c:forEach items="${mainProduct}" var="product">
							<c:if test="${product.key eq 'new'}">
								<c:forEach items="${product.value}" var="new123"
									varStatus="status">
									<li class="swiper-slide" style="border-right: 2px solid #ddd;">
										<div class="item">
											<div style="margin-top: 5px;">
												<c:if test="${10 ne status.count}">
													<span style="font-size: 68px;">0<c:out
															value="${status.count}"></c:out></span>
												</c:if>

												<c:if test="${status.count eq 10 }">
													<span style="font-size: 68px;"><c:out
															value="${status.count}"></c:out></span>
												</c:if>

											</div>
											<div class="main_img">
												<a href="/product/item?w_id=${new123.w_id}"
													class="prd_img table_box"> <picture> <img
														src="${new123.w_img }" alt=""> </picture>
												</a>
											</div>
											<div class="info">
												<div class="more_info">
													<p class="prd_name">
														<a href="/product/item?w_id=${new123.w_id}"> <span>${new123.w_name_kor }</span>
															<span class="en"
															style="font-size: 13px; color: darkgray;">${new123.w_name }</span>
														</a>
												</div>
												<div class="info">
													<div class="cate_label"
														style="display: flex; align-items: center; margin-top: 10px;">
														<span
															style="background: #E0D8EA; padding: 7px; display: none;"
															id="wine_nation_kor">${new123.wr_nation_kor }</span>
														<div style="margin-left: 5px;">
															<!-- <img id="wine_nation_image" src=""> -->
														</div>
														<c:choose>
															<c:when test="${new123.wr_nation_kor eq '이탈리아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_italia.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '프랑스'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_france.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '스페인'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_spain.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '독일'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_germ.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '미국'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_usa.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '칠레'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_chile.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '아르헨티나'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_argentina.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '호주'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_aus.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '남아프리카'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/south-africa.jpg">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '포르투갈'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/portugal.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '뉴질랜드'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/newzealand.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '오스트리아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/austria.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '캐나다'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/canada.jpg">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '크로아티아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/croatia.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '조지아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/georgia.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '불가리아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/bulgaria.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '슬로베니아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/slovenia.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '우루과이'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/uruguai.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '그리스'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/greece.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '루마니아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/rumania.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '이스라엘'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/israel.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '레바논'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/lebanon.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '몰도바'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/moldova.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '일본'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/japan.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '중국'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/china.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '대한민국'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/korea.png">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '헝가리'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/hungary.jpg">
															</c:when>
															<c:when test="${new123.wr_nation_kor eq '영국'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/uk.png">
															</c:when>
														</c:choose>
														<input type="hidden" value="${new123.w_type }"
															id="wineType">
														<c:choose>
															<c:when test="${new123.w_type eq '레드'}">
																<span
																	style="background: #ffd8d8; padding: 7px; margin-bottom: 0px">${new123.w_type }
																</span>
															</c:when>
															<c:when test="${new123.w_type eq '로제'}">
																<span
																	style="background: #FFDEC6; padding: 7px; margin-bottom: 0px">${new123.w_type }
																</span>
															</c:when>
															<c:when test="${new123.w_type eq '화이트'}">
																<span
																	style="background: #f3f5ff; padding: 7px; margin-bottom: 0px">${new123.w_type }
																</span>
															</c:when>
															<c:when test="${new123.w_type eq '고도주'}">
																<span
																	style="background: #d8d3f6; padding: 7px; margin-bottom: 0px">${new123.w_type }
																</span>
															</c:when>
															<c:when test="${new123.w_type eq '주정강화'}">
																<span
																	style="background: #d7edff; padding: 7px; margin-bottom: 0px">${new123.w_type }
																</span>
															</c:when>
															<c:when test="${new123.w_type eq '스파클링'}">
																<span
																	style="background: #d8e6ff; padding: 7px; margin-bottom: 0px">${new123.w_type }
																</span>
															</c:when>
															<c:when test="${new123.w_type eq '기타'}">
																<span
																	style="background: #d8e6ff; padding-top: 9px; margin-bottom: 0px; height: 30px;">${new123.w_type }
																</span>
															</c:when>
														</c:choose>
														<%-- <div style="display: flex;">
															<p class="price"
																style="font-size: 13px; margin-left: 7px; font-weight: bold;">
																<ins style="text-decoration: none;">
																	<fmt:formatNumber value="${new123.w_price }"
																		pattern="#,###" />
																	</strong>원
																</ins>
															</p>
														</div> --%>
													</div>
													<div class="price_area" style="margin-right: 18px;">
														<p class="price"
															style="display: flex; justify-content: flex-start;">
															<ins>
																<fmt:formatNumber value="${new123.w_price }"
																	pattern="#,###" />
																</strong>원
															</ins>
														</p>
													</div>
												</div>
											</div>
									</li>
								</c:forEach>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="separator"
				style="width: 465px; height: 8px; background: #ececec !important;"></div>
			<!-- 베스트 -->
			<div class="section slide_prd product_lists_page"
				style="margin-top: 30px;">

				<div
					style="display: flex; justify-content: space-between; margin-bottom: 20px;">
					<span style="font-size: 25px; font-weight: 500;">요즘 잘 나가는 와인</span>
					<a href="/product/list?ctgr=7" class="btn_more" style="top: auto;">더보기</a>
				</div>
				<div style="margin-bottom: 10px;">
					<span style="font-size: 17px; font-weight: 500;">H-WINE 에서 잘
						나가는 와인이에요. </span>
				</div>

				<div class="prd_wrap swiper">
					<ul class="n_prd_list se_list swiper-wrapper"
						style="overflow: visible;">
						<c:forEach items="${mainProduct}" var="product">
							<c:if test="${product.key eq 'best'}">
								<c:forEach items="${product.value}" var="best"
									varStatus="status">
									<li class="swiper-slide" style="border-right: 2px solid #ddd;">
										<div class="item">
											<div style="margin-top: 5px;">
												<c:if test="${10 ne status.count}">
													<span style="font-size: 68px;">0<c:out
															value="${status.count}"></c:out></span>
												</c:if>

												<c:if test="${status.count eq 10 }">
													<span style="font-size: 68px;"><c:out
															value="${status.count}"></c:out></span>
												</c:if>

											</div>
											<div class="main_img">
												<a href="/product/item?w_id=${best.w_id }"
													class="prd_img table_box"> <picture> <img
														src="${best.w_img }" alt=""> </picture>
												</a>
												<p class="vivino">
													평균평점<em>${best.avg_rating }</em>
												</p>
											</div>
											<div class="info">
												<div class="more_info">
													<p class="prd_name" style="font-size: 14px;">
														<a href="/product/item?w_id=${best.w_id }"> <span>${best.w_name_kor }</span>
															<span class="en"
															style="font-size: 13px; color: darkgray;">${best.w_name }</span>
														</a>
													<p class="vivino">
														평균평점<em>${best.avg_rating }</em>
													</p>
												</div>
												<div class="info">
													<div class="cate_label"
														style="display: flex; align-items: center; margin-top: 10px;">
														<span
															style="background: #E0D8EA; padding: 7px; display: none;"
															id="wine_nation_kor">${best.wr_nation_kor }</span>
														<div style="margin-left: 5px;">
															<!-- <img id="wine_nation_image" src=""> -->
														</div>
														<c:choose>
															<c:when test="${best.wr_nation_kor eq '이탈리아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_italia.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '프랑스'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_france.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '스페인'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_spain.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '독일'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_germ.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '미국'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_usa.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '칠레'}">
																<img style="margin-top: 0px;" id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_chile.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '아르헨티나'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_argentina.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '호주'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/icon_rec_flag_aus.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '남아프리카'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/south-africa.jpg">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '포르투갈'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/portugal.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '뉴질랜드'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/newzealand.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '오스트리아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/austria.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '캐나다'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/canada.jpg">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '크로아티아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/croatia.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '조지아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/georgia.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '불가리아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/bulgaria.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '슬로베니아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/slovenia.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '우루과이'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/uruguai.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '그리스'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/greece.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '루마니아'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/rumania.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '이스라엘'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/israel.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '레바논'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/lebanon.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '몰도바'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/moldova.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '일본'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/japan.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '중국'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/china.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '대한민국'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/korea.png">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '헝가리'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/hungary.jpg">
															</c:when>
															<c:when test="${best.wr_nation_kor eq '영국'}">
																<img style="margin-top: 0px; margin-right: 10px;"
																	id="wine_nation_image"
																	src="/resources/asset/images/shop/default/uk.png">
															</c:when>
														</c:choose>
														<input type="hidden" value="${best.w_type }" id="wineType">
														<c:choose>
															<c:when test="${best.w_type eq '레드'}">
																<span
																	style="background: #ffd8d8; padding: 7px; margin-bottom: 0px">${best.w_type }
																</span>
															</c:when>
															<c:when test="${best.w_type eq '로제'}">
																<span
																	style="background: #FFDEC6; padding: 7px; margin-bottom: 0px">${best.w_type }
																</span>
															</c:when>
															<c:when test="${best.w_type eq '화이트'}">
																<span
																	style="background: #f3f5ff; padding: 7px; margin-bottom: 0px">${best.w_type }
																</span>
															</c:when>
															<c:when test="${best.w_type eq '고도주'}">
																<span
																	style="background: #d8d3f6; padding: 7px; margin-bottom: 0px">${best.w_type }
																</span>
															</c:when>
															<c:when test="${best.w_type eq '주정강화'}">
																<span
																	style="background: #d7edff; padding: 7px; margin-bottom: 0px">${best.w_type }
																</span>
															</c:when>
															<c:when test="${best.w_type eq '스파클링'}">
																<span
																	style="background: #d8e6ff; padding: 7px; margin-bottom: 0px">${best.w_type }
																</span>
															</c:when>
															<c:when test="${best.w_type eq '기타'}">
																<span
																	style="background: #d8e6ff; padding-top: 9px; margin-bottom: 0px; height: 30px;">${best.w_type }
																</span>
															</c:when>
														</c:choose>
														<%-- <div style="display: flex;">
															<p class="price"
																style="font-size: 13px; margin-left: 7px; font-weight: bold;">
																<ins style="text-decoration: none;">
																	<fmt:formatNumber value="${best.w_price }"
																		pattern="#,###" />
																	</strong>원
																</ins>
															</p>
														</div> --%>
													</div>
													<div class="price_area" style="margin-right: 18px;">
														<p class="price"
															style="font-size: 14px; display: flex; justify-content: flex-start;">
															<ins>
																<strong> <fmt:formatNumber
																		value="${best.w_price }" pattern="#,###" />
																</strong>원
															</ins>
														</p>
													</div>
												</div>
											</div>
										</div>
									</li>
								</c:forEach>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="separator"
				style="width: 465px; height: 8px; background: #ececec !important;"></div>
			<div>
				<div>
					<video autoplay loop muted playsinline poster="aaa" preload="bbb"
						style="width: 465px">
						<source src="/resources/asset/banner/main_video.mp4"
							type="video/mp4">
					</video>
				</div>
				<div class="separator"
					style="width: 465px; height: 8px; background: #ececec !important;"></div>
				<div>
					<!-- 코우ㅣ에 start -->
					<div class="con_area con3">
						<div class="inner_box">
							<div class="text_wrap" id="mainKeywordRecom"
								style="margin: auto; width: 340px;">
								<div class="select_wrap">
									<div class="inp_select">
										<select id="keywordSelect1" class="select_list select-style">
											<option value="소고기">소고기</option>
											<option value="치즈">치즈</option>
											<option value="해산물">해산물</option>
											<option value="튀김">튀김</option>
											<option value="과일">과일</option>
											<option value="생선회">회</option>
											<option value="하몽">하몽</option>
											<option value="리조또">리조또</option>
											<option value="돼지">돼지고기</option>
											<option value="초콜릿">초콜릿</option>
											<option value="닭고기">닭고기</option>
										</select>
									</div>
									<div id="bunker_wfood" class="select_box select_box_1">
										<span class="text_1"></span>
									</div>
									<font id="bunker_wfood_txt"><span id="food_waga"></span>
										<br> 함께하면 어떨까요? </font>
								</div>

							</div>

							<div class="bunker_products_box">
								<ul class="bunker_products">
								</ul>
							</div>
						</div>
						<div class="btn_wrap" style="margin-bottom: 50px;">
							<button class="btn_txt" id="mainSearchKeywordRecom"
								onclick="location.href='/product/list'"
								style="font-size: 16px; width: 90%;">더 많은 와인 보러가기</button>
						</div>

					</div>
				</div>
				<div class="separator"
					style="width: 465px; height: 8px; background: #ececec !important;"></div>
				<!-- 코우ㅣ에 end -->
			</div>

			<!-- 리뷰 레이어 (유형 퍼블 추가) -->
			<div class="layer review_img_layer">
				<div class="display_table">
					<div class="table_cell">
						<div class="layer_area">
							<button type="button" class="layer_close"
								onclick="commonUI.layer.close()">
								<span>Layer Close</span>
							</button>
							<div class="layer_tit">리뷰 보기</div>
							<div class="layer_con" id="review_div"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- //리뷰 레이어 (유형 퍼블 추가) -->


			<!-- //page_script -->
	</section>
	<script type="text/javascript">
		const swiper = new Swiper('.swiper', {
			slidesPerView : 3,
			spaceBetween : 10,
		});
		const mainSwiper = new Swiper('.main-swiper', {
			slidesPerView : 1,
			autoplay : {
				delay : 5000,
			},
			pagination : {
				el : ".swiper-pagination",
				type : "progressbar",
			},
			loop : true,
		});
		
		function getWineListWithFood(wfood){
			$.ajax ({
				  url	: "/getWineFoodList/" + wfood, 
				  type	: "GET", 
				  success : function(data, status) {
					//console.log(data, status);
					$('.bunker_products').empty();
					let str = '';
					$.each(data.wines, function (idx, item) {
						//console.log(idx, item);
						let price = item.wprice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
						
						if(idx % 2 == 0){
							str = `
								<li class="bunker_product">
								<div class="bunker_item">
									<div class="main_img">
										<a href="/product/item?w_id=\${item.wid}" class="prd_img table_box">
											 <img
												src="\${item.wimg}"
												alt="" width="130">
										</a>
									</div>
									<div class="info">
										<div class="more_info">
											<p class="prd_name">
												<a href="/product/item?w_id=\${item.wid}"> <span>\${item.wnamekor}</span>
												<br><span class="bunker_en">\${item.wname}</span>
												</a>
											</p>
										</div>
										<!--  <div class="cate_label">
										<span style="background: #F6EC9C">\${item.wvariety}</span> <span
											style="background: #E0D8EA">\${item.wtype}</span> <span
											style="background: #C8D792">Corvina</span>
									</div>-->
										<div class="price_area">
											<p class="price">\${price}원</p>
										</div>
									</div>
								</div>
							</li>`;
							
							
						}else{
							str = `
								<li class="bunker_product">
								<div class="bunker_item">
									<div class="info"  style="margin-left: 76px;">
										<div class="more_info">
											<p class="prd_name">
												<a href="/product/item?w_id=\${item.wid}"> <span>\${item.wnamekor}</span>
												<br><span class="bunker_en">\${item.wname}</span>
												</a>
											</p>
										</div>
										<!--  <div class="cate_label">
										<span style="background: #F6EC9C">\${item.wvariety}</span> <span
											style="background: #E0D8EA">\${item.wtype}</span> <span
											style="background: #C8D792">Corvina</span>
									</div>-->
										<div class="price_area">
											<p class="price">\${price}원</p>
										</div>
									</div>
									<div class="main_img">
									<a href="/product/item?w_id=\${item.wid}" class="prd_img table_box">
										 <img
											src="\${item.wimg}"
											alt="" width="130">
									</a>
								</div>
								</div>
							</li>`;
						}
							$('.bunker_products').append(str);
							
							if(idx != 4){
								$('.bunker_products').append('<div style="Width:95%; height: 1px; background:rgba(70, 103, 92, 0.5); margin: 4px auto"></div>');
							}
					});
				  },
				  error	: function(status, error) {
					  console.log("와인 음식 잘못 에러");
				  }
				});
		}
		
		$(function(){
			
			let options_len = $('#keywordSelect1 option').length;
			let random = Math.floor(Math.random() * options_len);

			if(random == 2 || random == 3 || random == 4 || random == 6 || random == 9){
				$('#food_waga').text(' 과 ');
			}else{
				$('#food_waga').text(' 와 ');
			}
			
			let wfood = $('#keywordSelect1 option:eq(' + random+')').val();
			//console.log(random, wfood);
			getWineListWithFood(wfood);
			$('#keywordSelect1 option:eq(' + random+')').prop("selected", true);
			$('.text_1').text($('#keywordSelect1 option:selected').text());

		});
		
		$(document).ready(function(){
			$('#header > div.top').css('display', 'none');
			  $("#Allcontents").scroll(function(){
			        let scroll = $("#Allcontents").scrollTop();
			        //console.log('scroll', scroll, $('#header > div.top'));
			        if(scroll > 335){
			        	$('#header > div.top').css('display', 'block');
			        }else{
			        	$('#header > div.top').css('display', 'none');
			        }
			    });
			  let never_written_dbook = '${never_written_dbook}';
			  if(never_written_dbook == 'true'){
					Swal.fire({
						  text: "작성한 디켄팅북이 없습니다!",
						  showCancelButton: false,
						  confirmButtonColor: '#46675c',
						  confirmButtonText: '확인'
						});
			  }
			});
		
		$('#header > div.bottom').css('display', 'none');
		
		$('#keywordSelect1').on("change", function(){
			getWineListWithFood($('#keywordSelect1 option:selected').val());
			$('.text_1').text($('#keywordSelect1 option:selected').text());
			$('#keywordSelect1 option:selected').prop("selected", true);
			console.log($('#keywordSelect1 option:selected').val(), $('#keywordSelect1 option:selected').text(), "change!!");
			
			let val = $('#keywordSelect1 option:selected').text();
			let waga = val.charAt(val.length-1);
			console.log(waga);
			if(waga == '물' || waga == '김' || waga == '일' || waga == '릿' || waga == '몽'){
				$('#food_waga').text(' 과 ');
			}else{
				$('#food_waga').text(' 와 ');
			}
		});
		
	</script>
	<!-- //contents -->