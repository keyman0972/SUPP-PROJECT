<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/include.Taglib.jsp"%>
<html>
<head>
<title></title>
<base target="_self" />
<s:include value="/WEB-INF/pages/include/include.Scripts.jsp" />
<script type="text/javascript" src="<s:url value="/jquery/ui/jquery.ui.datepicker.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/jquery/jquery.alphanumeric.js"/>"></script>		
<script type="text/javascript" src="<s:url value="/ddscPlugin/ddsc.validation.plugin.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/ddsc.input.js"/>"></script>
<script language="javascript">
function validate() {
	$("#frm01001K").validate("clearPrompt");
	$("#suppId").validateRequired({fieldText:'<s:text name="suppId" />'});
	$("#suppName").validateMail({fieldText:'<s:text name="suppName" />'});
	
	return $("#frm01001K").validate("showPromptWithErrors");
}
</script>
</head>
<body>
<s:form id="frm01001K" method="post" theme="simple" action="%{progAction}" target="ifrConfirm">
<s:hidden name="labSuppMst.ver" />
	<div class="progTitle">
		<s:include value="/WEB-INF/pages/include/include.EditTitle.jsp" />
	</div>
	<div id="tb">
	<div>
		<table width="100%" border="0" cellpadding="4" cellspacing="0" >
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="suppId"/>：</td>
				<td width="20%">
					<s:textfield cssClass="enKey" id="suppId" name="labSuppMst.suppId" value="%{labSuppMst.suppId}" readonly="progAction == 'updateSubmit'" size="16" maxlength="32"/>
				</td>					
				<td width="20%" class="colNameAlign required">*<s:text name="suppName"/>：</td>		
				<td width="20%">
					<s:textfield id="suppName" name="labSuppMst.suppName" value="%{labSuppMst.suppName}" size="16" maxlength="16"/>
				</td>
				<th style="display: none;">&nbsp;</th> 
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="suppTel"/>：</td>
				<td colspan="3">
					<s:textfield id="suppTel" name="labSuppMst.suppTel"  value="%{labSuppMst.suppTel}" maxlength="32" size="20" cssClass="numKey" />
				</td>
			</tr>
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="address"/>：</td>
				<td colspan="3">
					<s:textfield id="address" name="labSuppMst.address" value="%{labSuppMst.address}" maxlength="32" size="100"/>
				</td>
			</tr>
		</table>
	</div>
	</div>
	<br>
	<!-- 按鍵組合 --> 
	<s:include value="/WEB-INF/pages/include/include.EditButton.jsp" />
	<!-- 按鍵組合 --> 
</s:form>
<iframe id="ifrConfirm" name="ifrConfirm" width="100%" height="768" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="display:none; border: 0px none"></iframe>
</body>
</html>