<%@ page language="java" import="java.util.*,com.qiheng.model.Person" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryAll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
		function del(){
			
			if(confirm("Really delete?")){
				return true;	
			}
			
				return false;
			
			
		}
	
	
	</script>

  </head>
  
  <body>
    <table align="center" width="80%" border="1">
    	<tr>
    		<th>username</th>
    		<th>password</th>
    		<th>age</th>
    		<th>registerDate</th>
    		<th>update</th>
    		<th>delete</th>
    		
    	</tr>
    	
    	
    	
    	
    	
    	
    	<s:iterator value="#request.list" id="person">
    	
    	<tr>
    		<td>
    			<s:a href="queryPerson.action?id=%{#person.id}"><s:property value="username"/></s:a>
    		</td>
    		
    		<td>
    			<s:property value="password"/>
    		</td>
    		<td>
    			<s:property value="age"/>
    		</td>
    		<td>
    			<s:property value="registerDate"/>
    		</td>
    		<td>
    			<s:a href="updatePerson.action?id=%{#person.id}">update</s:a>
    		</td>
    		<td>
    			<s:a href="deletePerson.action?id=%{#person.id}" onclick="return del()">delete</s:a>
    		</td>
    		
    	</tr>
    	
    	
    	</s:iterator>
    
    
    
    
    </table>
  </body>
</html>
