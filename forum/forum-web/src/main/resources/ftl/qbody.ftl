<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<#macro indexQuestionList indexQuestion titleSize showDate=true hasH=false hasDt=true showDot=true df="MM/dd" divId="" hrefClz="">
	<div ${(divId=="")?string("","id='${divId}'")}>
		<#if hasH>
			<#nested/>
		</#if>
		<dl>
			<#if hasDt>
				<dt><#nested/></dt>
			</#if>
			<#list indexQuestion.questions as question>
				<dd>
					<a title="${question.title}" href="question/${question.id}" ${(hrefClz=="")?string("","class='${hrefClz}'")}>
						<#if showDate>[${(question.publishDate)?string("${df}")}]</#if>
						<#if question.title?length gt titleSize>
							${question.title[0..titleSize]}<#if showDot>...</#if>
						<#else>
							${question.title}
						</#if>
					</a>
				</dd>
			</#list>
		</dl>
	</div>
</#macro>
<div id="content">
	<div id="content_con">
		<div id="xiaoxun"></div>
		<div id="notice_rollpic">
			<@indexQuestionList indexQuestion=qs["1"] titleSize=12 divId="notice" hrefClz="index_link">
				<span><a href="qchannel/${qs["1"].cid}" class="index_title_href">${qs["1"].cname}</a></span>
			</@indexQuestionList>
			<div id="rollpic">
				<div id="rollCaption"><span></span></div>
				<div id="rollPager"></div>
				<#list pics as pic>
					<a href="${pic.linkUrl}" title="${pic.title}"><img src="<%=request.getContextPath()%>/resources/indexPic/${pic.newName}" border="0"/></a>
				</#list>
			</div>
		</div>
		<div id="split_line"></div>
		<div id="xwgk_xxgk">
			<@indexQuestionList indexQuestion=qs["2"] hasH=true hasDt=false titleSize=37 divId="xwgk" hrefClz="index_link">
				<h3><a href="qchannel/${qs["2"].cid}" class="index_title_href">${qs["2"].cname}</a></h3>
				<div id="xwgk_bg"></div>
			</@indexQuestionList>
			<div id="xxgk">
				<h3><a href="qchannel/24" class="index_title_href">Activity</a></h3>
				<div id="xxgk_bg"></div>
				${xxgk.summary[0..360]}
			</div>
		</div>
		<div id="hdjx_jyky">
			<@indexQuestionList indexQuestion=qs["3"] titleSize=31 divId="hdjx" hrefClz="index_link">
				<span class="t_title">${qs["3"].cname}</span><span class="more"><a href="qchannel/${qs['3'].cid}">more</a></span>
			</@indexQuestionList>
			
			<@indexQuestionList indexQuestion=qs["4"] titleSize=31 divId="jyky" hrefClz="index_link">
				<span class="t_title">${qs["4"].cname}</span><span class="more"><a href="qchannel/${qs['4'].cid}">more</a></span>
			</@indexQuestionList>
		</div>
		<div id="chief_keyword">
			<div>
				<#list keywords as kw>
					<span class="keyword" href="qkeyword/${kw.name}">${kw.name}</span>
				</#list>
			</div>
		</div>
	</div>
</div>