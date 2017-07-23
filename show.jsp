<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/include.Taglib.jsp"%>
<html>
<head>
<title></title>
<base target="_self" />
<s:include value="/WEB-INF/pages/include/include.Scripts.jsp" />
</head>
<body>
<s:form method="post" theme="simple" action="%{progAction}" >
<s:hidden name="labSuppMst.ver" />
	<div class="progTitle">
		<s:include value="/WEB-INF/pages/include/include.ShowTitle.jsp" />
	</div>
	<div id="tb">
	<div>
		<table width="100%" border="0" cellpadding="4" cellspacing="0">
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="suppId"/>：</td>
				<td width="30%">
					<s:property value="labSuppMst.suppId"/>
				</td>					
				<td width="20%" class="colNameAlign required">*<s:text name="suppName"/>：</td>		
				<td width="30%">
					<s:property value="labSuppMst.suppName"/>
				</td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign">*<s:text name="suppTel"/>：</td>
				<td colspan="3">
					<s:property value="labSuppMst.suppTel"/>
				</td>
			</tr>
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="address"/>：</td>
				<td colspan="3">
					<s:property value="labSuppMst.address"/>
				</td>
			</tr>
		</table>
	</div>
	</div>
	<br>
	<!-- 按鍵組合 --> 
	<s:include value="/WEB-INF/pages/include/include.ShowButton.jsp" />
	<!-- 按鍵組合 -->
</s:form>
</body>
</html>