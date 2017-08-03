<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/include.Taglib.jsp"%>
<html>
<head>
<title></title>
<base target="_self" />
<s:include value="/WEB-INF/pages/include/include.Scripts.jsp" />
<script type="text/javascript" src="<s:url value="/jquery/ui/jquery.ui.datepicker.min.js"/>"></script>
<script type="text/javascript">
</script>
</head>
<body>
<s:form method="post" theme="simple" action="%{progAction}" >
<s:hidden name="labSuppMst.ver" />
	<div class="progTitle">
		<s:include value="/WEB-INF/pages/include/include.ConfirmTitle.jsp" />
	</div>
	<div id="tb">
	<div>
		<table width="100%" border="0" cellpadding="4" cellspacing="0">
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="suppId"/>：</td>
				<td width="20%">
					<label>
						<s:property value="labSuppMst.suppId"/>
						<s:hidden name="labSuppMst.suppId" />
					</label>
				</td>					
				<td width="20%" class="colNameAlign required">*<s:text name="suppName"/>：</td>		
				<td width="20%">
					<label>
						<s:property value="labSuppMst.suppName"/>
						<s:hidden name="labSuppMst.suppName" />
					</label>
				</td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign">*<s:text name="suppTel"/>：</td>
				<td colspan="3">
				<label>
					<s:property value="labSuppMst.suppTel"/>
					<s:hidden name="labSuppMst.suppTel" />
				</label>
				</td>
			</tr>
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="address"/>：</td>
				<td colspan="3">
					<label>
						<s:property value="labSuppMst.address"/>
						<s:hidden name="labSuppMst.address" />
					</label>
				</td>
			</tr>
		</table>
	</div>
	</div>
	<br>
	<!-- 按鍵組合 --> 
	<s:include value="/WEB-INF/pages/include/include.ConfirmButton.jsp" />
	<!-- 按鍵組合 -->
</s:form>
</body>
</html>