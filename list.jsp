<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/include.Taglib.jsp"%>
<html>
<head>
<title></title>
<s:include value="/WEB-INF/pages/include/include.Scripts.jsp" />
<script type="text/javascript" src="<s:url value="/jquery/jquery.alphanumeric.js"/>"></script>
<script type="text/javascript" src="<s:url value="/ddscPlugin/ddsc.gridList.plugin.js"/>"></script>
<script type="text/javascript" src="<s:url value="/ddscPlugin/ddsc.popupWindow.plugin.js"/>"></script>	
<script type="text/javascript" src="<s:url value="/js/ddsc.input.js"/>"></script>
<script language="javascript">
function getParameter() {
	var param = "labSuppMst.suppId=" + $("#tblGrid").getSelectedRow().find('td').eq(2).text();
	return param;
}
$(document).ready(function() {
	$("#tblGrid").initGrid({lines:3});
	$('#tb').initPopupWindow({dailogWidth:'960', dailogHeight:'640'});
});
</script>
</head>
<body> 
<s:form id="frm01001K" theme="simple" action="%{progAction}" >
	<div class="progTitle">
  		<s:include value="/WEB-INF/pages/include/include.Title.jsp" />
	</div>
	<div id="tb">
		<fieldset id="listFieldset">
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="suppId"/>：</td>
				<td width="30%"><s:textfield name="labSuppMst.suppId" cssClass="enKey" maxlength="32" size="16"/></td>
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="suppName"/>：</td>
				<td width="30%"><s:textfield name="labSuppMst.suppName" maxlength="32" size="32"/></td>
			</tr>
			<s:if test='progInfo.inApprove == \"2\"'>
			<tr class="trBgOdd">
				<s:include value="/WEB-INF/pages/include/include.BatchButton.jsp" /><!-- 批次覆核按鍵組合 -->
				<td width="20%" class="colNameAlign">&nbsp;</td>
				<td width="30%"></td>
			</tr>
			</s:if>
		</table>
		<!-- 按鍵組合 --><s:include value="/WEB-INF/pages/include/include.ListButton.jsp" /><!-- 按鍵組合 --> 
		</fieldset>
		<table id="tblGrid" class ="labSuppMstList" width="100%" border="0" cellpadding="2" cellspacing="1">
			<thead>
				<tr align="center" bgcolor="#e3e3e3">
					<th width="30"><s:text name="fix.00164" /></th>
					<th width="120"><s:text name="fix.00090" /></th>
					<th width="20%"><s:text name="suppId" /></th>   
					<th width="25%"><s:text name="suppName" /></th> 
					<th width="15%"><s:text name="address" /></th>	
					<th><s:text name="suppTel" /></th>				
				</tr>
			 </thead>
			 <tbody>
				 <s:iterator value="labSuppMstList" status="status">
				 	<tr>
						<td width="30" id="sn" align="center"><s:property value="#status.index+1" /></td>
						<!-- 表單按鍵 --> 
						<td width="120"><s:include value="/WEB-INF/pages/include/include.actionButton.jsp" /></td>
						<!-- 表單按鍵 -->
						<td width="20%"><label><s:property value="SUPP_ID" /></label></td>
						<td width="25%"><label><s:property value="SUPP_NAME" /></label></td>
						<td width="15%"><label><s:property value="ADDRESS" /></label></td>	
						<td><label><s:property value="SUPP_TEL" /></label></td>
					</tr>
				 </s:iterator>
			 </tbody>
		</table>
	</div>
	<!-- 分頁按鍵列 --><s:include value="/WEB-INF/pages/include/include.PaginationBar.jsp" /><!-- 分頁按鍵列 -->
</s:form>
</body>
</html>